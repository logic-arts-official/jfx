/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PaginationExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Pagination:");
        
        Pagination pagination = new Pagination(10, 0);
        pagination.setPageFactory(pageIndex -> {
            Label pageLabel = new Label("Page " + (pageIndex + 1));
            pageLabel.setStyle("-fx-font-size: 16px; -fx-padding: 20;");
            return pageLabel;
        });
        pagination.setPrefHeight(200);
        
        container.getChildren().addAll(label, pagination);
        return container;
    }
}
