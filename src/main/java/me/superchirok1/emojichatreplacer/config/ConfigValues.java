package me.superchirok1.emojichatreplacer.config;

import org.bukkit.configuration.ConfigurationSection;

public record ConfigValues(
        boolean enabled,
        boolean metrics,
        boolean papiSupport,
        String permToReload,
        boolean commandReplace,
        String messNoPerms,
        String messReloaded,
        ConfigurationSection emojis
) {}
