package io.github.alexeymartynov.private_evolution.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public enum Icon {

    INFORMATION(ChatColor.GREEN + "Улучшить", "[I;921500126,-1662759197,-1515206466,-1205101373]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA0MGZlODM2YTZjMmZiZDJjN2E5YzhlYzZiZTUxNzRmZGRmMWFjMjBmNTVlMzY2MTU2ZmE1ZjcxMmUxMCJ9fX0="),
    UPGRADE(ChatColor.GREEN + "Улучшить", "[I;921500126,-1662759197,-1515206466,-1205101373]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA0MGZlODM2YTZjMmZiZDJjN2E5YzhlYzZiZTUxNzRmZGRmMWFjMjBmNTVlMzY2MTU2ZmE1ZjcxMmUxMCJ9fX0=");

    private ItemStack item;

    private Icon(String name, String id, String texture) { this.item = UtilIcons.createHead(name, id, texture); }

    public ItemStack getItem() { return item; }
}
