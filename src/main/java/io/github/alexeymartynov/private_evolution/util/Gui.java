package io.github.alexeymartynov.private_evolution.util;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Gui extends GuiHolder {
	
	private static Map<Player, List<Inventory>> queue = new HashMap<>();
	
	public static void onEnable() 
	{
		new BukkitRunnable() 
        {
        	public void run() 
        	{
        		if(queue.isEmpty())
        			return;
        		
        		for(Player player : queue.keySet()) 
        		{
        			if(player == null)
        			{
        				queue.remove(player);
        				return;
        			}
        			
	        		if(player.getOpenInventory().getTopInventory().getHolder() instanceof GuiHolder) continue;

	        		List<Inventory> list = queue.get(player);
	            	player.openInventory(list.get(0));
	            	list.remove(0);
	            	if(list.isEmpty())
	            		queue.remove(player);
	            	else queue.put(player, list);
        		}

        	}
        }.runTaskTimer(PrivateEvolution.getInstance(), 30, 30);
	}
	
	private static void addToQueue(Player player, Inventory inventory) 
	{
		List<Inventory> list = !queue.containsKey(player) ? new ArrayList<>() : queue.get(player);
		list.add(inventory);
		queue.put(player, list);
	}
	
	public Gui(String title, int size) { super(title, size); }
	
	public abstract void onGuiClick(InventoryClickEvent event);
	
	public abstract boolean create(Player player);
	
	public void open(Player player) 
	{  
		if(!create(player))
			return;

        addToQueue(player, inventory);
	} 
}
