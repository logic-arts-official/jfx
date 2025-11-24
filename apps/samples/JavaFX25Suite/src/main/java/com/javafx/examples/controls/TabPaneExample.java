/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TabPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TabPane:");
        
        TabPane tabPane = new TabPane();
        
        Tab tab1 = new Tab("Tab 1");
        tab1.setContent(new Label("Content of Tab 1"));
        
        Tab tab2 = new Tab("Tab 2");
        tab2.setContent(new Label("Content of Tab 2"));
        
        Tab tab3 = new Tab("Tab 3");
        tab3.setContent(new Label("Content of Tab 3"));
        
        tabPane.getTabs().addAll(tab1, tab2, tab3);
        tabPane.setPrefHeight(200);
        
        container.getChildren().addAll(label, tabPane);
        return container;
    }
}
