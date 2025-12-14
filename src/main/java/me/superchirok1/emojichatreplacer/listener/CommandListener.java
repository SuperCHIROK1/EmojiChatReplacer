package me.superchirok1.emojichatreplacer.listener;

import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class CommandListener implements Listener {

    private final EmojiChatReplacer plugin;

    public CommandListener(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (!plugin.config.values.commandReplace()) return;
        event.setMessage(plugin.service.replace(event.getPlayer(), event.getMessage()));
    }

}
