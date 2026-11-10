plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

group = "online.starsmc"
val pluginVersion = "1.3.0"
version = "no-shaded"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://jitpack.io")
    maven("https://repo.triumphteam.dev/snapshots/")
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.5")
    compileOnly("javax.inject:javax.inject:1")

    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("team.unnamed:inject:1.0.1")
    implementation("dev.triumphteam:triumph-cmd-bukkit:2.0.0-SNAPSHOT")
}

tasks {
    shadowJar {
        archiveVersion.set(pluginVersion)
        archiveClassifier.set("")
        relocate("org.bstats", "online.starsmc.simplesetspawn.utils.external.metric")

        minimize()
    }

    build {
        dependsOn("shadowJar")
    }
}