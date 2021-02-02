package fx.com.ui.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

public class SettingController {
    public static HashMap<String, String> setTing = new HashMap<>();
    @FXML
    private TextField proxyField;
    @FXML
    private TextArea uaTextArea;
    @FXML
    private TextArea cookieTextArea;
    @FXML
    private CheckBox checkproxy;

    @FXML
    private void initialize() {
        try {
            initSetting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initSetting() {
        setTing.put("Proxy", "");
        this.checkproxy.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                setTing.put("Proxy", proxyField.getText());
            }else {
                setTing.put("Proxy", "");
            }
        });

        setTing.put("UA", uaTextArea.getText());
        setTing.put("Cookie", cookieTextArea.getText());
    }
}
