package com.aloha;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Main"));
        stage.setScene(scene);

        Image icon = new Image(getClass().getResource("/com/aloha/icon.png").toString());
		stage.getIcons().add(icon);
		stage.setTitle("미니 2조 게시판");
		stage.setResizable(false);
		stage.show();

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Parent root 를 가져와서 화면 이동
     */
    public static void setRoot(Parent root) throws IOException {
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void exit(ActionEvent event) throws Exception{
        Stage stage = (Stage) scene.getWindow();
		stage.close();
    }

}