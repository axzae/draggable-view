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

## Usage

In `layout.xml`:
```xml
<LinearLayout
    android:id="@+id/layout_jail"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="48dp"
    android:background="#40003300"
    android:orientation="vertical">

    <LinearLayout
      android:id="@+id/layout_text"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:background="#a0f3409a"
      android:orientation="vertical"
      android:padding="8dp">

      <TextView
        android:id="@+id/text_x"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text_x" />

      <TextView
        android:id="@+id/text_y"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text_y" />
    </LinearLayout>
  </LinearLayout>
````

In `fragment.kt`:
```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    DraggableView.Builder(binding.layoutText)
        .setStickyMode(DraggableView.Mode.STICKY_XY)
        .build()
}
```


## See Also

- [Full Usage Guide](https://github.com/hyuwah/DraggableView#basic-usage)

[mavencentral]: https://central.sonatype.com/artifact/com.axzae/draggable-view
[actions]: https://github.com/axzae/draggable-view/actions
[releases]: https://github.com/axzae/draggable-view/releases
