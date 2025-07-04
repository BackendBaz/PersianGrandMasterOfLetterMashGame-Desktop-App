package io.github.backendbaz.persiangrandmasteroflettermashgame.components;

import io.github.backendbaz.persiangrandmasteroflettermashgame.HelloApplication;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Objects;

public class MainPageComponent extends Application {

    public final double WIDTH = 800;
    public final double HEIGHT = 550;
    private final Label systemMessageLabel = getSystemMessageLabel();

    public VBox getRoot() {
        var root = new VBox();
        // set the 'alignment' property:
        root.setAlignment(Pos.TOP_CENTER);
        // add all children:
        root.getChildren().addAll(
                getMenuBar(root), // import a Menu Bar
                systemMessageLabel, // import a System Message Label
                getSeparator(false), // import a horizontal separator
                getHBox() // import a horizontal container
        );
        return root;
    }

    private MenuBar getMenuBar(VBox root) {
        var menuItem = new MenuItem();
        menuItem.setText("Developer");
        menuItem.setOnAction(event ->
                showDeveloperPageOnClick(root));
        var menu = new Menu();
        menu.setText("Information");
        menu.getItems().add(menuItem);
        var menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        return menuBar;
    }

    private void showDeveloperPageOnClick(VBox root) {
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

    private Label getSystemMessageLabel() {
        var label = new Label();
        label.getStyleClass().add("result-text-font");
        label.setText("");
        label.setTextFill(Paint.valueOf("red"));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true);
        label.setVisible(false);
        return label;
    }

    private Separator getSeparator(boolean isVertical) {
        var separator = new Separator();
        if (isVertical) separator.setOrientation(Orientation.VERTICAL);
        return separator;
    }

    private HBox getHBox() {
        var hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(
                getBoardContainer() // import a board container
        );
        return hBox;
    }

    private VBox getBoardContainer() {
        var vBox = new VBox();
        vBox.getChildren().addAll(
                get4x4GridPane(), // import a 4x4 grid with 16 text fields
                getControlPanel() // import 3 buttons to control the app
        );
        return vBox;
    }

    private GridPane get4x4GridPane() {
        var grid = new GridPane();
        for (int i = 0; i < 4; i++) {
            var colsContainer = new ColumnConstraints();
            colsContainer.setHgrow(Priority.ALWAYS);
            colsContainer.setMinWidth(30);
            colsContainer.setPrefWidth(80);
            grid.getColumnConstraints().add(colsContainer);
        }
        for (int i = 0; i < 4; i++) {
            var rowsContainer = new RowConstraints();
            rowsContainer.setVgrow(Priority.ALWAYS);
            rowsContainer.setMinHeight(30);
            rowsContainer.setPrefHeight(80);
            grid.getRowConstraints().add(rowsContainer);
        }
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                var textField = new TextField();
                textField.setAlignment(Pos.CENTER);
                textField.setPromptText(String.valueOf(10));
                textField.getStyleClass().add("grid-letters-font");
                textField.setMaxWidth(1.7976931348623157E308);
                textField.setMaxHeight(1.7976931348623157E308);
                GridPane.setRowIndex(textField, row);
                GridPane.setColumnIndex(textField, col);
                grid.getChildren().add(textField);
            }
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setMaxWidth(Double.NEGATIVE_INFINITY);
        return grid;
    }

    private HBox getControlPanel() {
        var hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(6);
        // search btn:
        var btnSearch = new Button();
        btnSearch.setText("جستجو");
        btnSearch.getStyleClass().add("btn-control-font");
        btnSearch.setTextAlignment(TextAlignment.CENTER);
        // clear btn:
        var btnClear = new Button();
        btnClear.setText("پاکسازی");
        btnClear.getStyleClass().add("btn-control-font");
        btnClear.setTextAlignment(TextAlignment.CENTER);
        hBox.getChildren().addAll(
                btnSearch, // import a search button
                btnClear // import a clear button
        );
        return hBox;
    }

    @Override
    public void start(Stage stage) {}

}
