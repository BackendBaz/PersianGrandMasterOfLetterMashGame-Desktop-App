package io.github.backendbaz.persiangrandmasteroflettermashgame.components;

import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class MainPageComponent {

    public final double WIDTH = 800;
    public final double HEIGHT = 550;

    public VBox getRoot() {
        var root = new VBox();
        // set the 'alignment' property:
        root.setAlignment(Pos.TOP_CENTER);
        return root;
    }

    public MenuBar getMenuBar() {
        var menuItem = new MenuItem();
        menuItem.setText("Developer");
        menuItem.setOnAction(event -> {
            // todo
        });
        var menu = new Menu();
        menu.setText("Information");
        menu.getItems().add(menuItem);
        var menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        return menuBar;
    }

}
