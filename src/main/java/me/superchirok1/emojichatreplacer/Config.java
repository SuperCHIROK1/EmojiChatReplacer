package me.superchirok1.emojichatreplacer;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

public class Config {

    public ConfigValues values;

    private String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public void setup(ConfigurationSection config) {
        values = new ConfigValues(
                config.getString("permission-for-reload", "ecr.reload"),
                colorize(config.getString("messages.no-perms", "nil")),
                colorize(config.getString("messages.reloaded", "nil")),
                config.getConfigurationSection("emojis")
        );
    }

}
