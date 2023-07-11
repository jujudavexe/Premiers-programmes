module fr.jujudave.cookiegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.jujudave.cookiegame to javafx.fxml;
    exports fr.jujudave.cookiegame;
}