import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"

    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    implementation("com.google.guava:guava:31.1-jre")
    implementation(kotlin("stdlib-jdk8"))
}

application {
    mainClass.set("nl.arnokoehler.dev.akif.cli.CliAppKt")
}

sourceSets {
    main {
        kotlin {
            srcDirs("app/src/main/kotlin")
        }
    }
    test {
        kotlin {
            srcDirs("app/src/test/kotlin")
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}