# OpenJFX Project Backlog

This document tracks potential improvements, known issues, and planned enhancements for the OpenJFX project.

## Table of Contents

- [Dependency Updates](#dependency-updates)
- [Documentation Improvements](#documentation-improvements)
- [Build System Enhancements](#build-system-enhancements)
- [Developer Experience](#developer-experience)
- [Performance Improvements](#performance-improvements)
- [Platform Support](#platform-support)
- [Known Issues](#known-issues)
- [Long-Term Goals](#long-term-goals)

## Dependency Updates

### High Priority 🔴

#### 1. JUnit Jupiter Update
- **Current Version**: 5.12.2
- **Latest Version**: 6.0.1 (released October 2025)
- **Impact**: Testing framework improvements, new assertions, Kotlin support
- **Effort**: Low (API compatible upgrade)
- **Risk**: Low
- **Action**: 
  - Update `junit.jupiter.version=6.0.1` in build.properties
  - Update `junit.platform.version=1.12.2` (check latest)
  - Run full test suite to verify compatibility
  - Update any test code using deprecated APIs

#### 2. ANTLR4 Update
- **Current Version**: 4.7.2 (from 2018)
- **Latest Version**: 4.13.2 (August 2024)
- **Impact**: Parser improvements, bug fixes, better error messages
- **Effort**: Medium (may require parser regeneration)
- **Risk**: Medium (CSS parser dependency)
- **Action**:
  - Update `antlr4.version=4.13.2` in build.properties
  - Regenerate parsers in javafx.graphics (CSS parser)
  - Test CSS parsing thoroughly
  - Verify performance impact
  - Check for breaking changes in generated code

### Medium Priority 🟡

#### 3. Apache Lucene Update
- **Current Version**: 7.7.3 (from 2019)
- **Latest Version**: 10.3.2 (November 2025)
- **Impact**: Better search, indexing improvements, security fixes
- **Effort**: High (major version jump, API changes likely)
- **Risk**: High (breaking API changes from 7.x to 10.x)
- **Action**:
  - Research API changes between 7.x and 10.x
  - Evaluate migration effort
  - Consider staying on 7.x if migration too costly
  - Alternative: Update to 8.x or 9.x first (incremental)
  - Test search functionality in WebView if applicable

#### 4. ICU (International Components for Unicode) Update
- **Current Version**: 77.1
- **Latest Version**: 78 (October 2025)
- **Impact**: Unicode 17 support, improved emoji, collation updates
- **Effort**: Low (incremental update)
- **Risk**: Low
- **Action**:
  - Update `icu.version=78` in build.properties
  - Download ICU 78 binaries for each platform
  - Test internationalization features
  - Verify text rendering and font fallback
  - Test with various locales

### Low Priority 🟢

#### 5. Eclipse SWT Update
- **Current Version**: 3.124.200.v20231113-1355
- **Latest Version**: 3.127.0 (September 2024)
- **Impact**: Better SWT integration, bug fixes
- **Effort**: Low
- **Risk**: Low (only affects SwingNode/JFXPanel)
- **Action**:
  - Update `swt.version=3.127.0.v20240903-0618` in build.properties
  - Test SwingNode functionality
  - Test JFXPanel embedding
  - Verify on all platforms (Windows, macOS, Linux)

#### 6. Gradle Update
- **Current Version**: 9.2.0
- **Latest Version**: Check gradle.org for latest
- **Impact**: Build improvements, better caching
- **Effort**: Low
- **Risk**: Low
- **Action**:
  - Update gradle-wrapper.properties
  - Update `jfx.gradle.version` in build.properties
  - Test build on all platforms
  - Verify CI/CD compatibility

## Documentation Improvements

### Completed ✅

- [x] Created QUICK_START.md - Developer quick setup guide
- [x] Created DEVELOPER_GUIDE.md - Comprehensive developer documentation
- [x] Created ARCHITECTURE.md - Architecture and design overview
- [x] Created PROS_CONS.md - Objective analysis of strengths/limitations
- [x] Created BACKLOG.md - This file

### In Progress 🔄

- [ ] Update README.md with better project overview and links to new docs

### Planned 📋

#### 7. API Documentation Improvements
- **Priority**: Medium
- **Effort**: High
- **Description**: Improve JavaDoc coverage and quality
- **Actions**:
  - Add more code examples to JavaDoc
  - Document common patterns and best practices
  - Add diagrams to complex APIs
  - Ensure all public APIs have JavaDoc
  - Add @since tags consistently

#### 8. Tutorial Series
- **Priority**: Medium
- **Effort**: High
- **Description**: Create step-by-step tutorials
- **Topics**:
  - Getting started with JavaFX
  - Building your first application
  - Custom controls development
  - Advanced graphics and animation
  - Performance optimization
  - Deployment and packaging

#### 9. Migration Guides
- **Priority**: Medium
- **Effort**: Medium
- **Description**: Guides for migrating to JavaFX
- **Guides**:
  - Swing to JavaFX migration
  - JavaFX 8 to JavaFX 11+ migration
  - Updating to latest JavaFX version

#### 10. Video Tutorials
- **Priority**: Low
- **Effort**: High
- **Description**: Create video content
- **Topics**:
  - Quick start walkthrough
  - Scene Builder tutorial
  - Common patterns demonstration

## Build System Enhancements

### 11. Improve Build Speed
- **Priority**: High
- **Effort**: Medium
- **Description**: Reduce build times
- **Actions**:
  - Enable Gradle build cache
  - Implement incremental compilation where possible
  - Parallelize independent build tasks
  - Profile build to find bottlenecks
  - Consider ccache for native code

### 12. Docker Build Environment
- **Priority**: Medium
- **Effort**: Medium
- **Description**: Provide Docker images for consistent builds
- **Benefits**:
  - Reproducible builds
  - Easy CI/CD setup
  - No local dependency installation
- **Actions**:
  - Create Dockerfiles for Linux, Windows (WSL)
  - Document Docker-based workflow
  - Add to CI/CD pipeline

### 13. Simplified WebKit Build
- **Priority**: Low
- **Effort**: High
- **Description**: Make WebKit easier to build
- **Challenges**:
  - WebKit is complex and large
  - Platform-specific build issues
  - Long build times
- **Actions**:
  - Better documentation
  - Pre-built binaries option
  - Separate WebKit build instructions

## Developer Experience

### 14. Hot Reload Support
- **Priority**: Medium
- **Effort**: High
- **Description**: Enable hot reload for faster development
- **Approach**:
  - FXML hot reload (reload FXML without restart)
  - CSS hot reload (already partially supported)
  - Java code hot swap (via JVM hot swap)
- **Benefits**:
  - Faster iteration
  - Better developer experience

### 15. Enhanced Scene Builder
- **Priority**: Low
- **Effort**: High (external tool)
- **Description**: Improve Scene Builder or create alternative
- **Issues**:
  - Limited compared to modern UI designers
  - Missing some controls
  - Could be more intuitive
- **Actions**:
  - Contribute to Scene Builder project
  - Or create new visual designer
  - Add component marketplace

### 16. Better Error Messages
- **Priority**: Medium
- **Effort**: Medium
- **Description**: Improve error messages and diagnostics
- **Areas**:
  - CSS parsing errors (more specific)
  - FXML loading errors (better stack traces)
  - Layout errors (why did layout fail?)
  - Property binding errors (clearer messages)

### 17. Development Tools
- **Priority**: Low
- **Effort**: Medium
- **Description**: Create developer tools
- **Tools**:
  - Scene graph inspector (like browser dev tools)
  - CSS inspector and editor
  - Performance profiler
  - Memory analyzer
  - Layout debugger

## Performance Improvements

### 18. Startup Time Optimization
- **Priority**: High
- **Effort**: High
- **Description**: Reduce application startup time
- **Approaches**:
  - Lazy loading of modules
  - Class data sharing (CDS)
  - Ahead-of-time (AOT) compilation
  - Profile-guided optimization
  - Reduce static initialization
- **Target**: <1 second cold start

### 19. Memory Usage Optimization
- **Priority**: Medium
- **Effort**: Medium
- **Description**: Reduce memory footprint
- **Actions**:
  - Profile memory usage
  - Optimize texture caching
  - Reduce duplicate resources
  - Better garbage collection tuning
  - Documentation on memory optimization

### 20. Rendering Performance
- **Priority**: Medium
- **Effort**: Medium
- **Description**: Improve rendering performance
- **Areas**:
  - Better dirty region tracking
  - More efficient scene graph traversal
  - Optimize shader compilation
  - Reduce CPU-GPU synchronization
  - Better layer caching strategies

## Platform Support

### 21. Apple Silicon Optimization
- **Priority**: High
- **Effort**: Medium
- **Description**: Optimize for ARM-based Macs
- **Status**: Basic support exists, needs optimization
- **Actions**:
  - Profile on Apple Silicon
  - Optimize Metal backend
  - ARM-specific optimizations
  - Test on M1/M2/M3 chips

### 22. Wayland Support (Linux)
- **Priority**: Medium
- **Effort**: High
- **Description**: Support Wayland compositor
- **Status**: Currently uses X11 via XWayland
- **Benefit**: Native Wayland support for better performance
- **Challenge**: Significant engineering effort

### 23. Android Support Enhancement
- **Priority**: Low
- **Effort**: High
- **Description**: Improve Android support
- **Status**: Requires Gluon Mobile (commercial)
- **Ideal**: Open-source Android backend
- **Reality**: Complex due to Android platform differences

### 24. Web Assembly (Wasm) Support
- **Priority**: Low
- **Effort**: Very High
- **Description**: Compile JavaFX to WebAssembly
- **Benefit**: Run in browser
- **Challenge**: 
  - JVM to Wasm compilation
  - OpenGL to WebGL translation
  - Performance implications
- **Status**: Research/experimental

## Known Issues

### 25. High DPI Scaling (Windows)
- **Priority**: High
- **Severity**: Medium
- **Description**: Inconsistent scaling on Windows with mixed DPI
- **Workaround**: Force single DPI mode
- **Fix**: Improve DPI awareness

### 26. Font Rendering on Linux
- **Priority**: Medium
- **Severity**: Low
- **Description**: Font rendering not as smooth as native
- **Status**: Ongoing improvements
- **Action**: Better FreeType integration

### 27. Memory Leaks in WebView
- **Priority**: Medium
- **Severity**: Medium
- **Description**: WebView can leak memory on long-running apps
- **Workaround**: Dispose WebView properly
- **Fix**: Investigate WebKit integration

### 28. Media Codec Support
- **Priority**: Low
- **Severity**: Low
- **Description**: Limited codec support
- **Limitation**: Depends on platform codecs
- **Enhancement**: Bundle more codecs or use FFmpeg

## Long-Term Goals

### 29. Modern Graphics APIs
- **Priority**: Low
- **Effort**: Very High
- **Description**: Support modern graphics APIs
- **APIs**:
  - Vulkan (cross-platform)
  - Metal (already supported on macOS)
  - DirectX 12 (Windows)
- **Benefit**: Better performance, newer features
- **Challenge**: Significant rewrite of graphics pipeline

### 30. Declarative UI Language Enhancement
- **Priority**: Low
- **Effort**: High
- **Description**: Enhance or replace FXML
- **Ideas**:
  - More concise syntax
  - Better IDE support
  - Type safety
  - Component composition
- **Inspiration**: SwiftUI, Jetpack Compose

### 31. Reactive Programming Support
- **Priority**: Low
- **Effort**: Medium
- **Description**: Better integration with reactive streams
- **Approach**:
  - RxJavaFX improvements
  - Native reactive support
  - Flow API integration (Java 9+)

### 32. Component Marketplace
- **Priority**: Low
- **Effort**: High
- **Description**: Create marketplace for third-party components
- **Features**:
  - Controls
  - Themes
  - Templates
  - Tools
- **Benefit**: Grow ecosystem

### 33. Cloud Integration
- **Priority**: Low
- **Effort**: Medium
- **Description**: Better cloud service integration
- **Services**:
  - Authentication (OAuth, SSO)
  - Storage (S3, Azure Blob)
  - Databases
  - Analytics
- **Approach**: Provide integration libraries/examples

## Contributing to This Backlog

Have ideas for improvements? Want to work on an item?

1. **Discuss on Mailing List**: [openjfx-dev](https://mail.openjdk.org/mailman/listinfo/openjfx-dev)
2. **File JBS Issue**: [bugs.openjdk.org](https://bugs.openjdk.org)
3. **Submit Pull Request**: Follow [CONTRIBUTING.md](CONTRIBUTING.md)

## Priority Legend

- 🔴 **High Priority**: Should be addressed soon, significant impact
- 🟡 **Medium Priority**: Important but not urgent
- 🟢 **Low Priority**: Nice to have, low impact

## Effort Legend

- **Low**: Days to weeks
- **Medium**: Weeks to months
- **High**: Months to quarters
- **Very High**: Quarters to years

---

Last Updated: November 2025

**Note**: This backlog represents potential improvements and is not a commitment to implement all items. Priorities may change based on community needs and resources.
