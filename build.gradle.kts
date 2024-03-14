/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.6.4/samples
 */

plugins {
    java
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.gradlestuff.builder.Builder"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.named <Test>("test") {
    useJUnitPlatform()
}