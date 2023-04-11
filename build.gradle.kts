plugins{
    id("java")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

group = "online.starsmc"
var pluginVersion = "1.3.0"
version = "no-shaded"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(16))
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.2")

    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("team.unnamed:inject:1.0.1")
    implementation("me.fixeddev:commandflow-bukkit:0.5.2")
}

tasks {
    shadowJar {
        archiveVersion.set(pluginVersion)
        archiveClassifier.set("")
        relocate("org.bstats", "online.starsmc.simplesetspawn.utils.external.metric")

        minimize()
    }
}
tasks {
    build {
        dependsOn("shadowJar")
    }
}