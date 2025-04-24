package com.aloha.Controller;

import com.aloha.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {



    @FXML
    private Button btnList;

    @FXML
    private Button btnExit;

    @FXML
    void list(ActionEvent event) throws Exception {
    	Main.setRoot("UI/List");
    }

    @FXML
    void exit(ActionEvent event) throws Exception  {
    	Main.exit(event);
    }

}
