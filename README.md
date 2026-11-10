<div align="center">

# 📍 sSimpleSetSpawn

### Lightweight, High-Performance Spawn Management for Modern Minecraft Servers

[![Java Version](https://img.shields.io/badge/Java-8--25%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Minecraft Support](https://img.shields.io/badge/Minecraft-1.8--26.%2B%20(Paper%2FFolia)-00D26A?style=for-the-badge&logo=minecraft&logoColor=white)](https://papermc.io/)
[![MSPT Performance](https://img.shields.io/badge/Performance-0%20MSPT-5555FF?style=for-the-badge&logo=speedtest&logoColor=white)](#performance)
[![Architecture](https://img.shields.io/badge/Architecture-100%25%20Plug%20%26%20Play-gold?style=for-the-badge&logo=checkmarx&logoColor=white)](#installation)
[![Documentation](https://img.shields.io/badge/Docs-docs.starsmc.eu%2Fsimplesetspawn-E6B800?style=for-the-badge&logo=gitbook&logoColor=white)](https://docs.starsmc.eu/simplesetspawn/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue?style=for-the-badge)](LICENSE)

<br/>

[Overview](#overview) • [Key Features](#key-features) • [Commands & Permissions](#commands--permissions) • [Configuration](#configuration) • [Documentation](#documentation) • [Installation](#installation) • [Building](#building-from-source)

</div>

---

## 🌟 Overview

**sSimpleSetSpawn** is a hyper-optimized spawn management plugin engineered by **Stars Development**. Built for administrators who demand rock-solid reliability without bloated mechanics, sSimpleSetSpawn handles standard spawn points, custom newbie arrival hubs, join redirects, and on-death respawn routing with **0 MSPT overhead**.

Compatible with legacy Minecraft versions down to 1.8 as well as modern **Folia** and **Paper** engines up to 1.26+, it delivers instantaneous teleportation with pitch-perfect orientation.

---

## ✨ Key Features

- **⚡ Instantaneous Teleportation (0 MSPT)**: Clean asynchronous location decoding prevents main-thread stalls.
- **🎯 Dual-Spawn Routing**: Separate destination points for veteran players and first-time joining newcomers.
- **🔄 Flexible Join Actions**: Toggle automatic spawn teleportation on regular join, first join, or player respawn.
- **🧭 Angle-Preserving Persistence**: Retains precise world coordinates, pitch, and yaw for cinematic player arrivals.
- **🛡️ Enterprise Hardened**: Bundled with **ProGuard** bytecode optimization and unblocking dependency injection.
- **📦 100% Plug & Play**: Zero initial configuration required—drop the jar into your plugins folder and execute `/setspawn`.

---

## 💻 Commands & Permissions

| Command | Aliases | Description | Default Permission |
| :--- | :--- | :--- | :--- |
| `/spawn` | - | Teleport to the universal spawn point | `simplesetspawn.spawn` |
| `/spawn firstspawn` | `/spawn first` | Teleport to the designated newcomer first spawn | `simplesetspawn.spawn.firstspawn` |
| `/setspawn` | - | Set the global spawn point at current position | `simplesetspawn.setspawn` |
| `/setspawn firstspawn` | `/setspawn first` | Set the dedicated spawn point for first-time joins | `simplesetspawn.setspawn.firstspawn` |
| `/simplesetspawn` | `/sss`, `/ssetspawn` | View plugin version information | `simplesetspawn.admin` |
| `/simplesetspawn reload` | `/sss rl` | Reload configurations and spawn coordinates live | `simplesetspawn.reload` |

---

## ⚙️ Configuration

`config.yml`:
```yaml
# =============================================================
#                  sSimpleSetSpawn Configuration
# =============================================================

update_checker: true

# Teleport to spawn on regular player join
onjoin_spawn: true

# Teleport to the spawn on first join (Disable spawn_for_newbies if true)
on_first_join_spawn: false

# Setup different spawn for first-time joiners (/setspawn firstspawn)
spawn_for_newbies: true

# Teleport player to spawn upon death
on_death_spawn: true

# Plugin Chat Prefix
prefix: "&8[&bSimpleSetSpawn&8] "
```

`spawns.yml`:
```yaml
# Precise serialized coordinate vectors
spawn_location: "world;0.5;64.0;0.5;0.0;0.0"
first_spawn_location: "world;10.5;70.0;10.5;90.0;0.0"
```

---

## 📖 Documentation

For in-depth integration guides, permissions breakdowns, and tutorials, visit the official Stars Development documentation portal:

👉 **[https://docs.starsmc.eu/simplesetspawn/](https://docs.starsmc.eu/simplesetspawn/)**

---

## 🚀 Installation

1. Download `sSimpleSetSpawn-1.3.0.jar`.
2. Move the downloaded `.jar` file into your server's `plugins/` directory.
3. Restart or start your server.
4. Position your character in-game and run:
   - `/setspawn` for default spawn.
   - `/setspawn firstspawn` for newcomer spawn.
5. Customize teleportation toggles in `plugins/sSimpleSetSpawn/config.yml`.

---

## 🛠️ Building from Source

```bash
# Clone repository
git clone https://github.com/Aitooor/SimpleSetSpawn.git
cd SimpleSetSpawn

# Build with Gradle Wrapper
./gradlew build
```

The optimized jar is saved in `build/libs/sSimpleSetSpawn-1.3.0.jar`.

---

## 📄 License

This project is licensed under the terms of the **Apache License 2.0**. See the [LICENSE](LICENSE) file for details.

<div align="center">
  <sub>Engineered with ❤️ by <b>Stars Development</b></sub>
</div>
