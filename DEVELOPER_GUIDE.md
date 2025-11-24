# OpenJFX Developer Guide

This comprehensive guide covers everything you need to know about developing with and contributing to OpenJFX.

## Table of Contents

- [Introduction](#introduction)
- [Architecture Overview](#architecture-overview)
- [Development Environment](#development-environment)
- [Building from Source](#building-from-source)
- [Testing](#testing)
- [Code Style and Standards](#code-style-and-standards)
- [Debugging](#debugging)
- [Contributing](#contributing)
- [Advanced Topics](#advanced-topics)

## Introduction

OpenJFX is an open-source, next-generation client application platform for desktop, mobile, and embedded systems built on JavaSE. It's the open-source project where JavaFX is developed.

### Project Structure

```
jfx/
├── apps/               # Sample applications and tests
│   ├── samples/       # Example applications
│   ├── tests/         # Application-level tests
│   └── toys/          # Development tools and utilities
├── build.gradle       # Main build script
├── buildSrc/          # Build system extensions
├── doc-files/         # Documentation and release notes
├── modules/           # Core JavaFX modules
│   ├── javafx.base/
│   ├── javafx.controls/
│   ├── javafx.fxml/
│   ├── javafx.graphics/
│   ├── javafx.media/
│   ├── javafx.swing/
│   └── javafx.web/
├── tests/             # System-level tests
└── gradle/            # Gradle wrapper
```

## Architecture Overview

### Core Modules

1. **javafx.base** - Foundation classes including properties, events, and collections
2. **javafx.graphics** - Core graphics, shapes, animation, and scene graph
3. **javafx.controls** - UI controls like buttons, tables, and lists
4. **javafx.fxml** - FXML markup language support
5. **javafx.media** - Audio and video playback
6. **javafx.swing** - JavaFX/Swing interoperability
7. **javafx.web** - Web browser component (WebKit)

### Module Dependencies

```
javafx.base (foundation)
    ├── javafx.graphics (depends on base)
    │   ├── javafx.controls (depends on graphics, base)
    │   │   └── javafx.fxml (depends on controls, graphics, base)
    │   ├── javafx.media (depends on graphics, base)
    │   ├── javafx.web (depends on graphics, base)
    │   └── javafx.swing (depends on graphics, base)
```

## Development Environment

### System Requirements

#### Minimum Requirements
- **CPU**: 2+ cores
- **RAM**: 8 GB (16 GB recommended for WebKit compilation)
- **Disk**: 10 GB free space
- **OS**: 
  - Linux: Ubuntu 20.04+, Fedora 35+, or compatible
  - macOS: 12+ (Monterey or later)
  - Windows: 10/11 with Visual Studio 2022

#### JDK Requirements
- **Build JDK**: 25.0.1 (build 8) or later
- **Minimum JDK**: 24 (build 36)
- **Target JDK**: 24 (runtime compatibility)

### Environment Variables

```bash
# Required
export JAVA_HOME=/path/to/jdk-25

# Optional (for custom builds)
export JFX_DEPS_URL=http://your-local-mirror/dependencies
export NUM_COMPILE_THREADS=8
```

### Platform-Specific Setup

#### Linux Development
```bash
# Install build tools
sudo apt-get install build-essential cmake ninja-build pkg-config

# Graphics libraries
sudo apt-get install libgtk-3-dev libgtk2.0-dev libgl1-mesa-dev libglu1-mesa-dev

# Media libraries (if building media)
sudo apt-get install libavcodec-dev libavformat-dev libavutil-dev

# Testing libraries
sudo apt-get install libxtst-dev libasound2-dev
```

#### macOS Development
```bash
# Install Xcode from App Store
xcode-select --install

# Verify installation
xcodebuild -version  # Should show 15.4+
```

#### Windows Development
1. Install Visual Studio 2022 (Community Edition or higher)
2. Select "Desktop development with C++" workload
3. Install CMake 3.22.3+ and add to PATH
4. Install Ninja build system (optional, for faster builds)

## Building from Source

### Basic Build

```bash
# Clone repository
git clone https://github.com/logic-arts-official/jfx.git
cd jfx

# Simple build (no media/webkit)
./gradlew sdk

# View build output
ls -la build/sdk/
```

### Build Options

#### Configuration via gradle.properties

Create or copy `gradle.properties`:
```bash
cp gradle.properties.template gradle.properties
```

Key options:
```properties
# Build configuration
CONF = Release                    # Release, Debug, or DebugNative

# Feature flags
COMPILE_WEBKIT = true            # Include WebKit (web component)
COMPILE_MEDIA = true             # Include media support
INCLUDE_NULL3D = false           # Include Null3D pipeline
INCLUDE_ES2 = false              # Include ES2 pipeline (Windows)

# Testing
FULL_TEST = true                 # Run full test suite
USE_ROBOT = true                 # Enable robot-based tests
UNSTABLE_TEST = false            # Include unstable tests

# Build optimization
NUM_COMPILE_THREADS = 8          # Parallel compilation threads
USE_DEPEND = true                # Incremental compilation
INCREMENTAL = true               # Gradle incremental compilation

# Cross-compilation
COMPILE_TARGETS = all            # or: mac, ios, linux, win, etc.
```

#### Command-Line Build Options

```bash
# Build with WebKit and Media
./gradlew -PCOMPILE_WEBKIT=true -PCOMPILE_MEDIA=true sdk

# Release build
./gradlew -PCONF=Release sdk

# Build specific modules
./gradlew :base:build
./gradlew :graphics:build
./gradlew :controls:build

# Parallel builds (faster)
./gradlew sdk --parallel --max-workers=8

# Skip tests during build
./gradlew sdk -x test
```

### Build Targets

| Target | Description |
|--------|-------------|
| `sdk` | Build complete SDK (default) |
| `clean` | Remove all build artifacts |
| `build` | Build all modules |
| `test` | Run tests |
| `javadoc` | Generate API documentation |
| `shims` | Build test infrastructure |
| `apps` | Build sample applications |

### Build Artifacts

After successful build:
```
build/
├── sdk/                    # Complete SDK
│   ├── lib/               # JavaFX libraries
│   └── bin/               # Native binaries
├── modular-sdk/           # Modular JDK layout
│   └── modules/           # Individual modules
├── javadoc/               # API documentation
└── reports/               # Test reports
```

## Testing

### Test Categories

1. **Smoke Tests** (default) - Fast, no UI
2. **Full Tests** - Comprehensive, includes UI
3. **Robot Tests** - Automated UI interaction
4. **System Tests** - Integration tests

### Running Tests

```bash
# Smoke tests (default, fast)
./gradlew test

# Full test suite
./gradlew -PFULL_TEST=true test

# Full tests with robot tests
./gradlew -PFULL_TEST=true -PUSE_ROBOT=true test

# Test specific module
./gradlew :graphics:test
./gradlew :controls:test

# Test with coverage
./gradlew -PJCOV=true test

# View test reports
open build/reports/tests/test/index.html
```

### Writing Tests

All tests use JUnit 5:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTest {
    @Test
    void testFeature() {
        // Test implementation
        assertEquals(expected, actual);
    }
}
```

Place tests in:
- `modules/[module]/src/test/java/` - Unit tests
- `tests/system/` - System tests
- `apps/tests/` - Application tests

## Code Style and Standards

### Java Code Style

- **Indentation**: 4 spaces (no tabs)
- **Line Length**: 120 characters maximum
- **Braces**: Always use braces for control structures
- **Naming**:
  - Classes: `PascalCase`
  - Methods/Variables: `camelCase`
  - Constants: `UPPER_SNAKE_CASE`

### Code Formatting

The project uses checkstyle:
```bash
# Check code style
./gradlew checkstyleMain checkstyleTest

# Configuration
cat checkstyle.xml
```

### Documentation

- All public APIs must have Javadoc
- Include `@since` tag for new APIs
- Document parameters, returns, and exceptions
- Provide code examples for complex APIs

Example:
```java
/**
 * Creates a new shape with the specified properties.
 *
 * @param width the width of the shape
 * @param height the height of the shape
 * @return a new Shape instance
 * @throws IllegalArgumentException if width or height is negative
 * @since 26
 */
public Shape createShape(double width, double height) {
    // Implementation
}
```

## Debugging

### Debug Build

```bash
# Build with debug symbols
./gradlew -PCONF=Debug sdk

# Java debug only (faster)
./gradlew -PCONF=DebugNative sdk
```

### IDE Debugging

#### IntelliJ IDEA
1. Open project in IntelliJ
2. Go to Run → Edit Configurations
3. Select pre-configured run configuration
4. Click Debug button

#### Eclipse
1. Import as Gradle project
2. Right-click project → Debug As → Java Application
3. Select main class to debug

### Native Code Debugging

#### Linux/macOS (GDB/LLDB)
```bash
# Build with debug symbols
./gradlew -PCONF=Debug sdk

# Run with debugger
gdb --args java -jar app.jar
```

#### Windows (Visual Studio)
1. Build with Debug configuration
2. Attach Visual Studio debugger to java.exe process
3. Load symbols from build output

### Logging

Enable logging:
```bash
# System properties
java -Djavafx.verbose=true -Dprism.verbose=true MyApp

# Environment
export PRISM_DEBUG=1
```

## Contributing

### Workflow

1. **Fork** the repository
2. **Clone** your fork
3. **Create** a feature branch
4. **Make** changes and commit
5. **Test** thoroughly
6. **Push** to your fork
7. **Submit** a pull request

### Pull Request Guidelines

- Title: Start with 7-digit JBS bug ID (e.g., `8123456: Fix button rendering`)
- Description: Explain what and why
- Link JBS issue
- Include tests
- Follow code style
- Update documentation

See [CONTRIBUTING.md](CONTRIBUTING.md) for complete guidelines.

### Commit Messages

```
8123456: Brief summary of change (max 72 chars)

Detailed explanation of the change, why it was made,
and any relevant context. Reference the JBS issue.

Testing: Describe testing performed
```

## Advanced Topics

### Cross-Compilation

Build for different platforms:
```bash
# Build for iOS (on macOS)
./gradlew -PCOMPILE_TARGETS=ios sdk

# Build for ARM (on Linux)
./gradlew -PCOMPILE_TARGETS=armv6hf sdk

# Build multiple targets
./gradlew -PCOMPILE_TARGETS=mac,ios sdk
```

### Custom Build Flags

Create custom compilation flags in `buildSrc/`:
```groovy
// Example: custom-flags.gradle
ext.CUSTOM_CC_FLAGS = ["-O3", "-march=native"]
ext.CUSTOM_LINK_FLAGS = ["-flto"]
```

Reference in gradle.properties:
```properties
COMPILE_FLAGS_FILES = buildSrc/custom-flags.gradle
```

### Performance Profiling

```bash
# Build with profiling
./gradlew -PCONF=Release sdk

# Run with profiler
java -agentlib:hprof=cpu=samples MyApp
```

### Dependency Management

Dependencies are managed in:
- `build.properties` - Version numbers
- `build.gradle` - Dependency declarations

To update a dependency:
1. Update version in `build.properties`
2. Test build: `./gradlew clean sdk`
3. Run tests: `./gradlew test`
4. Commit changes

### Build System Internals

The build system uses:
- **Gradle 9.2.0** - Build automation
- **CMake 3.22.3** - Native builds
- **Ninja** - Fast native compilation

Custom tasks in `build.gradle`:
- `sdk` - Main build task
- `shims` - Test infrastructure
- `buildModules` - Module compilation
- `javadoc` - Documentation generation

## Troubleshooting

### Common Issues

#### Build Fails: "GTK not found"
**Solution**: Install GTK3 development packages
```bash
sudo apt-get install libgtk-3-dev
```

#### Build Fails: "Out of memory"
**Solution**: Increase Gradle memory
```properties
# gradle.properties
org.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=1g
```

#### Tests Fail: "Cannot open display"
**Solution**: Set DISPLAY or use headless mode
```bash
export DISPLAY=:0
# or
./gradlew test -DFULL_TEST=false
```

#### WebKit Build Fails
**Solution**: WebKit requires significant resources
- Ensure 16GB+ RAM available
- Use fewer parallel jobs: `NUM_COMPILE_THREADS=4`
- Or disable WebKit: `COMPILE_WEBKIT=false`

### Getting Help

- **Mailing List**: [openjfx-dev](https://mail.openjdk.org/mailman/listinfo/openjfx-dev)
- **Bug Reports**: [bugs.openjdk.org](https://bugs.openjdk.org)
- **Wiki**: [OpenJFX Wiki](https://wiki.openjdk.org/display/OpenJFX)

## Resources

- [OpenJFX Home](https://openjfx.io)
- [JavaFX Documentation](https://openjfx.io/javadoc/)
- [JavaFX API Docs](https://docs.oracle.com/javafx/)
- [OpenJDK Project](https://openjdk.org)

---

Last Updated: November 2025
