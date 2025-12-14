package me.superchirok1.emojichatreplacer.color;


import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextColorizer {

    private static final Pattern PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    public String format(String message) {
        if (message == null) return "";

        Matcher matcher = PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String hex = matcher.group(1);
            matcher.appendReplacement(buffer, ChatColor.of("#" + hex).toString());
        }
        matcher.appendTail(buffer);
        message = buffer.toString();

        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
