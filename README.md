# OpenJFX

OpenJFX is an open source, next generation client application platform for desktop, mobile and embedded systems based on JavaSE. It is a collaborative effort by many individuals and companies with the goal of producing a modern, efficient, and fully featured toolkit for developing rich client applications. This is the open source project where we develop JavaFX.

OpenJFX is free software, licensed under [GPL v2 with the Classpath exception](LICENSE), just like the JDK. Anybody is welcome to contribute to this project, port it to other platforms or devices, or do anything else that a free software license allows you to do!

OpenJFX is a project under the charter of the OpenJDK. The [OpenJDK Bylaws](https://openjdk.org/bylaws) and [License](LICENSE) govern our work. The OpenJFX project membership can be found on the [OpenJDK Census](https://openjdk.org/census#openjfx). We welcome patches and involvement from individual contributors or companies. If this is your first time contributing to an OpenJDK project, you will need to review the rules on [becoming a Contributor](https://openjdk.org/bylaws#contributor), and sign the [Oracle Contributor Agreement](https://oca.opensource.oracle.com/) (OCA).

## Issue tracking

If you think you have found a bug in OpenJFX, first make sure that you are testing against the latest version - your issue may already have been fixed. If not, search our [issues list](https://bugs.openjdk.org/issues/?filter=39543) in the Java Bug System (JBS) in case a similar issue has already been opened. More information on where and how to report a bug can be found at [bugreport.java.com](https://bugreport.java.com/).

## Getting Started

### Quick Start for Developers

**New to OpenJFX development? Start here!**

- 📖 **[Quick Start Guide](QUICK_START.md)** - Get up and running in 10 minutes
- 📚 **[Developer Guide](DEVELOPER_GUIDE.md)** - Comprehensive development documentation
- 🏗️ **[Architecture Overview](ARCHITECTURE.md)** - Understand how OpenJFX works
- ⚖️ **[Pros & Cons](PROS_CONS.md)** - When to use OpenJFX and when to consider alternatives
- 📝 **[Project Backlog](BACKLOG.md)** - Planned improvements and known issues

### Prerequisites

- **JDK 25** or later (minimum JDK 24)
- **Platform-specific build tools** (see [Quick Start Guide](QUICK_START.md))

### Building from Source

```bash
# Clone the repository
git clone https://github.com/logic-arts-official/jfx.git
cd jfx

# Build the SDK (simple build without WebKit/Media)
./gradlew sdk

# Or full build with all features
./gradlew -PCOMPILE_WEBKIT=true -PCOMPILE_MEDIA=true sdk
```

For detailed build instructions, see the [Quick Start Guide](QUICK_START.md) or the [Building OpenJFX](https://wiki.openjdk.org/display/OpenJFX/Building+OpenJFX) Wiki page.

### Using JavaFX

For information about downloading and using JavaFX in your applications, see the [JavaFX community site](https://openjfx.io/).

## Documentation

- **[QUICK_START.md](QUICK_START.md)** - Fast track to building and running OpenJFX
- **[DEVELOPER_GUIDE.md](DEVELOPER_GUIDE.md)** - Comprehensive guide for developers
- **[ARCHITECTURE.md](ARCHITECTURE.md)** - Technical architecture and design
- **[PROS_CONS.md](PROS_CONS.md)** - Objective analysis of OpenJFX
- **[BACKLOG.md](BACKLOG.md)** - Roadmap and planned improvements
- **[CONTRIBUTING.md](CONTRIBUTING.md)** - How to contribute to the project
- **[README-code-reviews.md](README-code-reviews.md)** - Code review policies

## Contributing

We welcome contributions! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

Before contributing, review:
1. [Developer Guide](DEVELOPER_GUIDE.md) - Development setup and workflow
2. [Architecture Overview](ARCHITECTURE.md) - Understand the codebase
3. [Backlog](BACKLOG.md) - See what needs work

## Features

- **Rich UI Controls**: Comprehensive set of standard and advanced UI components
- **Hardware Acceleration**: GPU-accelerated graphics via Prism rendering engine
- **CSS Styling**: Complete styling system similar to web CSS
- **FXML**: Declarative UI markup language with Scene Builder support
- **Media Support**: Audio and video playback
- **WebView**: Embedded WebKit-based browser
- **3D Graphics**: Basic 3D scene graph support
- **Cross-Platform**: Windows, macOS, Linux, and embedded systems

## Community & Support

- **Mailing List**: [openjfx-dev@openjdk.org](https://mail.openjdk.org/mailman/listinfo/openjfx-dev)
- **Issue Tracking**: [Java Bug System (JBS)](https://bugs.openjdk.org/issues/?filter=39543)
- **Community Site**: [openjfx.io](https://openjfx.io/)
- **Wiki**: [OpenJFX Wiki](https://wiki.openjdk.org/display/OpenJFX)

## License

OpenJFX is licensed under the [GPL v2 with the Classpath exception](LICENSE), the same license as the JDK. This allows you to use JavaFX in both open-source and commercial applications.
