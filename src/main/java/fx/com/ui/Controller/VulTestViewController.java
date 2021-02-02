package fx.com.ui.Controller;

import fx.com.Check.checkVul;
import fx.com.Payload.Spayload;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.HashMap;
import java.util.Map;


public class VulTestViewController {
    @FXML
    private Button checkVulButField;
    @FXML
    private TextArea resConsoleField;
    public VulTestViewController() {
    }

    public static HashMap<String, String> currentInfo = new HashMap<>();
    public static HashMap<String, TextArea> textAreaHashMap = new HashMap<>();

    @FXML

    private void initialize() {
        try {
            initVulTesting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initVulTesting() {
        this.checkVulButField.setOnAction(event -> {
            MyScheduledService mss = new MyScheduledService();
            System.out.println("进入" + Thread.currentThread().getName());
            resConsoleField.clear();
            textAreaHashMap.put("TextArea", resConsoleField);
            mss.start();
        });
    }

}

class MyScheduledService extends ScheduledService<String> {
    String[] s2_list = Spayload.s2_list;
    int sum = -1;
    String target = MainController.currentInfo.get("Target");
    String ua = SettingController.setTing.get("UA");
    String cookie = SettingController.setTing.get("Cookie");
    String proxy = SettingController.setTing.get("Proxy");
    String resp = null;

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected void updateValue(String value) {
                super.updateValue(value);
                System.out.println("updateValue()");
                System.out.println("updateValue -" + value);
                System.out.println("updateValue() -Num " + sum);
                if (!"".equals(value)) {
                    VulTestViewController.textAreaHashMap.get("TextArea").appendText(value);
                }
                if (sum + 1 >= s2_list.length) {
                    MyScheduledService.this.cancel();
                    System.out.println("最后 -" + Thread.currentThread().getName());
                    if (VulTestViewController.currentInfo.get("Check") != null) {
                        Map<String, String> pathInfo = Spayload.builder()
                                .selectModelAndVul("path", VulTestViewController.currentInfo.get("Check"))
                                .VulInfo();
                        String resppath = checkVul.requestVul(target, pathInfo, ua, cookie, proxy);
                        VulTestViewController.currentInfo.put("osType", (resppath.indexOf(":") == 1) ? "WIN" : "LIN");
                        VulTestViewController.textAreaHashMap.get("TextArea").appendText("[+] 当前的目录:" + resppath);
                        Map<String, String> whoamiInfo = Spayload.builder()
                                .selectModelAndVul("exec", VulTestViewController.currentInfo.get("Check"))
                                .selectExec("whoami")
                                .VulInfo();
                        String respwhoami = checkVul.requestVul(target, whoamiInfo, ua, cookie, proxy);
                        VulTestViewController.textAreaHashMap.get("TextArea").appendText(respwhoami);
                    }
                }
                if (VulTestViewController.textAreaHashMap.get("TextArea").getText() == null) {
                    VulTestViewController.textAreaHashMap.get("TextArea").appendText("[-] 未发现漏洞!");
                }
            }

            @Override
            protected String call() {
                sum = sum + 1;
                System.out.println("call()" + Thread.currentThread().getName());
                System.out.println("call() - " + sum + "/" + s2_list.length);
                Map<String, String> vulInfo = Spayload.builder()
                        .selectModelAndVul("poc", s2_list[sum])
                        .VulInfo();
                resp = checkVul.requestVul(target, vulInfo, ua, cookie, proxy);
                if (resp.contains("[+]")) {
                    VulTestViewController.currentInfo.put("Check", s2_list[sum]);
                }
                System.out.println("call -" + resp);
                return resp;
            }
        };

    }
}