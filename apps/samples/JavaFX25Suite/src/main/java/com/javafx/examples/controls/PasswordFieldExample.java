/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PasswordFieldExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basicLabel = new Label("Password Field:");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter password...");
        
        Label confirmLabel = new Label("Confirm Password:");
        PasswordField confirmPassword = new PasswordField();
        confirmPassword.setPromptText("Confirm password...");
        
        container.getChildren().addAll(basicLabel, password, confirmLabel, confirmPassword);
        return container;
    }
}
