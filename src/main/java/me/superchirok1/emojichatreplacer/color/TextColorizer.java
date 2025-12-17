package me.superchirok1.emojichatreplacer.color;


import me.superchirok1.emojichatreplacer.color.impl.LegacyColorizer;
import me.superchirok1.emojichatreplacer.color.impl.MiniMessageColorizer;
import org.bukkit.configuration.ConfigurationSection;

public class TextColorizer {

    public Colorizer get;

    public void init(ConfigurationSection section) {
        get = section.getString("colorizer", "legacy")
                .equalsIgnoreCase("legacy")
                ? new LegacyColorizer() : new MiniMessageColorizer();
    }

}
