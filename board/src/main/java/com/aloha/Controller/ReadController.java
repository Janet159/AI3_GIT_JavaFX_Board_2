package com.aloha.Controller;

import com.aloha.Main;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

  int boardNo;
  private BoardService boardService = new BoardServiceImpl();

  @FXML
  void toList(ActionEvent event) throws Exception {
    Main.setRoot("UI/List");
  }

  @FXML
  void toUpdate(ActionEvent event) throws Exception {
    String fxml = "UI/Update";
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
    Parent root = (Parent) fxmlLoader.load();
    UpdateController updateController = (UpdateController) fxmlLoader.getController();
    updateController.passData(this.boardNo);
    Main.setRoot(root);
  }

  public void passData(int boardNo) {
    this.boardNo = boardNo;
    System.out.println("no : " + boardNo);
    Board board = this.boardService.select(boardNo);
    this.tfTitle.setText(board.getTitle());
    this.tfWriter.setText(board.getWriter());
    this.taContent.setText(board.getContent());
  }

}
