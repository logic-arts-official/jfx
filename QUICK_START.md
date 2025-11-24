# Quick Start Guide for OpenJFX Development

This guide will help you get up and running with OpenJFX development quickly.

## Prerequisites

Before you begin, ensure you have the following installed:

### Required
- **JDK 25** or later (minimum JDK 24)
  - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://jdk.java.net/)
  - Set `JAVA_HOME` environment variable
- **Git** - for version control
- **Gradle** 9.2.0 (included via Gradle Wrapper, no separate installation needed)

### Platform-Specific Requirements

#### Linux
```bash
# Ubuntu/Debian
sudo apt-get install build-essential libgtk-3-dev libgtk2.0-dev libxtst-dev \
  libasound2-dev libavcodec-dev libavformat-dev libavutil-dev libgl1-mesa-dev \
  libglu1-mesa-dev libx11-dev pkg-config cmake ninja-build

# Fedora/RHEL
sudo dnf install gtk3-devel gtk2-devel libXtst-devel alsa-lib-devel \
  ffmpeg-devel mesa-libGL-devel mesa-libGLU-devel libX11-devel \
  pkg-config cmake ninja-build gcc-c++
```

#### macOS
```bash
# Install Xcode Command Line Tools
xcode-select --install

# Xcode 15.4+ recommended
```

#### Windows
- **Visual Studio 2022** (17.13.2 or later)
  - Install "Desktop development with C++" workload
- **CMake** 3.22.3 or later

## Quick Setup (5 Minutes)

### 1. Clone the Repository
```bash
git clone https://github.com/logic-arts-official/jfx.git
cd jfx
```

### 2. Build the SDK
```bash
# Simple build (no WebKit or Media)
./gradlew sdk

# Full build (includes WebKit and Media - takes longer)
./gradlew -PCOMPILE_WEBKIT=true -PCOMPILE_MEDIA=true sdk
```

**Note:** The first build will download dependencies and may take 10-30 minutes depending on your system.

### 3. Verify the Build
```bash
# Run tests (smoke test by default)
./gradlew test

# Run a sample application
cd apps/samples/Ensemble8
../../../gradlew run
```

## Build Configuration

Create a `gradle.properties` file in the project root to customize your build:

```properties
# Minimal configuration for faster builds
COMPILE_WEBKIT = false
COMPILE_MEDIA = false

# Enable for full functionality
#COMPILE_WEBKIT = true
#COMPILE_MEDIA = true

# Run full tests instead of smoke tests
#FULL_TEST = true
```

Copy from template:
```bash
cp gradle.properties.template gradle.properties
```

## Common Commands

```bash
# Build SDK
./gradlew sdk

# Clean and rebuild
./gradlew clean sdk

# Build and run tests
./gradlew test

# Build specific module
./gradlew :base:build
./gradlew :graphics:build
./gradlew :controls:build

# Generate JavaDoc
./gradlew javadoc

# List all available tasks
./gradlew tasks
```

## IDE Setup

### IntelliJ IDEA
1. Open the project directory in IntelliJ IDEA
2. The IDE will automatically detect the Gradle configuration
3. Wait for initial indexing to complete
4. Run configurations are pre-configured in `.idea/runConfigurations/`

### Eclipse
1. Import as "Existing Gradle Project"
2. Select the project root directory
3. Follow the import wizard

### VS Code
1. Install the "Java Extension Pack"
2. Open the project folder
3. VS Code will detect the Gradle build automatically

## Build Output

After a successful build, you'll find:
- **SDK**: `build/sdk/`
- **Modular SDK**: `build/modular-sdk/`
- **JavaDoc**: `build/javadoc/`
- **Test Results**: `build/reports/`

## Troubleshooting

### Build Fails with "GTK3 not found"
Install GTK3 development packages (see Platform-Specific Requirements above).

### Out of Memory Error
Increase Gradle memory in `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=1g
```

### WebKit Build Fails
WebKit requires significant resources. Try:
```bash
./gradlew -PCOMPILE_WEBKIT=false sdk
```

### Tests Fail
Run smoke tests first (default) before full tests:
```bash
./gradlew test
```

## Next Steps

- Read [DEVELOPER_GUIDE.md](DEVELOPER_GUIDE.md) for detailed information
- Review [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidelines
- Check [ARCHITECTURE.md](ARCHITECTURE.md) to understand the codebase structure
- See [PROS_CONS.md](PROS_CONS.md) for project capabilities and limitations

## Getting Help

- **Mailing List**: [openjfx-dev@openjdk.org](https://mail.openjdk.org/mailman/listinfo/openjfx-dev)
- **Issue Tracker**: [bugs.openjdk.org](https://bugs.openjdk.org)
- **Documentation**: [openjfx.io](https://openjfx.io)
- **Wiki**: [OpenJFX Build Instructions](https://wiki.openjdk.org/display/OpenJFX/Building+OpenJFX)

## Quick Reference Card

| Task | Command |
|------|---------|
| Build SDK | `./gradlew sdk` |
| Run tests | `./gradlew test` |
| Clean build | `./gradlew clean` |
| Build specific module | `./gradlew :module:build` |
| Generate docs | `./gradlew javadoc` |
| Run sample app | `cd apps/samples/Ensemble8 && ../../../gradlew run` |

---

**Estimated Time to First Build**: 10-30 minutes (depending on system and build options)

**Estimated Time to Productive Development**: 1-2 hours (including environment setup and familiarization)
