/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TableViewExample {
    
    public static class Person {
        private final String firstName;
        private final String lastName;
        private final String email;
        
        public Person(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
        
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
    }
    
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TableView:");
        
        TableView<Person> table = new TableView<>();
        
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setPrefWidth(150);
        
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setPrefWidth(150);
        
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailCol.setPrefWidth(200);
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("John", "Doe", "john.doe@example.com"),
            new Person("Jane", "Smith", "jane.smith@example.com"),
            new Person("Bob", "Johnson", "bob.johnson@example.com"),
            new Person("Alice", "Williams", "alice.williams@example.com")
        );
        table.setItems(data);
        table.setPrefHeight(200);
        
        container.getChildren().addAll(label, table);
        return container;
    }
}
