package io.github.alexeymartynov.private_evolution.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UtilIcons {

    public static ItemStack createHead(String name, String id, String texture)
    {
        ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM);
        Bukkit.getUnsafe().modifyItemStack(head, "display:{Name:{text:" + name + "}}" +
                "{SkullOwner:{Id:" + id + "," +
                "Properties:{textures:[{Value:" + texture + "}]}}})");

        return head;
    }
}
