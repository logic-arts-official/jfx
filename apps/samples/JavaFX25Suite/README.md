# JavaFX 25 Comprehensive Examples Suite

A comprehensive examples suite that integrates and demonstrates all UI elements and features available in JavaFX 25.

## Overview

This application provides interactive examples for all major JavaFX components, organized into intuitive categories:

### Categories

#### 1. **Controls** (33 examples)
- Basic Input: Button, Label, TextField, TextArea, PasswordField
- Selection: CheckBox, RadioButton, ToggleButton, ComboBox, ChoiceBox
- Value Input: Slider, Spinner, ColorPicker, DatePicker
- Progress: ProgressBar, ProgressIndicator, ScrollBar
- Navigation: Hyperlink
- Complex Views: ListView, TableView, TreeView, TreeTableView
- Menus: MenuBar, ContextMenu, ToolBar
- Containers: TabPane, Accordion, TitledPane, SplitPane, ScrollPane
- Other: Pagination, HTMLEditor, Tooltip

#### 2. **Charts** (7 examples)
- LineChart
- AreaChart
- BarChart
- StackedBarChart
- PieChart
- ScatterChart
- BubbleChart

#### 3. **Layout** (8 examples)
- HBox (Horizontal Box)
- VBox (Vertical Box)
- BorderPane
- StackPane
- GridPane
- FlowPane
- TilePane
- AnchorPane

#### 4. **Graphics** (7 examples)
- 2D Shapes (Rectangle, Circle, Ellipse, Polygon, Line)
- Canvas (Drawing API)
- ImageView
- 3D Shapes (Box, Cylinder, Sphere)
- Effects (DropShadow, Reflection, Glow, Blur, ColorAdjust)
- Transformations (Rotate, Scale, Translate, Shear)
- Animation (Transitions and Timelines)

#### 5. **Media** (2 examples)
- MediaPlayer
- MediaView

#### 6. **Web** (1 example)
- WebView (HTML5, CSS, JavaScript support)

#### 7. **Incubator Features** (3 examples)
- RichTextArea (Rich text editing)
- CodeArea (Code editing with syntax highlighting)
- InputMap (Advanced key binding management)

## Features

- **Interactive Navigation**: Tree-based navigation for easy browsing
- **Live Examples**: Each example is fully functional and interactive
- **Clean UI**: Modern, intuitive interface
- **Comprehensive Coverage**: All JavaFX 25 UI elements included
- **Well-Organized**: Logical categorization for easy discovery

## Building and Running

### Prerequisites
- JDK 25 or later
- JavaFX 25 SDK

### Building with Gradle
```bash
./gradlew :apps:samples:JavaFX25Suite:build
```

### Running the Application
```bash
./gradlew :apps:samples:JavaFX25Suite:run
```

## Structure

```
JavaFX25Suite/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/javafx/examples/
│       │       ├── JavaFX25SuiteApp.java (Main application)
│       │       ├── controls/ (33 control examples)
│       │       ├── charts/ (7 chart examples)
│       │       ├── layout/ (8 layout examples)
│       │       └── graphics/ (13 graphics, media, web, incubator examples)
│       └── resources/
├── build.gradle
└── README.md
```

## Usage

1. Launch the application
2. Browse through the navigation tree on the left
3. Click on any example to view it in the content area
4. Interact with the examples to see how they work

## Examples Highlights

### Controls
Each control example demonstrates:
- Basic usage
- Common variations and configurations
- Interactive features
- Styling options

### Charts
Chart examples show:
- Different chart types
- Data visualization
- Series and categories
- Customization options

### Layout
Layout examples illustrate:
- Container behavior
- Child arrangement
- Spacing and padding
- Responsive design

### Graphics
Graphics examples demonstrate:
- 2D and 3D shapes
- Drawing with Canvas
- Visual effects
- Transformations
- Animations

### Incubator Features
Incubator examples introduce:
- RichTextArea for rich text editing
- CodeArea for code editing
- InputMap for advanced input handling

## License

This example suite is provided under the same license as OpenJFX.

## Contributing

This is part of the OpenJFX project. For contributions, please follow the OpenJFX contribution guidelines.

## Related

- [JavaFX Documentation](https://openjfx.io/)
- [OpenJFX GitHub](https://github.com/openjdk/jfx)
- [Ensemble8 Sample Application](../Ensemble8/)

---

**Note**: This comprehensive examples suite demonstrates all UI elements available in JavaFX 25, including stable APIs and incubator features.
