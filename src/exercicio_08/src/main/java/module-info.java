module br.scadiagro.cadastro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens br.scadiagro.cadastro to javafx.fxml;
    exports br.scadiagro.cadastro;
    exports br.scadiagro.cadastro.controllers;
    exports br.scadiagro.cadastro.model;
    exports br.scadiagro.cadastro.config;

    opens br.scadiagro.cadastro.model to java.base;

    opens br.scadiagro.cadastro.controllers to javafx.fxml;

}