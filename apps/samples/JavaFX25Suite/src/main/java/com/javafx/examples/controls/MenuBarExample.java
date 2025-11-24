/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MenuBarExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("MenuBar:");
        
        MenuBar menuBar = new MenuBar();
        
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(
            new MenuItem("New"),
            new MenuItem("Open"),
            new MenuItem("Save"),
            new SeparatorMenuItem(),
            new MenuItem("Exit")
        );
        
        Menu editMenu = new Menu("Edit");
        editMenu.getItems().addAll(
            new MenuItem("Cut"),
            new MenuItem("Copy"),
            new MenuItem("Paste")
        );
        
        Menu viewMenu = new Menu("View");
        CheckMenuItem showToolbar = new CheckMenuItem("Show Toolbar");
        showToolbar.setSelected(true);
        CheckMenuItem showStatusBar = new CheckMenuItem("Show Status Bar");
        viewMenu.getItems().addAll(showToolbar, showStatusBar);
        
        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);
        
        container.getChildren().addAll(label, menuBar);
        return container;
    }
}
