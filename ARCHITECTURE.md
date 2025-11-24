# OpenJFX Architecture Guide

This document provides a comprehensive overview of the OpenJFX architecture, design patterns, and internal structure.

## Table of Contents

- [Overview](#overview)
- [Module Architecture](#module-architecture)
- [Scene Graph](#scene-graph)
- [Graphics Pipeline](#graphics-pipeline)
- [UI Controls](#ui-controls)
- [Platform Abstraction](#platform-abstraction)
- [Threading Model](#threading-model)
- [Memory Management](#memory-management)
- [Performance Considerations](#performance-considerations)

## Overview

OpenJFX is a modular, layered framework designed for building rich client applications. The architecture follows these key principles:

1. **Modularity**: JPMS-based modules with clear dependencies
2. **Platform Independence**: Abstract platform-specific code
3. **Hardware Acceleration**: Leverage GPU for graphics rendering
4. **Thread Safety**: Clear threading model with JavaFX Application Thread
5. **Scene Graph**: Retained-mode rendering model

### High-Level Architecture

```
┌─────────────────────────────────────────────────────┐
│              Application Layer                       │
│  (User Application Code, FXML, CSS)                 │
└─────────────────────────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────┐
│         JavaFX Public API Layer                      │
│  (Controls, Web, Media, FXML, Swing Bridge)         │
└─────────────────────────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────┐
│           Scene Graph & Graphics Layer               │
│  (Scene, Node, Canvas, Animation)                   │
└─────────────────────────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────┐
│          Graphics Pipeline (Prism)                   │
│  (Rendering, Shaders, Hardware Acceleration)        │
└─────────────────────────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────┐
│       Platform Abstraction (Glass)                   │
│  (Windowing, Events, Native Integration)            │
└─────────────────────────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────┐
│            Operating System                          │
│  (Windows, macOS, Linux, iOS, etc.)                 │
└─────────────────────────────────────────────────────┘
```

## Module Architecture

### Core Modules

#### javafx.base
**Purpose**: Foundation classes and utilities

**Key Packages**:
- `javafx.beans` - Properties and bindings framework
- `javafx.collections` - Observable collections
- `javafx.event` - Event system
- `javafx.util` - Utility classes

**Design Patterns**:
- **Observer Pattern**: Property change listeners
- **Strategy Pattern**: StringConverter implementations
- **Factory Pattern**: Builder utilities

**Example**:
```java
// Property binding
StringProperty firstName = new SimpleStringProperty();
StringProperty lastName = new SimpleStringProperty();
StringProperty fullName = new SimpleStringProperty();
fullName.bind(firstName.concat(" ").concat(lastName));
```

#### javafx.graphics
**Purpose**: Core graphics, scene graph, and rendering

**Key Packages**:
- `javafx.scene` - Scene graph nodes
- `javafx.scene.shape` - 2D shapes
- `javafx.scene.canvas` - Immediate-mode rendering
- `javafx.scene.image` - Image loading and display
- `javafx.scene.text` - Text rendering
- `javafx.scene.transform` - Transformations
- `javafx.animation` - Animation framework
- `javafx.stage` - Windows and stages
- `javafx.application` - Application lifecycle

**Internal Packages**:
- `com.sun.prism` - Graphics pipeline implementation
- `com.sun.glass` - Platform abstraction layer
- `com.sun.javafx.sg` - Scene graph implementation

#### javafx.controls
**Purpose**: Standard UI controls

**Key Packages**:
- `javafx.scene.control` - UI controls (Button, Label, etc.)
- `javafx.scene.control.skin` - Control skins (visual implementation)

**Architecture**:
```
Control (Behavior) ←→ Skin (Appearance)
      ↓                      ↓
  CSS Styling          Visual Rendering
```

**Control/Skin Separation**:
- **Control**: Behavior and state
- **Skin**: Visual representation
- **CSS**: Customizable styling

#### javafx.fxml
**Purpose**: FXML markup language support

**Key Classes**:
- `FXMLLoader` - Loads FXML files
- `@FXML` - Annotation for controller injection

**Example**:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox xmlns:fx="http://javafx.com/fxml">
    <Button text="Click Me" onAction="#handleClick"/>
</VBox>
```

#### javafx.media
**Purpose**: Audio and video playback

**Architecture**:
- **MediaPlayer** - Playback control
- **Media** - Media source
- **MediaView** - Visual display (video)
- **Native Pipeline** - Platform-specific codecs

#### javafx.web
**Purpose**: Web browser component (WebKit-based)

**Key Classes**:
- `WebView` - Browser UI component
- `WebEngine` - Browser engine
- `JSObject` - Java-JavaScript bridge

**Internal**: Based on WebKit rendering engine

#### javafx.swing
**Purpose**: JavaFX/Swing interoperability

**Key Classes**:
- `SwingNode` - Embed Swing in JavaFX
- `JFXPanel` - Embed JavaFX in Swing

## Scene Graph

### Structure

The scene graph is a hierarchical tree structure:

```
Stage (Window)
  └── Scene (Root container)
      └── Root Node
          ├── Parent Node 1
          │   ├── Child Node 1.1
          │   └── Child Node 1.2
          └── Parent Node 2
              └── Child Node 2.1
```

### Node Types

1. **Parent Nodes**: Can contain children
   - `Group` - Simple container
   - `Pane` - Layout container
   - `Region` - CSS-styled container

2. **Leaf Nodes**: Cannot contain children
   - `Shape` - Geometric shapes
   - `ImageView` - Images
   - `Text` - Text display
   - `Canvas` - Immediate-mode drawing
   - `MediaView` - Video display

### Scene Graph Rendering

**Retained Mode**: Scene graph is maintained in memory
- Changes marked as dirty
- Rendering optimized by pulse events
- Only dirty nodes re-rendered

**Pulse Events**: ~60 FPS rendering cycle
```
User Action → Scene Graph Change → Mark Dirty → Pulse → Render
```

### Coordinate System

- **Origin**: Top-left corner (0, 0)
- **X-axis**: Increases to the right
- **Y-axis**: Increases downward
- **Units**: Pixels (device-independent)

### Transformations

Nodes support transformations:
- **Translate**: Move position
- **Rotate**: Rotate around a point
- **Scale**: Resize
- **Shear**: Skew

```java
node.setTranslateX(100);
node.setRotate(45);
node.setScaleX(2.0);
```

Transformations are cumulative through parent chain.

## Graphics Pipeline

### Prism Graphics Engine

Prism is the JavaFX graphics engine with multiple rendering paths:

#### Rendering Paths

1. **Hardware Accelerated**:
   - **Direct3D** (Windows) - DirectX-based
   - **Metal** (macOS) - Apple's graphics API
   - **OpenGL ES2** (Linux, optional) - OpenGL

2. **Software Rendering**:
   - **Prism SW** - Software fallback (when hardware unavailable)

#### Pipeline Selection

At startup, JavaFX selects the best pipeline:
```
1. Try hardware acceleration (D3D, Metal, ES2)
2. If fails, fall back to software rendering
3. Log selected pipeline
```

System properties to control:
```bash
-Dprism.order=d3d,sw       # Prefer D3D, fallback to SW
-Dprism.forceGPU=true      # Require GPU acceleration
-Dprism.verbose=true       # Log pipeline selection
```

#### Shader Architecture

Prism uses programmable shaders:
- **Vertex Shaders**: Transform vertices
- **Fragment Shaders**: Compute pixel colors
- **Shader Language**: HLSL (D3D), GLSL (OpenGL), MSL (Metal)

Shaders compiled at build time:
```
Source (.frag, .vert) → Compiler → Binary → Embedded in JAR
```

### Rendering Optimization

1. **Dirty Region Tracking**: Only re-render changed areas
2. **Layer Caching**: Cache complex subtrees as textures
3. **GPU Upload Minimization**: Batch texture uploads
4. **Occlusion Culling**: Skip invisible nodes

```java
// Enable caching for complex node
node.setCache(true);
node.setCacheHint(CacheHint.SPEED);
```

## UI Controls

### Control Architecture

Controls follow MVC-like pattern:

```
┌──────────────────────────────────────┐
│  Control (Model + Controller)        │
│  - State and properties              │
│  - Event handlers                    │
│  - Business logic                    │
└──────────────────────────────────────┘
              ↓ delegates to
┌──────────────────────────────────────┐
│  Skin (View)                         │
│  - Visual representation             │
│  - Layout logic                      │
│  - Creates scene graph nodes         │
└──────────────────────────────────────┘
              ↓ styled by
┌──────────────────────────────────────┐
│  CSS                                 │
│  - Colors, fonts, sizes              │
│  - Visual styling                    │
└──────────────────────────────────────┘
```

### Creating Custom Controls

**Option 1: Extend Existing Control**
```java
public class MyButton extends Button {
    public MyButton() {
        getStyleClass().add("my-button");
    }
}
```

**Option 2: Create New Control**
```java
public class CustomControl extends Control {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new CustomControlSkin(this);
    }
}

public class CustomControlSkin extends SkinBase<CustomControl> {
    public CustomControlSkin(CustomControl control) {
        super(control);
        // Create visual representation
    }
}
```

### CSS Styling

Controls styled via CSS:
```css
.button {
    -fx-background-color: #007bff;
    -fx-text-fill: white;
    -fx-font-size: 14px;
}

.button:hover {
    -fx-background-color: #0056b3;
}
```

CSS properties processed by JavaFX CSS engine:
1. Parse CSS files
2. Match selectors to nodes
3. Apply properties
4. Convert to internal values
5. Update scene graph

## Platform Abstraction

### Glass Windowing Toolkit

Glass provides platform abstraction:

**Responsibilities**:
- Window creation and management
- Event handling (mouse, keyboard, touch)
- Native dialogs
- System clipboard
- Drag and drop
- Native menus

**Platform Implementations**:
- `com.sun.glass.ui.win` - Windows
- `com.sun.glass.ui.mac` - macOS
- `com.sun.glass.ui.gtk` - Linux (GTK)
- `com.sun.glass.ui.ios` - iOS
- `com.sun.glass.ui.android` - Android

### Native Integration

JavaFX uses JNI for native code:
```
Java Layer → JNI → Native Libraries → OS APIs
```

Native libraries:
- `glass.dll` / `libglass.so` / `libglass.dylib` - Windowing
- `prism_d3d.dll` - Direct3D rendering
- `prism_es2.dll/.so` - OpenGL ES2 rendering
- `prism_sw.dll/.so` - Software rendering
- `javafx_font.dll/.so` - Font rendering

## Threading Model

### Thread Types

1. **JavaFX Application Thread**
   - UI rendering and event handling
   - Scene graph modifications MUST occur here
   - Started by Application.launch()

2. **Background Threads**
   - Long-running tasks
   - Network I/O
   - File operations
   - Use Task or Service

3. **Prism Render Thread** (internal)
   - Parallel rendering
   - GPU command submission

4. **Media Threads** (internal)
   - Audio/video decoding
   - Playback control

5. **Pulse Timer Thread** (internal)
   - Triggers 60 FPS rendering pulses

### Thread Safety

**Rule**: Only JavaFX Application Thread can modify scene graph

**Correct**:
```java
Platform.runLater(() -> {
    label.setText("Updated");
});
```

**Incorrect (causes Exception)**:
```java
new Thread(() -> {
    label.setText("Updated"); // IllegalStateException!
}).start();
```

### Background Tasks

Use Task for background work:
```java
Task<String> task = new Task<>() {
    @Override
    protected String call() throws Exception {
        // Background work
        updateProgress(50, 100);
        return "Result";
    }
};

task.setOnSucceeded(e -> {
    // Runs on JavaFX thread
    label.setText(task.getValue());
});

new Thread(task).start();
```

## Memory Management

### Node Lifecycle

1. **Creation**: Node instantiated
2. **Attachment**: Added to scene graph
3. **Rendering**: Rendered in pulses
4. **Detachment**: Removed from scene graph
5. **GC**: Eligible for garbage collection

### Memory Optimization

**Best Practices**:
1. Remove unused nodes from scene graph
2. Clear event handlers when done
3. Use weak listeners for long-lived observables
4. Release large images when not needed
5. Avoid memory leaks in bindings

```java
// Weak listener (prevents memory leak)
property.addListener(new WeakChangeListener<>(listener));

// Clear binding when done
property.unbind();

// Release image
imageView.setImage(null);
```

### Native Memory

JavaFX uses native memory for:
- Textures (GPU memory)
- Fonts (glyph caches)
- Native windows

Native memory released automatically, but can be forced:
```java
System.gc(); // Triggers native cleanup via finalization
```

## Performance Considerations

### Rendering Performance

**Optimize**:
1. Use hardware acceleration
2. Minimize scene graph depth
3. Cache complex nodes
4. Use CSS efficiently
5. Batch updates in single pulse

**Avoid**:
1. Modifying scene graph at 60 FPS
2. Creating nodes in animation loops
3. Unnecessary property changes
4. Deep scene graph nesting
5. Transparent overlays

### Animation Performance

Use built-in animation framework:
```java
// Efficient: Timeline animation
Timeline timeline = new Timeline(
    new KeyFrame(Duration.seconds(1),
        new KeyValue(node.opacityProperty(), 0.0))
);
timeline.play();

// Inefficient: AnimationTimer with property changes
new AnimationTimer() {
    @Override
    public void handle(long now) {
        node.setOpacity(node.getOpacity() - 0.01); // Triggers layout!
    }
}.start();
```

### Layout Performance

Layout is expensive:
- Triggered by size/position changes
- Cascades through parent chain
- Use layout bounds caching

```java
// Efficient: Batch changes
node.setWidth(100);
node.setHeight(100);

// Less efficient: Multiple pulses
node.setWidth(100);
Platform.runLater(() -> node.setHeight(100));
```

### Memory Performance

Monitor memory usage:
```bash
# Enable memory profiling
java -Djavafx.verbose=true \
     -Dprism.verbose=true \
     -Dprism.printallocs=true \
     MyApp
```

---

## References

- [JavaFX Source Code](https://github.com/openjdk/jfx)
- [JavaFX Documentation](https://openjfx.io/javadoc/)
- [Scene Graph Tutorial](https://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm)
- [Graphics Performance Tips](https://docs.oracle.com/javafx/2/best_practices/jfxpub-best_practices.htm)

---

Last Updated: November 2025
