package io.github.alexeymartynov.private_evolution.privates;

import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PrivateManager {

    private static List<Private> privates = new ArrayList<>();

    public static void load()
    {
        privates.clear();
        FileConfiguration config = PrivateEvolution.getInstance().getPrivatesConfig();
        Set<String> privates = config.getKeys(false);
        if(privates == null || privates.isEmpty())
            return;

        for(String privateName : privates)
            PrivateManager.privates.add(new Private(privateName));
    }

    public static PrivateUpgradeStage getNextPrivateUpgradeStage(PrivateUpgradeStage stage)
    {
        int index = Arrays.asList(PrivateUpgradeStage.values()).indexOf(stage) + 1;
        if(PrivateUpgradeStage.values().length >= index)
            return stage;

        return PrivateUpgradeStage.values()[index];
    }

    public static ApplicableRegionSet getRegions(Location location)
    {
        WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(location.getWorld())).
                getApplicableRegions(BlockVector3.at(location.getX(),location.getY(),location.getZ()));
    }

    public boolean suitsToConditions(Private region)
    {
        PrivateUpgradeCondition condition = getNextPrivateUpgradeStage(region.getPrivateUpgradeStage()).getCondition();
        if(region.getMembers().size() < condition.getMemberCount())
            return false;

        List<Material> needBlocks = new ArrayList<>();
        for(ItemStack block : condition.getBlocks())
            for(int amount = 0; amount < block.getAmount(); amount++)
                needBlocks.add(block.getType());

        BlockVector3 minimumPoint = region.getRegion().getMinimumPoint();
        BlockVector3 maximumPoint = region.getRegion().getMaximumPoint();
        for(int x = minimumPoint.getBlockX() < maximumPoint.getBlockX() ? minimumPoint.getBlockX() : maximumPoint.getBlockX();
            minimumPoint.getBlockX() < maximumPoint.getBlockX() ? x < maximumPoint.getBlockX() : x < minimumPoint.getBlockX(); x++)
        {
            for(int y = minimumPoint.getBlockY() < maximumPoint.getBlockY() ? minimumPoint.getBlockY() : maximumPoint.getBlockY();
                minimumPoint.getBlockY() < maximumPoint.getBlockY() ? y < maximumPoint.getBlockY() : y < minimumPoint.getBlockY(); y++)
            {
                for(int z = minimumPoint.getBlockZ() < maximumPoint.getBlockZ() ? minimumPoint.getBlockZ() : maximumPoint.getBlockZ();
                    minimumPoint.getBlockZ() < maximumPoint.getBlockZ() ? z < maximumPoint.getBlockZ() : z < minimumPoint.getBlockZ(); z++)
                {
                    Material block = Bukkit.getWorld(PrivateEvolution.WORLD_NAME).getBlockAt(x, y, z).getType();
                    if(needBlocks.contains(block))
                        needBlocks.remove(block);

                    if(needBlocks.isEmpty())
                        return true;
                }
            }
        }

        if(needBlocks.isEmpty())
            return true;

        return false;
    }

    public List<ProtectedRegion> getSubRegions(ProtectedRegion region)
    {
        return region.getParent().getIntersectingRegions();
    }

    public static boolean hasRegion(String nick) { return true; } // change

   /* public static WorldGuardPlugin getWorldGuard()
    {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

        if (plugin == null || !(plugin instanceof WorldGuardPlugin))
            return null;

        return (WorldGuardPlugin) plugin;
    }

    public static WorldEditPlugin getWorldEdit()
    {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        if (plugin == null || !(plugin instanceof WorldEditPlugin))
            return null;

        return (WorldEditPlugin) plugin;
    } */
}
