package me.superchirok1.emojichatreplacer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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

        sendMsg(sender, reloaded);
        plugin.reloadConfig();
        plugin.config.setup(plugin.getConfig().getConfigurationSection("settings"));
        plugin.service.init(plugin.config.values.emojis());
        return true;
    }

    private void sendMsg(CommandSender sender, String text) {
        if (text.equalsIgnoreCase("nil")||text.equalsIgnoreCase("null")) return;
        sender.sendMessage(text);
    }

}
