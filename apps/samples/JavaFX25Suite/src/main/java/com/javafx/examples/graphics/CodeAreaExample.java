/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class CodeAreaExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("CodeArea (Incubator):");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("CodeArea is a specialized text control for code editing with syntax highlighting.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        Label features = new Label(
            "Features:\n" +
            "• Syntax highlighting\n" +
            "• Line numbers\n" +
            "• Code folding support\n" +
            "• Custom syntax decorators\n" +
            "• Optimized for large files\n" +
            "• Programming language support"
        );
        features.setStyle("-fx-padding: 10;");
        
        Label note = new Label("Note: This is an incubator feature in module jfx.incubator.richtext");
        note.setStyle("-fx-text-fill: #666666; -fx-font-style: italic;");
        
        container.getChildren().addAll(label, info, features, note);
        return container;
    }
}
