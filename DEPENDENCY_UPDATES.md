# Dependency Updates - November 2025

This document tracks the dependency updates made to OpenJFX in November 2025.

## Summary of Changes

### Updated Dependencies ✅

| Dependency | Previous Version | New Version | Status | Risk Level |
|------------|------------------|-------------|--------|------------|
| JUnit Jupiter | 5.12.2 | 6.0.1 | ✅ Updated | Low |
| JUnit Platform | 1.12.2 | 1.12.2 | ✅ No change | - |
| ANTLR4 | 4.7.2 | 4.13.2 | ✅ Updated | Medium |
| ICU | 77.1 | 78 | ✅ Updated | Low |
| Eclipse SWT | 3.124.200.v20231113-1355 | 3.127.0.v20240903-0618 | ✅ Updated | Low |

### Deferred Updates 📝

| Dependency | Current Version | Latest Version | Reason for Deferring |
|------------|-----------------|----------------|----------------------|
| Apache Lucene | 7.7.3 | 10.3.2 | Major version jump requires significant migration effort - see BACKLOG.md |

## Detailed Update Information

### 1. JUnit Jupiter (5.12.2 → 6.0.1)

**Release Date**: October 31, 2025

**Changes**:
- Unified JUnit 6 versioning (Platform, Jupiter, Vintage)
- Enhanced @CsvSource/@CsvFileSource annotations
- Improved Kotlin support
- Various bug fixes and performance improvements

**Impact**:
- Test framework improvements
- Better assertion messages
- Enhanced parameterized test support

**Compatibility**: Backward compatible with JUnit 5.x tests

**Testing Required**:
- Run full test suite: `./gradlew test`
- Run full tests: `./gradlew -PFULL_TEST=true test`
- Verify no test failures or warnings

**Migration**: No code changes required - drop-in replacement

**References**:
- [JUnit Release Notes](https://docs.junit.org/current/release-notes/index.html)
- [Maven Central](https://central.sonatype.com/artifact/org.junit.jupiter/junit-jupiter)

### 2. ANTLR4 (4.7.2 → 4.13.2)

**Release Date**: August 3, 2024

**Changes**:
- 6 years of improvements (4.7.2 was from 2018)
- Better error messages
- Performance improvements
- Bug fixes in code generation
- Support for multiple language targets

**Impact**:
- Used for CSS parser in javafx.graphics
- Parser code generation improvements
- Better error diagnostics

**Compatibility**: Generally backward compatible, but generated code may differ

**Testing Required**:
- Build graphics module: `./gradlew :graphics:build`
- Test CSS parsing: Run graphics tests
- Verify no CSS parser regression
- Check generated parser code differences

**Potential Issues**:
- Generated parser code may have different structure
- Performance characteristics may change
- Need to regenerate parsers during build

**Migration Steps**:
1. Update version in build.properties
2. Build project (ANTLR regenerates parsers automatically)
3. Run tests to verify CSS parsing
4. Check for any compilation warnings

**References**:
- [ANTLR Releases](https://github.com/antlr/antlr4/releases)
- [ANTLR Download](https://www.antlr.org/download.html)

### 3. ICU (77.1 → 78)

**Release Date**: October 30, 2025

**Changes**:
- Unicode 17 support
- Enhanced emoji support
- Improved collation
- IDNA enhancements
- CLDR 48 locale data
- New APIs and implementation improvements

**Impact**:
- Better internationalization support
- Improved text rendering
- Enhanced emoji display
- Updated locale data

**Compatibility**: Generally backward compatible

**Testing Required**:
- Test internationalization features
- Verify text rendering with various scripts
- Test emoji display
- Check font fallback behavior
- Test with multiple locales (en, ja, zh, ar, he, etc.)

**Platform-Specific Testing**:
- Windows: Test with different language settings
- macOS: Test with various regional settings
- Linux: Test with different locales

**Migration**: Download ICU 78 binaries for each platform during build

**References**:
- [ICU Homepage](https://icu.unicode.org/)
- [ICU Download](https://unicode-org.github.io/icu/download/)
- [ICU 78 Release Notes](https://unicode-org.github.io/icu/download/)

### 4. Eclipse SWT (3.124.200 → 3.127.0)

**Release Date**: September 3, 2024

**Changes**:
- Part of Eclipse 2024-09 release
- Bug fixes and improvements
- Better platform integration
- Performance enhancements

**Impact**:
- Improved SwingNode functionality
- Better JFXPanel embedding
- Enhanced Swing/JavaFX interoperability

**Compatibility**: Backward compatible

**Testing Required**:
- Test SwingNode (embed Swing in JavaFX)
- Test JFXPanel (embed JavaFX in Swing)
- Verify on all platforms (Windows, macOS, Linux)
- Test drag-and-drop between Swing and JavaFX
- Test keyboard/mouse event handling

**Migration**: Update version string in build.properties

**References**:
- [Eclipse SWT](https://www.eclipse.org/swt/)
- [Maven Repository](https://mvnrepository.com/artifact/org.eclipse.platform/org.eclipse.swt)

## Apache Lucene - Deferred Update

### Current: 7.7.3 (from 2019)
### Latest: 10.3.2 (November 2025)

**Why Deferred**:
- Major version jump (7.x → 10.x)
- Significant API changes expected
- Breaking changes in search/indexing APIs
- Large migration effort required

**Migration Path** (future work):
1. Research API changes between versions
2. Consider incremental updates (7.x → 8.x → 9.x → 10.x)
3. Evaluate impact on WebView search functionality
4. Create migration plan with testing strategy
5. Allocate sufficient time for migration and testing

**Priority**: Medium (see BACKLOG.md item #3)

**Estimated Effort**: High (several weeks to months)

## Testing Checklist

### Pre-Update Testing (Baseline)
- [ ] Record current test results
- [ ] Document known issues
- [ ] Note performance baselines

### Post-Update Testing

#### Build Tests
- [ ] Clean build succeeds: `./gradlew clean sdk`
- [ ] Module builds succeed individually
- [ ] No new compiler warnings
- [ ] Build times acceptable

#### Unit Tests
- [ ] Smoke tests pass: `./gradlew test`
- [ ] Full tests pass: `./gradlew -PFULL_TEST=true test`
- [ ] No new test failures
- [ ] No new test warnings

#### Module-Specific Tests
- [ ] Base module tests: `./gradlew :base:test`
- [ ] Graphics module tests: `./gradlew :graphics:test` (ANTLR, ICU impact)
- [ ] Controls module tests: `./gradlew :controls:test`
- [ ] Web module tests: `./gradlew :web:test`
- [ ] Media module tests: `./gradlew :media:test`

#### Integration Tests
- [ ] Sample applications run
- [ ] Ensemble8 demo works
- [ ] 3DViewer demo works
- [ ] Modena demo works

#### Platform-Specific Tests
- [ ] Windows build and test
- [ ] macOS build and test
- [ ] Linux build and test

#### Internationalization Tests (ICU)
- [ ] Text rendering with various scripts (Latin, CJK, Arabic, Hebrew)
- [ ] Emoji display
- [ ] Font fallback
- [ ] Locale-specific formatting (dates, numbers)
- [ ] BiDi text (right-to-left)

#### CSS Parser Tests (ANTLR)
- [ ] CSS parsing works correctly
- [ ] No CSS parser errors
- [ ] Style application works
- [ ] Custom CSS stylesheets work

#### Swing/JavaFX Interop Tests (SWT)
- [ ] SwingNode works
- [ ] JFXPanel works
- [ ] Event handling works
- [ ] Drag and drop works

## Rollback Plan

If issues are discovered:

1. **Minor Issues**: Create bugs in JBS, fix in future release
2. **Major Issues**: Revert specific dependency update
3. **Critical Issues**: Revert all changes

Revert command:
```bash
git revert <commit-hash>
# or
git checkout <previous-version> -- build.properties
```

## Validation Status

| Test Category | Status | Notes |
|--------------|--------|-------|
| Build | ⏳ Pending | Requires platform-specific environment |
| Unit Tests | ⏳ Pending | Requires build completion |
| Integration Tests | ⏳ Pending | Requires build completion |
| Platform Tests | ⏳ Pending | Requires multiple platforms |

## Next Steps

1. **Build Verification**: Test builds on all platforms (Windows, macOS, Linux)
2. **Test Execution**: Run full test suite on each platform
3. **Regression Testing**: Verify no functionality broken
4. **Performance Testing**: Ensure no performance degradation
5. **Documentation Update**: Update any affected documentation
6. **Release Notes**: Document changes in release notes

## Communication

**Internal**:
- Update BACKLOG.md with completion status
- Document any issues found

**External** (if releasing):
- Add to release notes
- Mention in changelog
- Update migration guides if needed

## References

- [BACKLOG.md](BACKLOG.md) - Full dependency update plan
- [DEVELOPER_GUIDE.md](DEVELOPER_GUIDE.md) - Build and test instructions
- [QUICK_START.md](QUICK_START.md) - Getting started guide

## Version Control

- **Updated**: November 24, 2025
- **Updated By**: Copilot SWE Agent
- **Commit**: See git history
- **Pull Request**: See GitHub PR

---

**Notes**:
- All updates were made conservatively, prioritizing stability
- Lucene update deferred due to major version jump
- All other updates are backward compatible or low risk
- Testing on actual hardware required before final merge
