package com.aloha.Controller;

import java.util.List;
import com.aloha.Main;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListController {

	@FXML
	private TableView<Board> boardTableView;

	@FXML
	private TableColumn<Board, Integer> colNo;

	@FXML
	private TableColumn<Board, String> colTitle;

	@FXML
	private TableColumn<Board, String> colWriter;

	@FXML
	private TableColumn<Board, String> colDate;

	@FXML
	private TableColumn<Board, Integer> colView;

	@FXML
	private Button btnCreate;

	@FXML
	private Button btnMain;

	List<Board> boardList = null;

	private BoardService boardService = new BoardServiceImpl();

	@FXML
	public void initialize() {
		boardList = boardService.list();

		colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
		colView.setCellValueFactory(new PropertyValueFactory<>("View"));

		ObservableList<Board> list = FXCollections.observableArrayList(boardList);
		boardTableView.setItems(list);

		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				// double clicked
				if (event.getClickCount() == 2 && boardTableView.getSelectionModel().getSelectedItem() != null) {
					int boardNo = boardTableView.getSelectionModel().getSelectedItem().getNo();

					try {
						String fxml = "UI/Read";
						FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
						Parent root = fxmlLoader.load();
						ReadController readController = (ReadController) fxmlLoader.getController();
						readController.passData(boardNo);
						Main.setRoot(root);
					} catch (Exception e) {
						System.err.println("List -> Read Error...");
						e.printStackTrace();
					}
				}
			}

		});

	}

	@FXML
	void toCreate(ActionEvent event) throws Exception {
		Main.setRoot("UI/Insert");
	}

	@FXML
	void toHome(ActionEvent event) throws Exception{
		Main.setRoot("UI/Main");
	}

	@FXML
	void ListDelete(ActionEvent event) throws Exception{
			Board selected = boardTableView.getSelectionModel().getSelectedItem();
			int boardNo = selected.getNo();
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


