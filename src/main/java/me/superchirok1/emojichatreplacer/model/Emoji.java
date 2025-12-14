package me.superchirok1.emojichatreplacer.model;

public class Emoji {

    private final String value;
    private final String perm;

    public String getValue() {
        return value;
    }

    public Emoji(String value, String perm) {
        this.value = value;
        this.perm = perm;
    }

    public String getPerm() {
        return perm;
    }
}
