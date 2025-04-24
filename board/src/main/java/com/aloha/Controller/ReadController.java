package com.aloha.Controller;

import com.aloha.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadController {

    @FXML
    private Button btnList;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    void toList(ActionEvent event) throws Exception {
    	Main.setRoot("UI/List");
    }

    @FXML
    void toUpdate(ActionEvent event) throws Exception {
    	Main.setRoot("UI/Update");
    }

    public void passData(int boardNo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'passData'");
    }

}
