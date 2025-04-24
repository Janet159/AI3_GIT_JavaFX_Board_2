package com.aloha.Controller;

import com.aloha.Main;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController {

	@FXML
	private Button btnList;

	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnDelete;

	@FXML
	private TextArea taContent;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfWriter;

	private BoardService boardService = new BoardServiceImpl();

	int boardNo;

	public void passData(int boardNo) {
		this.boardNo = boardNo;
		Board board = boardService.select(boardNo);
		tfTitle.setText(board.getTitle());
		tfWriter.setText(board.getWriter());
		taContent.setText(board.getContent());
	}

	// 리스트 화면으로
	@FXML
	void toList(ActionEvent event) throws Exception {
		Main.setRoot("UI/List");
	}

	// 수정 버튼
	@FXML
	void update(ActionEvent event) throws Exception {
		Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText());
		board.setNo(boardNo);
		int result = boardService.update(board);
		if (result > 0) {
			System.out.println("수정완료");
			// 리스트 화면으로
			Main.setRoot("UI/List");
		}
	}

	// 삭제 버튼
	@FXML
	void delete(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("데이터 삭제");
		alert.setHeaderText("현재 게시글을 삭제하시겠습니까? no: " + boardNo);
		alert.setContentText("삭제 후에는 취소 할 수 없습니다.");

		int result = 0;
		if (alert.showAndWait().get() == ButtonType.OK) {
			result = boardService.delete(boardNo);
		}
		if (result > 0) {
			System.err.println("삭제 완료");
			// 리스트 화면으로
			Main.setRoot("UI/List");
		}
	}
}
