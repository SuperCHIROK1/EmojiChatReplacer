package me.superchirok1.emojichatreplacer.command;

import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

public class ECRCommand implements CommandExecutor {

    private final EmojiChatReplacer plugin;

    public ECRCommand(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String noPerms = plugin.config.values.messNoPerms();
        String reloaded = plugin.config.values.messReloaded();

        if (!sender.hasPermission(plugin.config.values.permToReload())) {
            sendMsg(sender, noPerms);
            return true;
        }

        plugin.reloadConfig();
        ConfigurationSection section = plugin.getConfig().getConfigurationSection("settings");
        plugin.colorizer.init(section);
        plugin.config.setup(section);
        plugin.service.init(plugin.config.values.emojis());
        plugin.papiService.init();
        sendMsg(sender, reloaded);
        return true;
    }

    private void sendMsg(CommandSender sender, String text) {
        if (text.equalsIgnoreCase("nil")||text.equalsIgnoreCase("null")) return;
        sender.sendMessage(text);
    }

}
