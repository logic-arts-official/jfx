/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AnchorPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("AnchorPane:");
        label.setStyle("-fx-font-weight: bold;");
        
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(400, 300);
        anchorPane.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-background-color: #f0f0f0;");
        
        Button topLeft = new Button("Top Left");
        AnchorPane.setTopAnchor(topLeft, 10.0);
        AnchorPane.setLeftAnchor(topLeft, 10.0);
        
        Button topRight = new Button("Top Right");
        AnchorPane.setTopAnchor(topRight, 10.0);
        AnchorPane.setRightAnchor(topRight, 10.0);
        
        Button bottomLeft = new Button("Bottom Left");
        AnchorPane.setBottomAnchor(bottomLeft, 10.0);
        AnchorPane.setLeftAnchor(bottomLeft, 10.0);
        
        Button bottomRight = new Button("Bottom Right");
        AnchorPane.setBottomAnchor(bottomRight, 10.0);
        AnchorPane.setRightAnchor(bottomRight, 10.0);
        
        Button center = new Button("Center");
        AnchorPane.setTopAnchor(center, 130.0);
        AnchorPane.setLeftAnchor(center, 165.0);
        
        anchorPane.getChildren().addAll(topLeft, topRight, bottomLeft, bottomRight, center);
        
        container.getChildren().addAll(label, anchorPane);
        return container;
    }
}
