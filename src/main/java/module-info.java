module io.github.backendbaz.persiangrandmasteroflettermashgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens io.github.backendbaz.persiangrandmasteroflettermashgame to javafx.fxml;
    exports io.github.backendbaz.persiangrandmasteroflettermashgame;
}