/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ListViewExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ListView (Multiple Selection):");
        ListView<String> listView = new ListView<>();
        listView.setItems(FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", 
            "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
        ));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setPrefHeight(200);
        
        container.getChildren().addAll(label, listView);
        return container;
    }
}
