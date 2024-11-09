plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.notesproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notesproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // AndroidX Core Library
    implementation("androidx.core:core-ktx:1.10.1")

    // AppCompat Library for backward compatibility
    implementation(libs.appcompat)

    // Material Design Components for UI styling, FAB, etc.
    implementation(libs.material)

    // Activity and ConstraintLayout
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // RecyclerView for displaying the notes list
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Room Database for SQLite database handling
    implementation("androidx.room:room-runtime:2.5.1")
    annotationProcessor("androidx.room:room-compiler:2.5.1")

    // ViewModel and LiveData for lifecycle-aware data handling
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Glide for loading images
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    // Unit Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
