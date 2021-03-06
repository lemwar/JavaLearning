package javaFXexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class JavaFXEventDemo extends Application {
    Label response;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Event Demo");
        FlowPane pane = new FlowPane(20, 20); // зазоры между контролами (кнопками и лэйблом)
        pane.setAlignment(Pos.CENTER); // центрируем все элементы на панели
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);

        Button buttonUp = new Button("Up");
        Button buttonDown = new Button("Down");
        response = new Label("Push a button");

        // передается анонимный класс, реализующий метод handle() функционального интерфейса EventHandler
        buttonUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("You pressed Up.");
            }
        });

        // а можно было реализовать метод handle() при помощи лямбды
        buttonDown.setOnAction((event) -> response.setText("You pressed Down."));

        pane.getChildren().addAll(response, buttonDown, buttonUp);
        primaryStage.show();
    }
}
