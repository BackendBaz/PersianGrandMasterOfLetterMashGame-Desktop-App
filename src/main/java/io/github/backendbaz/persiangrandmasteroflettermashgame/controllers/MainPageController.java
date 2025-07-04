package io.github.backendbaz.persiangrandmasteroflettermashgame.controllers;

import io.github.backendbaz.persiangrandmasteroflettermashgame.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Objects;

public class MainPageController extends Application {

    @FXML private VBox root;

    // It runs once when the page is starting:
    public void initialize() {}

    @FXML
    private void showDeveloperPageOnClick() {
        // get the window of owner:
        var ownerStage = (Stage) root.getScene().getWindow();
        Stage developerStage = new Stage();
        developerStage.setTitle("Developer Information");
        developerStage.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        Scene scene = new Scene(vBox, 400, 300);
        developerStage.getIcons().add(new Image(Objects.requireNonNull(
                HelloApplication.class.getResourceAsStream("/images/icon.png"))));
        scene.getStylesheets().add(Objects.requireNonNull(getClass()
                .getResource("/fonts/fontiran.css")).toExternalForm());
        vBox.getChildren().add(textsInShowDeveloperPage("امیرحسین عمادی"));
        vBox.getChildren().add(textsInShowDeveloperPage("Amirhossein Emadi"));
        var sep = new Separator();
        vBox.getChildren().add(sep);
        vBox.getChildren().add(linksInShowDeveloperPage("GitHub",
                "https://github.com/BackendBaz"));
        vBox.getChildren().add(linksInShowDeveloperPage("Telegram",
                "https://t.me/amir_hossein_emadi_2000"));
        developerStage.setScene(scene);
        developerStage.initOwner(ownerStage);
        developerStage.setResizable(false);
        developerStage.show();
    }

    private Label textsInShowDeveloperPage(String text) {
        var lbl = new Label();
        lbl.getStyleClass().add("words-text-font");
        lbl.setWrapText(true);
        lbl.setText(text);
        lbl.setTextAlignment(TextAlignment.CENTER);
        return lbl;
    }

    private Hyperlink linksInShowDeveloperPage(String name, String url) {
        var hyperLink = new Hyperlink();
        hyperLink.getStyleClass().add("result-text-font");
        hyperLink.setText(name);
        hyperLink.setUnderline(true);
        hyperLink.setTextAlignment(TextAlignment.CENTER);
        hyperLink.setWrapText(true);
        hyperLink.setOnAction(event -> getHostServices()
                .showDocument(url));
        return hyperLink;
    }

    @Override
    public void start(Stage stage) {}

}
