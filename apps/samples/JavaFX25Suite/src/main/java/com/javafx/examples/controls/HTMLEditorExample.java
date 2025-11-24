/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.skin.HTMLEditor;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class HTMLEditorExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("HTMLEditor:");
        
        javafx.scene.web.HTMLEditor htmlEditor = new javafx.scene.web.HTMLEditor();
        htmlEditor.setHtmlText("<html><body><h1>Hello World</h1><p>This is a rich text editor.</p></body></html>");
        htmlEditor.setPrefHeight(300);
        
        container.getChildren().addAll(label, htmlEditor);
        return container;
    }
}
