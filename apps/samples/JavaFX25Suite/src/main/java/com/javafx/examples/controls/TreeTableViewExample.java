/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TreeTableViewExample {
    
    public static class Item {
        private final SimpleStringProperty name;
        private final SimpleStringProperty value;
        
        public Item(String name, String value) {
            this.name = new SimpleStringProperty(name);
            this.value = new SimpleStringProperty(value);
        }
        
        public String getName() { return name.get(); }
        public String getValue() { return value.get(); }
        public SimpleStringProperty nameProperty() { return name; }
        public SimpleStringProperty valueProperty() { return value; }
    }
    
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TreeTableView:");
        
        TreeTableView<Item> treeTable = new TreeTableView<>();
        
        TreeTableColumn<Item, String> nameCol = new TreeTableColumn<>("Name");
        nameCol.setCellValueFactory(data -> data.getValue().getValue().nameProperty());
        nameCol.setPrefWidth(200);
        
        TreeTableColumn<Item, String> valueCol = new TreeTableColumn<>("Value");
        valueCol.setCellValueFactory(data -> data.getValue().getValue().valueProperty());
        valueCol.setPrefWidth(200);
        
        treeTable.getColumns().addAll(nameCol, valueCol);
        
        TreeItem<Item> root = new TreeItem<>(new Item("Root", "0"));
        root.setExpanded(true);
        
        TreeItem<Item> child1 = new TreeItem<>(new Item("Child 1", "10"));
        child1.getChildren().addAll(
            new TreeItem<>(new Item("Leaf 1.1", "11")),
            new TreeItem<>(new Item("Leaf 1.2", "12"))
        );
        
        TreeItem<Item> child2 = new TreeItem<>(new Item("Child 2", "20"));
        child2.getChildren().add(new TreeItem<>(new Item("Leaf 2.1", "21")));
        
        root.getChildren().addAll(child1, child2);
        treeTable.setRoot(root);
        treeTable.setPrefHeight(200);
        
        container.getChildren().addAll(label, treeTable);
        return container;
    }
}
