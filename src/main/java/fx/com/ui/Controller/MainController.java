package fx.com.ui.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;


public class MainController {
    public static HashMap<String, String> currentInfo = new HashMap<>();

    @FXML
    private TextField targetField;
    @FXML
    public ChoiceBox<String> setEncodeField;
    @FXML
    public ChoiceBox<String> s2_allField;
    @FXML
    public ChoiceBox<String> methodField;

    public MainController() {
    }

    @FXML
    private void initialize() {
        try {
            initMainInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMainInfo() {
        this.targetField.textProperty().addListener((observable, oldValue, newValue) -> currentInfo.put("Target", targetField.getText()));
        setEncodeField.setValue("UTF-8");
        setEncodeField.getItems().addAll("UTF-8", "GBK2312", "GBK");
        methodField.setValue("POST");
        methodField.getItems().addAll("POST", "GET", "UPLOAD");
        s2_allField.setValue("S2-ALL");
        s2_allField.getItems().addAll("S2-ALL",
                "S2-001", "S2-005", "S2-007", "S2-008",
                "S2-009", "S2-012", "S2-013", "S2-015", "S2-016", "S2-019",
                "S2-Dev", "S2-032", "S2-037", "S2-045", "S2-046"
        );
        currentInfo.put("useNum", null);
        s2_allField.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> currentInfo.put("useNum", newValue.toLowerCase().replace("2-", "")));
    }

}
