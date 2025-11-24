/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ComboBoxExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basicLabel = new Label("Basic ComboBox:");
        ComboBox<String> basic = new ComboBox<>();
        basic.setItems(FXCollections.observableArrayList("Option 1", "Option 2", "Option 3", "Option 4"));
        basic.setPromptText("Select an option");
        
        Label preselected = new Label("Preselected ComboBox:");
        ComboBox<String> preselectedCombo = new ComboBox<>();
        preselectedCombo.setItems(FXCollections.observableArrayList("Java", "Python", "JavaScript", "C++", "Go"));
        preselectedCombo.setValue("Java");
        
        Label editable = new Label("Editable ComboBox:");
        ComboBox<String> editableCombo = new ComboBox<>();
        editableCombo.setItems(FXCollections.observableArrayList("Apple", "Banana", "Cherry", "Date"));
        editableCombo.setEditable(true);
        editableCombo.setPromptText("Type or select...");
        
        container.getChildren().addAll(
            basicLabel, basic,
            preselected, preselectedCombo,
            editable, editableCombo
        );
        return container;
    }
}
