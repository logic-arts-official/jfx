/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class DatePickerExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Date Picker:");
        DatePicker datePicker = new DatePicker(LocalDate.now());
        
        Label selectedLabel = new Label("Selected Date: " + LocalDate.now());
        datePicker.setOnAction(e -> {
            LocalDate selected = datePicker.getValue();
            selectedLabel.setText("Selected Date: " + selected);
        });
        
        container.getChildren().addAll(label, datePicker, selectedLabel);
        return container;
    }
}
