package com.example.currencychartfxmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // график
        BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("currencychart.fxml")));
        primaryStage.getIcons().add(new Image("file:/" +  new File("").getAbsolutePath() + File.separator + "icon.png"));
        primaryStage.setTitle("Изменение курса валют");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Преобразование текста в число
    static double getString_Double(String string)
    {
        String string_new  = string.replace(",", ".");
        if (string_new.isEmpty()) { return 0; }
        try {
            return Double.parseDouble(string_new);
        } catch (Exception e) {
            return 0;
        }
    }

    // проверка значения - Double
    public static boolean checkString_Double(String string)
    {
        String string_new  = string.replace(",", ".");
        if (!string_new.isEmpty()) {
            try {
                Double.parseDouble(string_new);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    // вывод диалогового окна
    static void MessageBoxError(String infoMessage, String infoHeader)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка:");
        alert.setHeaderText(infoHeader);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    // вывод диалогового окна - Да/Нет
    static boolean MessageBoxYesNo(String infoMessage, String infoHeader)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Предупреждение:");
        alert.setHeaderText(infoHeader);
        alert.setContentText(infoMessage);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.YES;
    }

    // вывод диалогового окна - Да/Нет
    static void MessageBoxWarn(String infoMessage, String infoHeader)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение:");
        alert.setHeaderText(infoHeader);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}
