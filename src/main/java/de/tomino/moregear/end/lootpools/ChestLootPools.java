package de.tomino.moregear.end.lootpools;

import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ChestLootPools implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock().getType().name().contains("CHEST")) {
            Chest chest = (Chest) event.getClickedBlock().getState();
            Inventory inventory = chest.getInventory();
            if (chest.getLootTable() == null) return;
            if (chest.getLootTable().getKey().getKey().equals("chests/end_city_treasure")) {

            }
        }
    }
}
