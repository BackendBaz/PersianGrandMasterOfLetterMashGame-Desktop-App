module io.github.backendbaz.persiangrandmasteroflettermashgame {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    exports io.github.backendbaz.persiangrandmasteroflettermashgame;

    opens io.github.backendbaz.persiangrandmasteroflettermashgame.controllers to javafx.fxml;
}