package me.superchirok1.emojichatreplacer;

import me.superchirok1.emojichatreplacer.color.TextColorizer;
import me.superchirok1.emojichatreplacer.command.ECRCommand;
import me.superchirok1.emojichatreplacer.config.Config;
import me.superchirok1.emojichatreplacer.listener.ChatListener;
import me.superchirok1.emojichatreplacer.listener.CommandListener;
import me.superchirok1.emojichatreplacer.service.EmojiService;
import me.superchirok1.emojichatreplacer.service.PAPIService;
import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public final class EmojiChatReplacer extends JavaPlugin {

    public EmojiService service;
    public Config config;
    public PAPIService papiService;
    public TextColorizer colorizer;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        ConfigurationSection settings = getConfig().getConfigurationSection("settings");

        Metrics metrics = new Metrics(this, 28355);

        service = new EmojiService(this);
        config = new Config(this);
        colorizer = new TextColorizer();
        papiService = new PAPIService(this);

        config.setup(settings);
        service.init(config.values.emojis());
        papiService.init();

        getCommand("ecr").setExecutor(new ECRCommand(this));
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);

    }

    @Override
    public void onDisable() {
        service.emojis.clear();
    }

}
