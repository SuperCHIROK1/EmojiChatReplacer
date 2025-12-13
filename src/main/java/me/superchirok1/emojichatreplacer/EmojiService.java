package me.superchirok1.emojichatreplacer;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class EmojiService {

    public Map<String, String> emojis = new HashMap<>();

    public String replace(String string) {
        for (Map.Entry<String, String> pair: emojis.entrySet()) {
            string = string.replace(pair.getKey(), pair.getValue());
        }
        return string;
    }

    public void init(ConfigurationSection section) {
        if (!emojis.isEmpty()&&emojis!=null)
            emojis.clear();
        for (String key : section.getKeys(false)) {
            String value = section.getString(key);
            if (value!=null && !value.isEmpty()) {
                emojis.put(key, value);
            }
        }
    }

}
