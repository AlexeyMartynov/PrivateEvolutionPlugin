package io.github.alexeymartynov.private_evolution.gui;

import io.github.alexeymartynov.private_evolution.util.Gui;
import io.github.alexeymartynov.private_evolution.util.Icon;
import io.github.alexeymartynov.private_evolution.util.Name;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiPrivateMenu extends Gui {

    public GuiPrivateMenu() { super(Name.TITLE_GUI_PRIVATE_MENU.getName(), 27); }

    @Override
    public void onGuiClick(InventoryClickEvent event)
    {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if(item == null || item.getType() == Material.AIR)
            return;


    }

    @Override
    public boolean create(Player player)
    {
        inventory.setItem(12, Icon.UPGRADE.getItem());
        inventory.setItem(14, Icon.INFORMATION.getItem());
        return true;
    }
}
