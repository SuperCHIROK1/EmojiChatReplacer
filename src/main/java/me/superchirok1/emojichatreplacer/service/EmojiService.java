package me.superchirok1.emojichatreplacer.service;

import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import me.superchirok1.emojichatreplacer.config.Config;
import me.superchirok1.emojichatreplacer.model.Emoji;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class EmojiService {

    public Map<String, Emoji> emojis = new HashMap<>();

    private final EmojiChatReplacer plugin;

    public EmojiService(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    private String colorize(String text) {
        return plugin.colorizer.get.colorize(text);
    }

    public String replace(Player player, String string) {
        for (Map.Entry<String, Emoji> pair: emojis.entrySet()) {
            if (string.contains(pair.getKey())) {
                Emoji emoji = pair.getValue();
                if (emoji.getPerm() == null || emoji.getPerm().isEmpty() || player.hasPermission(emoji.getPerm())) {
                    string = string.replace(pair.getKey(), emoji.getValue());
                }
            }
        }

        return plugin.papiService.parse(player, string);
    }

    public void init(ConfigurationSection section) {
        emojis.clear();

        if (!plugin.config.values.enabled()) return;
        for (String key : section.getKeys(false)) {
            ConfigurationSection sect = section.getConfigurationSection(key);
            String value = sect != null
                    ? sect.getString("value")
                    : section.getString(key);

            if (value==null || value.isEmpty()) continue;
            value = colorize(value);

            String perm = sect != null
                    ? sect.getString("perm")
                    : null;
            emojis.put(key, new Emoji(value, perm));
        }
    }

}
