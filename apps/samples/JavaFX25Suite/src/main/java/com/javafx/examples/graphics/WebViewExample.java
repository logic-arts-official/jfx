/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("WebView:");
        label.setStyle("-fx-font-weight: bold;");
        
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(
            "<html><body>" +
            "<h1>WebView Example</h1>" +
            "<p>This is a WebView component that can render HTML content.</p>" +
            "<ul>" +
            "<li>Supports HTML5</li>" +
            "<li>Supports CSS</li>" +
            "<li>Supports JavaScript</li>" +
            "<li>Can load web pages</li>" +
            "</ul>" +
            "</body></html>"
        );
        webView.setPrefHeight(300);
        
        container.getChildren().addAll(label, webView);
        return container;
    }
}
