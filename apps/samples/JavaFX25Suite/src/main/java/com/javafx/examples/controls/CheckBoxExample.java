/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class CheckBoxExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Select options:");
        label.setStyle("-fx-font-weight: bold;");
        
        CheckBox option1 = new CheckBox("Option 1");
        CheckBox option2 = new CheckBox("Option 2");
        option2.setSelected(true);
        CheckBox option3 = new CheckBox("Option 3 (Disabled)");
        option3.setDisable(true);
        CheckBox option4 = new CheckBox("Option 4 (Indeterminate)");
        option4.setAllowIndeterminate(true);
        option4.setIndeterminate(true);
        
        container.getChildren().addAll(label, option1, option2, option3, option4);
        return container;
    }
}
