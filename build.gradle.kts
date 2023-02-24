import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"

    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.beust:jcommander:1.78")
    implementation("org.freemarker:freemarker:2.3.31")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("commons-io:commons-io:2.11.0")


    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

application {
    mainClass.set("nl.arnokoehler.dev.akif.cli.CliAppKt")
}

sourceSets {
    main {
        kotlin {
            srcDirs("app/src/main/kotlin")
        }
        resources {
            srcDirs("app/src/main/resources")
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