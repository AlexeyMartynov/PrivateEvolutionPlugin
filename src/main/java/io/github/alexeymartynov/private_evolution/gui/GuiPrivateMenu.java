package io.github.alexeymartynov.private_evolution.gui;

import io.github.alexeymartynov.private_evolution.util.Gui;
import io.github.alexeymartynov.private_evolution.util.Icon;
import io.github.alexeymartynov.private_evolution.util.Name;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiPrivateMenu extends Gui {

    public GuiPrivateMenu() { super(Name.TITLE_GUI_PRIVATE_MENU.get(), 27); }

    @Override
    public void onGuiClick(InventoryClickEvent event) { event.setCancelled(true); }

    @Override
    public boolean create(Player player)
    {
        ItemStack item = Icon.INFORMATION.get();
        inventory.setItem(12, item);

        item = Icon.UPGRADE.get();
        inventory.setItem(14, upgrade);
        return true;
    }
}
