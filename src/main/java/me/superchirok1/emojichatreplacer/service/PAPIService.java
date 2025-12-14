package me.superchirok1.emojichatreplacer.service;

import me.clip.placeholderapi.PlaceholderAPI;
import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PAPIService {

    private final EmojiChatReplacer plugin;

    public boolean enabled = false;

    public PAPIService(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    public void init() {
        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI") && plugin.config.values.papiSupport()) {
            enabled = true;
        } else {
            enabled = false;
        }
    }

    public String parse(Player player, String text) {
        if (!enabled) return text;
        return PlaceholderAPI.setPlaceholders(player, text);
    }

}
