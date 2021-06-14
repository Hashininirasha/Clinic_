package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class user_nav_Controller implements Initializable {

    @FXML
    private AnchorPane windowPane;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnTokenWindow;

    @FXML
    private Button btnAddPatient;

    @FXML
    private Button btnUserDetiail;

    @FXML
    private Button btnChangePwd;

    AnchorPane root;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
             root = FXMLLoader.load(getClass().getResource("give_token-2.fxml"));
            windowPane.getChildren().addAll(root);
        }catch (Exception e){
            return;
        }

    }

    @FXML
    void onCloseClick(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }



    @FXML
    void onClickToken(ActionEvent event) throws IOException{
         root = FXMLLoader.load(getClass().getResource("give_token-2.fxml"));
        windowPane.getChildren().addAll(root);
    }

    @FXML
    void onClickAddPatient(ActionEvent event) throws IOException {

         root = FXMLLoader.load(getClass().getResource("add_Patient-3.fxml"));
        windowPane.getChildren().addAll(root);
    }

    @FXML
    void onClickChangePwd(ActionEvent event)  throws IOException{
        root = FXMLLoader.load(getClass().getResource("Change_pw-5.fxml"));
        windowPane.getChildren().addAll(root);
    }

    @FXML
    void onClickUserDetail(ActionEvent event)  throws IOException{
        root = FXMLLoader.load(getClass().getResource("User_Details-4.fxml"));
        windowPane.getChildren().addAll(root);
    }
}
