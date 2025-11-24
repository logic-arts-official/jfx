/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class InputMapExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("InputMap (Incubator):");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("InputMap is an incubator API that provides advanced input handling and key binding management.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        Label features = new Label(
            "Features:\n" +
            "• Custom key bindings\n" +
            "• Platform-specific mappings\n" +
            "• Function tags for semantic actions\n" +
            "• Hierarchical input handling\n" +
            "• Override default behaviors\n" +
            "• Context-aware key handling"
        );
        features.setStyle("-fx-padding: 10;");
        
        Label note = new Label("Note: This is an incubator feature in module jfx.incubator.input");
        note.setStyle("-fx-text-fill: #666666; -fx-font-style: italic;");
        
        container.getChildren().addAll(label, info, features, note);
        return container;
    }
}
