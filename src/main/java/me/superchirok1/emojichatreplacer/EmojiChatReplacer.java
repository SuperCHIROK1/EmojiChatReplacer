package me.superchirok1.emojichatreplacer;

import org.bukkit.plugin.java.JavaPlugin;

public final class EmojiChatReplacer extends JavaPlugin {

    public EmojiService service;
    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        service = new EmojiService();
        config = new Config();

        config.setup(getConfig().getConfigurationSection("settings"));
        service.init(config.values.emojis());

        getCommand("ecr").setExecutor(new ECRCommand(this));
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
