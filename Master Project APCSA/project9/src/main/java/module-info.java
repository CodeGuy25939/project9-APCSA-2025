module waldner.six {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports waldner.six;
    exports waldner.six.controllers;
    exports waldner.six.daos;
    exports waldner.six.models;

    opens waldner.six.controllers to javafx.fxml;
}
