package io.github.alexeymartynov.private_evolution.gui;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import io.github.alexeymartynov.private_evolution.util.Gui;
import io.github.alexeymartynov.private_evolution.util.Icon;
import io.github.alexeymartynov.private_evolution.util.Name;
import io.github.alexeymartynov.private_evolution.util.UtilItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiPickPrivateType extends Gui {

    public GuiPickPrivateType() { super(Name.TITLE_GUI_PICK_PRIVATE_TYPE.get(), 27); }

    @Override
    public void onGuiClick(InventoryClickEvent event)
    {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if(item == null || item.getType() == Material.AIR)
            return;

        if(UtilItem.areTheSameItems(item, Icon.PRIVATE_EVOLUTION.get()))
        {
            return;
        }

        // if fraction private
    }

    @Override
    public boolean create(Player player)
    {
        if(!PrivateEvolution.getInstance().getPrivateManager().hasRegion(player.getName()))
        {
            inventory.setItem(12, Icon.PRIVATE_EVOLUTION.get());
            inventory.setItem(14, Icon.PRIVATE_FRACTION.get());
            return true;
        }

        return false;
    }
}
