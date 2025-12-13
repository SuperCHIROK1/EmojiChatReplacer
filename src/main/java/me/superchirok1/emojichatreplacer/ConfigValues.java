package me.superchirok1.emojichatreplacer;

import org.bukkit.configuration.ConfigurationSection;

public record ConfigValues(
        String permToReload,
        String messNoPerms,
        String messReloaded,
        ConfigurationSection emojis
) {}
