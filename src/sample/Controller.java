package sample;


import db.DBConnection;
import Classes.User;
import Classes.encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    DBConnection dbcon= new DBConnection();
    ResultSet rs;
    PreparedStatement ps;
    User user;
    encryption enc;
    @FXML
    void onCloseClick(ActionEvent event) throws Exception{

        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();


    }

    @FXML
    void switchtotest(ActionEvent event) throws Exception {
        enc= new encryption();
        user = new User();
        if(txtname.getText().matches("^[a-zA-Z]+$") && txtpw.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")){
            user.setUsername(txtname.getText());
            user.setPassword(enc.encryptPass(txtpw.getText()));
        }

        try{
            Connection con= dbcon.getConnection();
            String query = "SELECT U_Name,U_Password,usertype FROM user WHERE U_Name=? AND U_Password=?";
            ps = con.prepareStatement(query);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs= ps.executeQuery();
            if(rs.next()){
                if(rs.getString("usertype").equals("admin")){
                    root = FXMLLoader.load(getClass().getResource("admin_nav.fxml"));
                }
                else{
                    root = FXMLLoader.load(getClass().getResource("user_nav.fxml"));
                }

                stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
