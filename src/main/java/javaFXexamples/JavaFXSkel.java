package javaFXexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkel extends Application {
    public static void main(String[] args) {
        System.out.println("Зaпycк приложения JavaFX");
        launch(args); // Запустить приложение JavaFX, вызвав метод launch()
    }

    // Переопределить метод init(), вуполняется до метода start()
    public void init(){
        System.out.println("B теле метода init()");
    }

    // Переопределить иначе ошибка
    public void start(Stage myStage){
        System.out.println("B теле метода start()");
        myStage.setTitle("Kapкac приложения JavaFX"); // Установить заголовок окна приложения
        // Создать корневой узел. В данном случае используется плавающая компоновка, но возможны и другие варианты.
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 300, 200); // Создать сцену
        myStage.setScene(myScene); // Установить сцену на платформе
        myStage.show(); // Отобразить платформу вместе с ее сценой
    }

    // Переопределить метод stop().
    public void stop(){
        System.out.println("B теле метода stop()");
    }
}
