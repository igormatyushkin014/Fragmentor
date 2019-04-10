<p align="center">
  <a href="https://http://www.android.com">
		<img src="https://img.shields.io/badge/android-15-green.svg?style=flat">
	</a>
	<a href="https://jitpack.io/#igormatyushkin014/Fragmentor">
		<img src="https://jitpack.io/v/igormatyushkin014/Fragmentor.svg">
	</a>
	<a href="https://tldrlegal.com/license/apache-license-2.0-(apache-2.0)">
		<img src="https://img.shields.io/badge/License-Apache 2.0-blue.svg?style=flat">
	</a>
</p>

## At a Glance

`Fragmentor` is a fragment-based navigation manager for Android. It solves common issues related to navigation between fragments.

## How to Get Started

Add `jitpack.io` repository to your project:

```javascript
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Then add `TellMe` to dependencies list:

```javascript
dependencies {
    implementation 'com.github.igormatyushkin014:Fragmentor:1.0'
}
```

## Requirements

* Android SDK 15 and later
* Android Studio 3.3 and later
* Kotlin 1.3 or later

## Usage

### Preparations

Put `FrameLayout` with `fragmentor` ID into your activity's layout just like in example below:

```xml
...
<FrameLayout
    ...
    id="@+id/fragmentor"
    />
...
```

You're all set!

### Navigation from activity

Now you can display a fragment from your activity:

```kotlin
fragmentor().push(MyFragment())
```

In the example above, the fragment will be pushed to the top of stack.

Also, it's possible to push an array of fragments:

```kotlin
fragmentor().push(
    arrayOf(
        MyFragment(),
        AnotherFragment(),
        OneMoreFragment()
    )
)
```

Navigate back:

```kotlin
fragmentor().pop()
```

Navigate back to the first fragment:

```kotlin
fragmentor().popToBottom()
```

### Navigation from fragment

You can use `fragmentor()` directly from your fragment class. The method will return navigation manager for fragment's activity:

```kotlin
fragmentor()?.push(AnotherFragment())
```

## License

`Fragmentor` is available under the Apache 2.0 license. See the [LICENSE](./LICENSE) file for more info.
