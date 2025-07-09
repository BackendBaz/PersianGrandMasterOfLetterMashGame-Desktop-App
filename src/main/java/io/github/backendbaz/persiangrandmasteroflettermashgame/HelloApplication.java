package io.github.backendbaz.persiangrandmasteroflettermashgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    public final double WIDTH = 800;
    public final double HEIGHT = 600;

    @Override
    public void start(Stage stage) throws IOException {
        // load the FXML file:
        var fXMLFile = new FXMLLoader(HelloApplication.class
                .getResource("main-page.fxml"));
        Scene scene = new Scene(fXMLFile.load(), WIDTH, HEIGHT);
        // import the icon of main page:
        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication
                .class.getResourceAsStream("/images/icon.png"))));
        // set the title of page:
        stage.setTitle("Persian Grandmaster of Letter Mash game (v1.1.1)");
        // set the scene:
        stage.setScene(scene);
        // set a min value for width and height:
        stage.setMinHeight(HEIGHT);
        stage.setMinWidth(WIDTH);
        // disable the resizable:
        stage.setResizable(false);
        // show the page:
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}