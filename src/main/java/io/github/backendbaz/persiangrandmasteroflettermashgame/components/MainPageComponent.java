package io.github.backendbaz.persiangrandmasteroflettermashgame.components;

import javafx.geometry.Pos;
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

}
