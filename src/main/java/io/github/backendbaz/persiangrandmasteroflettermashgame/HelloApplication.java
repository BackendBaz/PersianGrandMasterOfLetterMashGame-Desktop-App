package io.github.backendbaz.persiangrandmasteroflettermashgame;

import io.github.backendbaz.persiangrandmasteroflettermashgame.components.MainPageComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // call the component of this page:
        var component = new MainPageComponent();
        Scene scene = new Scene(component.getRoot(), component.WIDTH,
                component.HEIGHT);
        // import the CSS of font:
        scene.getStylesheets().add(Objects.requireNonNull(getClass()
                .getResource("/fonts/fontiran.css")).toExternalForm());
        // import the icon of main page:
        stage.getIcons().add(new Image(Objects.requireNonNull(
                HelloApplication.class.getResourceAsStream("/images/icon.png"))));
        // set the title of page:
        stage.setTitle("Persian Grandmaster of Letter Mash game (v1.0.0)");
        // set the scene:
        stage.setScene(scene);
        // set a min value for width and height:
        stage.setMinHeight(component.HEIGHT);
        stage.setMinWidth(component.WIDTH);
        // show the page:
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}