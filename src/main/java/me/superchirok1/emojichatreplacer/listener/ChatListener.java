package me.superchirok1.emojichatreplacer.listener;

import me.superchirok1.emojichatreplacer.EmojiChatReplacer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final EmojiChatReplacer plugin;

    public ChatListener(EmojiChatReplacer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(plugin.service.replace(event.getPlayer(), event.getMessage()));
    }

}
