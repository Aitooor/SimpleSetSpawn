# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.3.0] - 2026-11-10

### Overview
Official commercial and open-source modernization release for **SimpleSetSpawn** (Open Source Plugin).
Documentation: https://docs.starsmc.eu/

### Added
- Native Folia multi-threading support via FoliaLib (`com.tcoded:FoliaLib:0.4.3`) with safe cross-region teleports (`teleportAsync`).
- Developer API `eu.starsmc.simplesetspawn.api.SimpleSetSpawnAPI` (`getSpawnLocation`, `teleportToSpawn`, `setSpawnLocation`) with `SimpleSetSpawnAPI.get()` and Bukkit ServicesManager registration.
- Official Stars branding with Adventure MiniMessage `<yellow>` and `<white>` styling.
- Support for Minecraft versions from 1.8.8 up to modern 26.3 and 26.4.

### Changed
- Declared `folia-supported: true` in `paper-plugin.yml`.

### Fixed
- Prevented async scheduler exceptions on Folia and Paper 1.20+.
