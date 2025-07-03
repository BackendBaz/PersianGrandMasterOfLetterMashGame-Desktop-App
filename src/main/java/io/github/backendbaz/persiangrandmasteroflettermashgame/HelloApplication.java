package io.github.backendbaz.persiangrandmasteroflettermashgame;

import io.github.backendbaz.persiangrandmasteroflettermashgame.components.MainPageComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // call the component of this page:
        var component = new MainPageComponent();
        // set the root layout:
        var rootLayout = component.getRoot();
        rootLayout.getChildren().addAll(
                component.getMenuBar(rootLayout) // import a Menu Bar
        );
        Scene scene = new Scene(rootLayout, component.WIDTH,
                component.HEIGHT);
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