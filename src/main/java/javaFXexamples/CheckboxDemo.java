package javaFXexamples;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckboxDemo extends Application {
    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbLaptop;
    CheckBox cbDesktop;

    Label response;
    Label selected;

    String computers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Checkbox demo");

        cbSmartphone = new CheckBox("Smartphone");
        cbTablet = new CheckBox("Tablet");
        cbLaptop = new CheckBox("Laptop");
        cbDesktop = new CheckBox("Desktop");
        response = new Label("");
        selected = new Label("");

        FlowPane pane = new FlowPane(Orientation.VERTICAL,10, 10);
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        // можно добавлять контролы даже после show()
        pane.getChildren().addAll(cbSmartphone, cbTablet, cbLaptop, cbDesktop, response, selected);

        try {
            Thread.sleep(2000); // поток творит магию, программа ждет пока пройдет 2 сек и не добавляет контролы на панель
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // создаем новую сцену, прикручиваем к primaryStage
        // отобразится в том же окне через 2 сек
        FlowPane pane2 = new FlowPane(20, 20);
        Scene scene2 = new Scene(pane2, 300, 300);
        primaryStage.setScene(scene2);
        primaryStage.show();

        // создаем второй stage, прикручиваем первую сцену
        // отобразится в новом окне, всего 2 окна отображено
        // программа не завершится пока не закроем все окна, причем порядок закрытия неважен
        Stage secondStage = new Stage();
        secondStage.setScene(scene);
        secondStage.show();

        cbSmartphone.setOnAction((event) -> {
            if(cbSmartphone.isSelected())
                response.setText("Smartphone was just selected.");
            else
                response.setText("Smartphone was just cleared.");
            showAll();
        });

        cbDesktop.setOnAction((event) -> {
            if(cbDesktop.isSelected())
                response.setText("Desktop was just selected.");
            else
                response.setText("Desktop was just cleared.");
            showAll();
        });

        cbLaptop.setOnAction((event) -> {
            if(cbLaptop.isSelected())
                response.setText("Laptop was just selected.");
            else
                response.setText("Laptop was just cleared.");
            showAll();
        });

        cbTablet.setOnAction((event) -> {
            if(cbTablet.isSelected())
                response.setText("Tablet was just selected.");
            else
                response.setText("Tablet was just cleared.");
            showAll();
        });
    }

    void showAll(){
        computers = "";
        if(cbSmartphone.isSelected()) computers = "Smartphone ";
        if(cbDesktop.isSelected()) computers += " Desktop ";
        if(cbLaptop.isSelected()) computers += " Laptop ";
        if(cbTablet.isSelected()) computers += " Tablet";
        selected.setText(computers);
    }
}
