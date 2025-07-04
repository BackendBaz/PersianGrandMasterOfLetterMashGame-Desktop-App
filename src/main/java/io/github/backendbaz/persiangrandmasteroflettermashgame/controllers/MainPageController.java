package io.github.backendbaz.persiangrandmasteroflettermashgame.controllers;

import io.github.backendbaz.persiangrandmasteroflettermashgame.HelloApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainPageController extends Application {

    @FXML private VBox root;
    @FXML private Label systemMessageLabel;
    @FXML private ProgressBar loadingBar;
    @FXML private ScrollPane scrollContainer;
    @FXML private HBox controlPanel;
    @FXML private VBox containerOfWords;
    @FXML private TextField box_1;
    @FXML private TextField box_2;
    @FXML private TextField box_3;
    @FXML private TextField box_4;
    @FXML private TextField box_5;
    @FXML private TextField box_6;
    @FXML private TextField box_7;
    @FXML private TextField box_8;
    @FXML private TextField box_9;
    @FXML private TextField box_10;
    @FXML private TextField box_11;
    @FXML private TextField box_12;
    @FXML private TextField box_13;
    @FXML private TextField box_14;
    @FXML private TextField box_15;
    @FXML private TextField box_16;
    private final List<TextField> boxes = new ArrayList<>();

    // It runs once when the page is starting:
    public void initialize() {
        // define a list of textFields:
        boxes.addAll(List.of(
                box_1,
                box_2,
                box_3,
                box_4,
                box_5,
                box_6,
                box_7,
                box_8,
                box_9,
                box_10,
                box_11,
                box_12,
                box_13,
                box_14,
                box_15,
                box_16
        ));
        // set up autofocus event for all textFields:
        setupAutoFocus();
        // prepare items to search:
        prepareOrReset(false);
    }

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
        vBox.getChildren().add(new Separator());
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

    private void setupAutoFocus() {
        for (var i = 0; i < boxes.size(); i++) {
            TextField current = boxes.get(i);
            int finalI = i;
            current.setOnKeyTyped(event -> {
                var letter = event.getCharacter();
                if (isPersianLetter(letter)) {
                    current.setText(letter);
                    if (finalI < boxes.size() - 1) {
                        Platform.runLater(() -> {
                            boxes.get(finalI + 1).requestFocus();
                            boxes.get(finalI + 1).selectAll();
                        });
                        return;
                    }
                    Platform.runLater(() -> {
                        boxes.getFirst().requestFocus();
                        boxes.getFirst().selectAll();
                    });
                    return;
                }
                current.setText("");
            });
        }
    }

    private boolean isPersianLetter(String letter) {
        return "ضصثقفغعهخحجچشسیبلاتنمکگپظطزژرذدو".contains(letter);
    }

    // show or hide items to search:
    private void prepareOrReset(boolean status) {
        scrollContainer.setVisible(false);
        systemMessageLabel.setVisible(false);
        loadingBar.setVisible(status);
        for (var box : boxes) box.setDisable(status);
        for (var button : controlPanel.getChildren())
            button.setDisable(status);
    }

    @Override
    public void start(Stage stage) {}

}
