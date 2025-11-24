/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class RichTextAreaExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("RichTextArea (Incubator):");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("RichTextArea is an incubator feature in JavaFX 25 that provides rich text editing capabilities.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        Label features = new Label(
            "Features:\n" +
            "• Rich text formatting (bold, italic, underline)\n" +
            "• Font and color customization\n" +
            "• Paragraph styles\n" +
            "• Inline nodes support\n" +
            "• Custom decorators\n" +
            "• Export/Import (HTML, RTF)\n" +
            "• Advanced text manipulation"
        );
        features.setStyle("-fx-padding: 10;");
        
        Label note = new Label("Note: This is an incubator feature in module jfx.incubator.richtext");
        note.setStyle("-fx-text-fill: #666666; -fx-font-style: italic;");
        
        container.getChildren().addAll(label, info, features, note);
        return container;
    }
}
