/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class Shapes3DExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("3D Shapes:");
        label.setStyle("-fx-font-weight: bold;");
        
        Box box = new Box(50, 50, 50);
        PhongMaterial boxMaterial = new PhongMaterial(Color.BLUE);
        box.setMaterial(boxMaterial);
        box.setRotationAxis(Rotate.Y_AXIS);
        box.setRotate(45);
        
        Cylinder cylinder = new Cylinder(30, 60);
        PhongMaterial cylinderMaterial = new PhongMaterial(Color.RED);
        cylinder.setMaterial(cylinderMaterial);
        
        Sphere sphere = new Sphere(40);
        PhongMaterial sphereMaterial = new PhongMaterial(Color.GREEN);
        sphere.setMaterial(sphereMaterial);
        
        Label info = new Label("3D shapes: Box, Cylinder, and Sphere\n(Requires JavaFX 3D support)");
        
        container.getChildren().addAll(label, info, box, cylinder, sphere);
        return container;
    }
}
