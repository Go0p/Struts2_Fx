package fx.com.ui.Controller;


import fx.com.Check.checkVul;
import fx.com.Payload.Spayload;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class FileUploadController {

    @FXML
    private TextField rootPathFileName;

    @FXML
    private Button rootUploadBut;


    @FXML
    private TextField realPathFileName;


    @FXML
    private Button customUploadBut;

    @FXML
    private TextArea showFileContent;

    @FXML
    private Label resUpload;

    public  String filename;
    public  String filecontent;
    public static HashMap<String, Object> textObjHashMap = new HashMap<>();


    @FXML
    private void initialize() {
        try {
            initRootUpload();
            initRealUpload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRootUpload() {
        rootUploadBut.setOnAction(event -> {
            textObjHashMap.put("Path", rootPathFileName);
            textObjHashMap.put("Content", showFileContent);
            textObjHashMap.put("Res", resUpload);
            MyTask task = new MyTask("upload");
            Thread t = new Thread(task);
            t.start();
        });
    }

    private void initRealUpload() {
        customUploadBut.setOnAction(event -> {
            textObjHashMap.put("Path", realPathFileName);
            textObjHashMap.put("Content", showFileContent);
            textObjHashMap.put("Res", resUpload);
            MyTask task = new MyTask("userupload");
            Thread t = new Thread(task);
            t.start();
        });
    }

}

class MyTask extends Task<String> {
    private final String vulntype;
    public  String filename;
    public  String filecontent;
    String target = MainController.currentInfo.get("Target");
    String ua = SettingController.setTing.get("UA");
    String cookie = SettingController.setTing.get("Cookie");
    String proxy = SettingController.setTing.get("Proxy");
    public MyTask(String vulntype) {
        this.vulntype = vulntype;
    }
    @Override
    protected void updateValue(String value) {
        super.updateValue(value);
        System.out.println(value);
        ((Label)FileUploadController.textObjHashMap.get("Res")).setText(value);
    }

    @Override
    protected String call() throws Exception {
        filename =((TextField)FileUploadController.textObjHashMap.get("Path")).getText();
        filecontent =((TextArea)FileUploadController.textObjHashMap.get("Content")).getText();
        String check;
        if (MainController.currentInfo.get("useNum") != null) {
            check = MainController.currentInfo.get("useNum");
        } else {
            check = VulTestViewController.currentInfo.get("Check");
        }
        if (MainController.currentInfo.get("useNum") == null && check == null) {
            return "[-] 请指定漏洞";
        }
        Map<String, String> uploadInfo = Spayload.builder()
                .selectModelAndVul(this.vulntype, check)
                .selectUpload(filename, filecontent, "")
                .VulInfo();
        String resp = checkVul.requestVul(target, uploadInfo, ua, cookie, proxy);
        return filename + " " + resp;
    }
}