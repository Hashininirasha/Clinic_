package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField txtname;

    @FXML
    private Button login;

    @FXML
    private PasswordField txtpw;

    @FXML
    private Button btnClose;

    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    void onCloseClick(ActionEvent event) throws Exception{

        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();


    }

    @FXML
    void switchtotest(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("user_nav.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
