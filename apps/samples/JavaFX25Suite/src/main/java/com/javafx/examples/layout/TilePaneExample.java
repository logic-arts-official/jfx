/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TilePaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TilePane:");
        label.setStyle("-fx-font-weight: bold;");
        
        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(10));
        tilePane.setPrefColumns(3);
        tilePane.setStyle("-fx-border-color: brown; -fx-border-width: 1;");
        
        for (int i = 1; i <= 9; i++) {
            Button button = new Button("Tile " + i);
            button.setPrefSize(80, 80);
            tilePane.getChildren().add(button);
        }
        
        container.getChildren().addAll(label, tilePane);
        return container;
    }
}
