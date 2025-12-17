package me.superchirok1.emojichatreplacer.config;

import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import org.bukkit.configuration.ConfigurationSection;

public class Config {

    public ConfigValues values;
    private final EmojiChatReplacer plugin;

    public Config(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    private String colorize(String text) {
        return plugin.colorizer.get.colorize(text);
    }

    public void setup(ConfigurationSection config) {
        values = new ConfigValues(
                config.getBoolean("enabled", true),
                config.getBoolean("metrics", true),
                config.getString("colorizer", "legacy"),
                config.getBoolean("papi_support", true),
                config.getString("permission_for_reload", "ecr.reload"),
                config.getBoolean("command_replace", false),
                colorize(config.getString("messages.no_perms", "nil")),
                colorize(config.getString("messages.reloaded", "nil")),
                config.getConfigurationSection("emojis")
        );
    }

}
