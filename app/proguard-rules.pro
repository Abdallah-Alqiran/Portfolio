# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile



# ==========================
# Basic Android Components
# ==========================

# Keep all activities, services, receivers, providers
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Keep your custom Application class
-keep class com.alqiran.portfoliomain.** extends android.app.Application { *; }

# ==========================
# Jetpack Compose
# ==========================

# Keep Compose internals and compiler-generated classes
-keep class androidx.compose.** { *; }
-keep class androidx.activity.ComponentActivity { *; }
-keep class androidx.compose.runtime.** { *; }
-keep class androidx.compose.ui.** { *; }
-keep class androidx.lifecycle.** { *; }

# Keep composable methods
-keepclassmembers class * {
    @androidx.compose.runtime.Composable <methods>;
}
-keepclasseswithmembers class * {
    @androidx.compose.runtime.Composable <methods>;
}

# Keep lambda-related classes
-keep class *$$Lambda$* { *; }

# ==========================
# Kotlin & Coroutines
# ==========================

# Preserve Kotlin metadata and reflection capabilities
-keepattributes *Annotation*
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-keepattributes Signature
-keepattributes Exceptions
-keepattributes SourceFile,LineNumberTable

-keep class kotlin.** { *; }
-dontwarn kotlin.**

-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# ==========================
# ViewModel and Lifecycle
# ==========================

-keep class androidx.lifecycle.ViewModel
-keep class * extends androidx.lifecycle.ViewModel { *; }

# ==========================
# Native methods (if any)
# ==========================

-keepclasseswithmembernames class * {
    native <methods>;
}

# ==========================
# Logging (optional)
# ==========================

# Remove logging in release builds
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}


-keep class com.alqiran.portfoliomain.data.datasourses.remote.model.*
-keep class com.alqiran.portfoliomain.ui.model.*
-keep class com.alqiran.portfoliomain.ui.navigation.*