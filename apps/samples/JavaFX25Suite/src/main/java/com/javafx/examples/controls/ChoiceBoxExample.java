/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ChoiceBoxExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ChoiceBox:");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setItems(FXCollections.observableArrayList("Red", "Green", "Blue", "Yellow"));
        choiceBox.setValue("Blue");
        
        container.getChildren().addAll(label, choiceBox);
        return container;
    }
}
