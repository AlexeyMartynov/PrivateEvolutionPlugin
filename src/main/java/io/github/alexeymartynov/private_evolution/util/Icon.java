package io.github.alexeymartynov.private_evolution.util;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import io.github.alexeymartynov.private_evolution.privates.PrivateType;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Icon {

    PRIVATE_FRACTION("[I;-1867200844,2101231723,-1094640399,1085330343]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGU5M2Y2MzQzMTBmNDJkYjQxMWJkYTY4NDM5ZTYxM2RhOTRiNjA1MmU4NjY3NDg5OWZmNzJiZmNmYzE1NjNkYSJ9fX0="),
    PRIVATE_EVOLUTION("[I;1615880869,-1670363448,-1311150734,1884463372]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U3ZWNlZmUxNGQ4YTA2N2Y5NDBmNGJjNGU2MzRkNDNiNWFkMmM4NjdlYTY1NTkwMGNjOGFmMjQ1YjU4NDE3YyJ9fX0="),

    INFORMATION("[I;-1006334956,-1690876295,-1670897952,621419671]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzMyNzAwOWNkNDcxODg0MTE1MjAzODYwYzFkYWY2ZDgyNWMwODQ1ZjhhNTI4YzZlZjZiZDI0ZWI4NmI0YjM4YiJ9fX0="),
    UPGRADE("[I;921500126,-1662759197,-1515206466,-1205101373]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA0MGZlODM2YTZjMmZiZDJjN2E5YzhlYzZiZTUxNzRmZGRmMWFjMjBmNTVlMzY2MTU2ZmE1ZjcxMmUxMCJ9fX0=");

    private ItemStack item;

    private Icon(String id, String texture) { this.item = UtilIcon.createHead("", id, texture); }

    public ItemStack get() { return item; }

    public void setName(String name)
    {
        ItemStack item = get();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        this.item = item;
    }
}
