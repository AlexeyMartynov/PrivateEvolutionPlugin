package io.github.alexeymartynov.private_evolution.util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiHandler implements Listener {
	
	@EventHandler
	public void onGuiClick(InventoryClickEvent event) 
	{ 
		if(event.getInventory().getHolder() instanceof GuiHolder) 
		{
			GuiHolder holder = (GuiHolder) event.getInventory().getHolder();
			holder.onGuiClick(event); 
		}
	}
}
