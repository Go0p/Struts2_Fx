package fx.com.ui.Controller;

import fx.com.Check.checkVul;
import fx.com.Payload.Spayload;
import fx.com.Utils.RandomUtils;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import sun.tools.jstat.Scale;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FileVulCheckViewTab {

    //设置线程
    @FXML
    private ChoiceBox<Integer> threadNumID;
    //    文件路径
    @FXML
    private TextField filePathID;
    //    导入按钮
    @FXML
    private Button loadFileID;

    //开始按钮
    @FXML
    private Button startCheckID;
    //停止按钮
    @FXML
    private Button stopCheckID;
    //输出按钮
    @FXML
    private Button outPutID;
    //清楚按钮
    @FXML
    private Button cleanAllID;


    //表格
    @FXML
    private TableView<HashMap<String, String>> tableViewID;
    //    id编号
    @FXML
    private TableColumn<HashMap<String, String>, String> idColumnID;
    //    url
    @FXML
    private TableColumn<HashMap<String, String>, String> urlColumnID;
    //    是否存在漏洞
    @FXML
    private TableColumn<HashMap<String, String>, String> isvulnColumnID;
    //listview的根
    @FXML
    private StackPane spListurlID;
    //    file中的url
    @FXML
    private ListView<String> urlListID;
    //    展开listview
    @FXML
    private Button unfoldListID;
    //    收回listview
    @FXML
    private Button regainListID;
    //    总数
    @FXML
    private Label totalNumID;
    //完成数
    @FXML
    private Label alreadyID;
    //未完成
    @FXML
    private Label unfinishedID;
    //活动的线程数
    @FXML
    private Label activeThreadID;
    //    进度条
    @FXML
    private ProgressBar progressID;
    private String resp = null;
    private int alreadyNum = 0;

    private final ObservableList<HashMap<String, String>> obsList = FXCollections.observableArrayList();

    private ExecutorService exec;

    @FXML
    private void initialize() {
        try {
            initTableView();
            initThreadPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTableView() {
        this.threadNumID.setValue(10);
        this.threadNumID.getItems().addAll(5, 10, 15, 20, 32);
        this.urlListID.setPlaceholder(new Label("没有导入URL!"));
        setFileLoad();
        setShowUrlList();
        setBatchTest();
        setCleanTable();
        setResults2File();

    }

    private void initThreadPool() {//设置线程池
        FileVulCheckViewTab.this.exec = Executors.newFixedThreadPool(threadNumID.getValue(), runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        threadNumID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                FileVulCheckViewTab.this.exec = Executors.newFixedThreadPool(newValue, runnable -> {
                    Thread t = new Thread(runnable);
                    t.setDaemon(true);
                    return t;
                });
            }
        });
    }

    private void setFileLoad() {//导入txt文件
        this.loadFileID.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("请选择要批量的TXT文件");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("文本类型", "*.txt"));
            File path = fc.showOpenDialog(new Stage());
            Task<List<String>> task = new Task<List<String>>() {
                @Override
                protected void updateValue(List<String> value) {
                    super.updateValue(value);
                    if (value == null) {
                        return;
                    }
                    urlListID.getItems().addAll(value);
                    totalNumID.setText(String.valueOf(value.size()));
                    unfoldListID.fire();
                }

                @Override
                protected List<String> call() throws Exception {
                    if (path == null) {
                        return null;
                    }
                    filePathID.setText(path.getAbsolutePath());
                    return getFileUrlList();
                }
            };
            Thread t = new Thread(task);
            t.start();
        });
    }

    private void setShowUrlList() {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), spListurlID);
        tt.setInterpolator(Interpolator.EASE_OUT);
        unfoldListID.setOnAction(event -> {
            tt.setFromX(-250);
            tt.setToX(0);
            tt.play();
        });
        regainListID.setOnAction(event -> {
            tt.setFromX(0);
            tt.setToX(-250);
            tt.play();
        });
    }

    private void setBatchTest() {   // 点击开始按钮
        startCheckID.setOnAction(event -> {
            if ("".equals(filePathID.getText())) {
                return;
            }
            regainListID.fire();
            stopCheckID.setDisable(false);
            String ua = SettingController.setTing.get("UA");
            String cookie = SettingController.setTing.get("Cookie");
            String proxy = SettingController.setTing.get("Proxy");
            List<String> urlList = getFileUrlList();
            int urlListSize = urlList.size();
            int activeThreadNum = 0;
            for (int i = 0; i < urlListSize; i++) {
                String target = urlList.get(i);
                int id = i + 1;
                Task<HashMap<String, String>> task = new Task<HashMap<String, String>>() {

                    @Override
                    protected void updateValue(HashMap<String, String> value) {
                        super.updateValue(value);
                        alreadyNum += 1;
                        alreadyID.setText(String.valueOf(alreadyNum));
                        unfinishedID.setText(String.valueOf(urlListSize - alreadyNum));
                        progressID.setProgress((double) alreadyNum / urlListSize);
                        if (alreadyNum == urlListSize) {
                            stopCheckID.setDisable(true);
                        }
                        if (value.size() > 1) {
                            setCheckResult(value);
                        }
                    }

                    @Override
                    protected HashMap<String, String> call() throws Exception {
//                        System.out.println("call()" + Thread.currentThread().getName());
                        HashMap<String, String> results = new HashMap<>();
                        StringBuilder vuls = new StringBuilder("|");
                        for (String vul : Spayload.s2_list) {
//                            System.out.println("call() -" + vul);
//                            System.out.println("call() -" + target);
                            Map<String, String> vulInfo = Spayload.builder()
                                    .selectModelAndVul("poc", vul)
                                    .VulInfo();
                            resp = checkVul.requestVul(target, vulInfo, ua, cookie, proxy);
                            if (!"".equals(resp)) {
                                vuls.append(vul).append("|");
                                results.put("ID", String.valueOf(id));
                                results.put("Target", target);
                                results.put("isVuln", String.valueOf(vuls));
                            }
                        }
                        return results;
                    }
                };
//                System.out.println("Main -" + Thread.currentThread().getName());
                exec.execute(task);
                task.stateProperty().addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        System.out.println(newValue);
                    }
                });
                activeThreadNum = ((ThreadPoolExecutor) exec).getActiveCount();
                activeThreadID.setText(String.valueOf(activeThreadNum));
                stopCheckID.setOnAction(event1 -> task.cancel());
            }
            exec.shutdown();
//            System.out.println("xxxxxxxxxxxxx " + exec.isTerminated());
//            System.out.println("yyyyyyyyyyyyy " + exec.isShutdown());
            System.out.println("xxxxxxx " + ((ThreadPoolExecutor) exec).getActiveCount());
            activeThreadID.setText(String.valueOf(activeThreadNum));
        });
    }

    private void setCleanTable() {
        cleanAllID.setOnAction(event -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES);
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.NO);
            Button cleanYES = (Button) dialog.getDialogPane().lookupButton(ButtonType.YES);
            Button cleanNO = (Button) dialog.getDialogPane().lookupButton(ButtonType.NO);
            dialog.setTitle("清空结果");
            if (obsList.size() > 0) {
                dialog.setContentText("是否清空结果！");
                cleanYES.setOnAction(event1 -> tableViewID.getItems().clear());
            } else {
                dialog.setContentText("没得内容！");
                cleanYES.setOnAction(event1 -> dialog.close());
            }
            cleanNO.setOnAction(event1 -> dialog.close());

            dialog.show();
        });
    }

    private void setResults2File() {
        outPutID.setOnAction(event -> {
            if (obsList.size() > 0) {

                FileChooser fc = new FileChooser();
//                dc.setInitialDirectory(new File("")); //设置默认打开的路径
                fc.setTitle("选择导出路径");
                fc.setInitialFileName("results");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("文本类型", "*.txt"));
                File file = fc.showSaveDialog(new Stage());
                Task<Boolean> task = new Task<Boolean>() {
                    @Override
                    protected void updateValue(Boolean value) {
                        super.updateValue(value);
                        if (value) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setContentText("文件导出成功!");
                            alert.show();
                        }

                    }

                    @Override
                    protected Boolean call() throws Exception {
                        if (file == null) {
                            return null;
                        }
                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                            for (HashMap<String, String> str : obsList) {
                                osw.write(str.get("Target"));
                                osw.write(System.getProperty("line.separator"));
                            }
                            osw.close();
                            fos.close();
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return false;
                    }
                };
                Thread t = new Thread(task);
                t.start();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("导出内容为空！");
                alert.show();
            }
        });


    }


    private void setCheckResult(HashMap<String, String> hm) {
        System.out.println("setCheckResult -" + hm.toString());
        obsList.add(hm);
        idColumnID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get("ID")));
        urlColumnID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get("Target")));
        isvulnColumnID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get("isVuln")));
        tableViewID.setItems(obsList);
//        tableViewID.getColumns().addAll(idColumnID,urlColumnID,isvulnColumnID);
    }

    private List<String> getFileUrlList() {

        return RandomUtils.txt2UrlList(filePathID.getText());
    }

}