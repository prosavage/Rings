package me.oribuin.rings;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Test implements Listener {
    private static Test INSTANCE;

    public static Test getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Test();
        }
        return INSTANCE;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Material material = event.getBlockPlaced().getBlockData().getMaterial();

        if (material.equals(Material.BAMBOO)
                || material.equals(Material.BAMBOO_SAPLING)) {

            event.getPlayer().kickPlayer("No placing bamboo!");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        event.getClickedInventory().remove(Material.BAMBOO);
    }
}