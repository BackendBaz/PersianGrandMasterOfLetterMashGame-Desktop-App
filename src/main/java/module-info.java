module io.github.backendbaz.persiangrandmasteroflettermashgame {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires io.github.backendbaz.bazambazi.wordfinder;

    exports io.github.backendbaz.persiangrandmasteroflettermashgame;

    opens io.github.backendbaz.persiangrandmasteroflettermashgame.controllers to javafx.fxml;
}