package io.github.backendbaz.persiangrandmasteroflettermashgame.controllers;

import io.github.backendbaz.core.Dictionary;
import io.github.backendbaz.core.Finder;
import io.github.backendbaz.exceptions.InvalidLettersException;
import io.github.backendbaz.models.Word;
import io.github.backendbaz.persiangrandmasteroflettermashgame.HelloApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
    @FXML private Label badge_1;
    @FXML private Label badge_2;
    @FXML private Label badge_3;
    @FXML private Label badge_4;
    @FXML private Label badge_5;
    @FXML private Label badge_6;
    @FXML private Label badge_7;
    @FXML private Label badge_8;
    @FXML private Label badge_9;
    @FXML private Label badge_10;
    @FXML private Label badge_11;
    @FXML private Label badge_12;
    @FXML private Label badge_13;
    @FXML private Label badge_14;
    @FXML private Label badge_15;
    @FXML private Label badge_16;
    @FXML private ComboBox<String> pointComboBox;
    private final List<TextField> boxes = new ArrayList<>();
    private final List<Label> badges = new ArrayList<>();
    private String highScoreLetter = "همه";
    private CompletableFuture<Dictionary> dictionaryFuture;

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
        // define a list of badges:
        badges.addAll(List.of(
                badge_1,
                badge_2,
                badge_3,
                badge_4,
                badge_5,
                badge_6,
                badge_7,
                badge_8,
                badge_9,
                badge_10,
                badge_11,
                badge_12,
                badge_13,
                badge_14,
                badge_15,
                badge_16
        ));
        // set up autofocus event for all textFields:
        setupAutoFocus();
        // prepare items to search:
        prepareOrReset(true);
        // set up pointComboBox's options:
        String[] options = {"همه", "1", "2", "3", "4",
                "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16"};
        pointComboBox.getItems().addAll(options);
        pointComboBox.setOnAction(event ->
                highScoreLetter = pointComboBox.getSelectionModel()
                        .getSelectedItem());
        // load words from the dictionary (Async):
        dictionaryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                prepareOrReset(false);
                return new Dictionary().load(Dictionary.PATH);
            } catch (Exception e) {
                return null;
            }
        });
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

    @FXML
    private void deleteAll() {
        scrollContainer.setVisible(false);
        systemMessageLabel.setVisible(false);
        for (var box : boxes) box.setText("");
        clearBgLetters();
        Platform.runLater(() -> {
            boxes.getFirst().requestFocus();
            boxes.getFirst().selectAll();
        });
    }

    @FXML
    private void search() {
        prepareOrReset(true);
        clearBgLetters();
        var builder = new StringBuilder();
        for (var box : boxes) builder.append(box.getText()).append(" ");
        String inputs = builder.toString().trim();
        try {
            Dictionary dictionary = dictionaryFuture.get();
            if (dictionary == null) throw new Exception();
            Finder finder = new Finder(inputs);
            List<Word> results = finder.findTopWords(dictionary, 3,
                    highScoreLetter);
            getWordsFromPG(results);
        } catch (InvalidLettersException e) {
            prepareOrReset(false);
            showSystemMessage("برخی از حروف وارد نشده اند یا " +
                    "دارای کاراکتر نامعتبر هستند!");
        } catch (Exception e) {
            prepareOrReset(false);
            showSystemMessage("برنامه نتوانست فایل دیکشنری را پیدا کند!");
        }
    }

    private void clearBgLetters() {
        for (var box : boxes) box.getStyleClass().removeIf(str ->
                str.equals("bg-of-words-path"));
        for (var badge : badges) badge.setVisible(false);
    }

    private void showSystemMessage(String message) {
        systemMessageLabel.setVisible(true);
        systemMessageLabel.setText(message);
        scrollContainer.setVisible(false);
    }

    private void getWordsFromPG(List<Word> words) {
        prepareOrReset(false);
        if (words.isEmpty()) {
            showSystemMessage("لغتی یافت نشد!");
            return;
        }
        containerOfWords.getChildren().clear();
        for (var word : words) {
            var hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getStyleClass().add("bg-of-words");
            var padding = new Insets(3, 5, 5, 3);
            hBox.setPadding(padding);
            hBox.setSpacing(50);
            hBox.setCursor(Cursor.HAND);
            hBox.setOnMouseClicked(event -> {
                clearBgLetters();
                var counter = 0;
                for (var point : word.path()) {
                    var cellNumber = Finder.getCellNumberOfGrid(point.row(),
                            point.col(), 0);
                    boxes.get(cellNumber).getStyleClass().add("bg-of-words-path");
                    badges.get(cellNumber).setVisible(true);
                    counter++;
                    badges.get(cellNumber).setText(String.valueOf(counter));
                }
            });
            var wordLbl = new Label();
            wordLbl.getStyleClass().add("words-text-font");
            wordLbl.setText(word.word());
            wordLbl.setTextAlignment(TextAlignment.CENTER);
            var pointLbl = new Label();
            pointLbl.getStyleClass().add("words-text-font");
            pointLbl.setText(String.valueOf(word.point()));
            pointLbl.setTextAlignment(TextAlignment.CENTER);
            hBox.getChildren().addAll(wordLbl, pointLbl);
            containerOfWords.getChildren().add(hBox);
        }
        scrollContainer.setVisible(true);
        systemMessageLabel.setVisible(false);
        // set an image:
        var imgView = new ImageView();
        imgView.setPickOnBounds(true);
        imgView.setPreserveRatio(true);
        imgView.setImage(new Image(Objects.requireNonNull(
                HelloApplication.class.getResourceAsStream("/images/man.png"))));
        imgView.setFitHeight(350);
        containerOfWords.getChildren().add(imgView);
    }

    @Override
    public void start(Stage stage) {}

}
