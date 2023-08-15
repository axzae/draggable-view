# DraggableView

<p>

[![build](https://img.shields.io/github/actions/workflow/status/axzae/draggable-view/pre-merge.yaml?branch=main)][actions]
[![github tag](https://img.shields.io/github/v/tag/axzae/draggable-view?label=github)][releases]
[![maven central](https://img.shields.io/maven-central/v/com.axzae/draggable-view)][mavencentral]

</p>

DraggableView is an Android library to make floating draggable view easy.

This is the enhancement version of [hyuwah's DraggableView](https://github.com/hyuwah/DraggableView). By using this version, you can:
- Embrace full AndroidX (with Jetifier disabled)
- Use MavenCentral
- Fix sticky calculation issue

## Setup

#### Gradle

```kotlin
// build.gradle.kts (app module)

dependencies {
    implementation("com.axzae:draggable-view:1.1.0")
}
```


## See Also

- [Full Usage Guide](https://github.com/hyuwah/DraggableView#basic-usage)

[mavencentral]: https://central.sonatype.com/artifact/com.axzae/draggable-view
[actions]: https://github.com/axzae/draggable-view/actions
[releases]: https://github.com/axzae/draggable-view/releases
