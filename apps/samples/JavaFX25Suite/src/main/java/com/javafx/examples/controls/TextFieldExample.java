/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TextFieldExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basicLabel = new Label("Basic TextField:");
        TextField basic = new TextField();
        basic.setPromptText("Enter text here...");
        
        Label prefilled = new Label("Prefilled TextField:");
        TextField prefilledField = new TextField("Prefilled text");
        
        Label disabled = new Label("Disabled TextField:");
        TextField disabledField = new TextField("Cannot edit");
        disabledField.setDisable(true);
        
        Label editable = new Label("Non-editable TextField:");
        TextField nonEditable = new TextField("Read only");
        nonEditable.setEditable(false);
        
        container.getChildren().addAll(
            basicLabel, basic,
            prefilled, prefilledField,
            disabled, disabledField,
            editable, nonEditable
        );
        return container;
    }
}
