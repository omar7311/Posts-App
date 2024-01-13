plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.socialmedia"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.socialmedia"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
   buildFeatures {
       viewBinding=true
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

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //circle image
    implementation("de.hdodenhof:circleimageview:3.1.0")
    // retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // retrofit converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //json
    implementation( "com.google.code.gson:gson:2.10.1")
}