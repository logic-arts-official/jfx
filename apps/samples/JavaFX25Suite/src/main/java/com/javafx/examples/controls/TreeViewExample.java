/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TreeViewExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TreeView:");
        
        TreeItem<String> root = new TreeItem<>("Root");
        root.setExpanded(true);
        
        TreeItem<String> branch1 = new TreeItem<>("Branch 1");
        branch1.getChildren().addAll(
            new TreeItem<>("Leaf 1.1"),
            new TreeItem<>("Leaf 1.2"),
            new TreeItem<>("Leaf 1.3")
        );
        
        TreeItem<String> branch2 = new TreeItem<>("Branch 2");
        branch2.getChildren().addAll(
            new TreeItem<>("Leaf 2.1"),
            new TreeItem<>("Leaf 2.2")
        );
        
        root.getChildren().addAll(branch1, branch2);
        
        TreeView<String> treeView = new TreeView<>(root);
        treeView.setPrefHeight(200);
        
        container.getChildren().addAll(label, treeView);
        return container;
    }
}
