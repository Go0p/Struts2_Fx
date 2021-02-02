package fx.com.ui.Controller;

import fx.com.Check.checkVul;
import fx.com.Payload.Spayload;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class ExecViewController {

    @FXML
    private TextField execTextField;

    @FXML
    private Button execButField;

    @FXML
    private TextArea execReqText;
    public static HashMap<String, Object> textExec = new HashMap<>();

    @FXML

    private void initialize() {
        try {
            initExec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initExec() {
        MyExecService mes = new MyExecService();
        textExec.put("resp", execReqText);
        execTextField.textProperty().addListener((observable, oldValue, newValue) -> textExec.put("exec", newValue));
        execButField.setOnAction(event -> {
            mes.reset();
            mes.start();
        });
    }
}

class MyExecService extends Service<String> {
    private String check = null;

    @Override
    protected Task<String> createTask() {
        String target = MainController.currentInfo.get("Target");
        String ua = SettingController.setTing.get("UA");
        String cookie = SettingController.setTing.get("Cookie");
        String proxy = SettingController.setTing.get("Proxy");
        String exec = (String) ExecViewController.textExec.get("exec");
        String osType = VulTestViewController.currentInfo.get("osType");
        return new Task<String>() {
            @Override
            protected void updateValue(String value) {
                super.updateValue(value);
                System.out.println("updateValue -" + value);
                if (!"".equals(value)) {
                    TextArea resp = (TextArea) ExecViewController.textExec.get("resp");
                    resp.appendText(value);
                }
                MyExecService.this.cancel();
            }

            @Override
            protected String call() throws Exception {
                System.out.println("exec call()");
                if (MainController.currentInfo.get("useNum") != null) {
                    check = MainController.currentInfo.get("useNum");
                } else {
                    check = VulTestViewController.currentInfo.get("Check");
                }
                Map<String, String> vulInfo = Spayload.builder()
                        .selectModelAndVul("exec", check)
                        .selectExec(exec, osType)
                        .VulInfo();
                System.out.println(vulInfo.toString());
                String resp = checkVul.requestVul(target, vulInfo, ua, cookie, proxy);
                System.out.println("call -" + resp);
                return resp;
            }
        };
    }
}