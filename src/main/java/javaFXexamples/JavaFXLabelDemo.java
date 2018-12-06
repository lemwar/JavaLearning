package javaFXexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class JavaFXLabelDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Label в javaFX");
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 400, 400);
        primaryStage.setScene(myScene);

        Label label = new Label("Test label very long long long long long long long long long longlonglong long");
        rootNode.getChildren().add(label);

        Label label2 = new Label("Second hand label");
        Label label3 = new Label("Third hand label");
        rootNode.getChildren().addAll(label2, label3);

        Label label4 = new Label("4 label");
        rootNode.getChildren().add(label4);

        primaryStage.show();
    }
}
