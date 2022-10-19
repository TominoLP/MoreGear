package de.tomino.moregear.end.items.functions;

import de.tomino.moregear.MoreGear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ToolListener implements Listener {

    private final MoreGear main;

    public ToolListener(MoreGear main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        main.getPlayersWithTool().remove(event.getPlayer());
        if (event.getPlayer().getInventory().getItem(event.getNewSlot()) == null) return;
        ItemStack newItem = event.getPlayer().getInventory().getItem(event.getNewSlot());
        assert newItem != null;
        if (newItem.hasItemMeta() && Objects.requireNonNull(newItem.getItemMeta()).hasCustomModelData()) {
            if (newItem.getItemMeta().getCustomModelData() == 10010
                    || newItem.getItemMeta().getCustomModelData() == 10011
                    || newItem.getItemMeta().getCustomModelData() == 10012
                    || newItem.getItemMeta().getCustomModelData() == 10013
                    || newItem.getItemMeta().getCustomModelData() == 10015
                    || newItem.getItemMeta().getCustomModelData() == 10016
                    || newItem.getItemMeta().getCustomModelData() == 10017) {
                if (!main.charges.containsKey(event.getPlayer())) main.charges.put(event.getPlayer(), 100L);
                main.getPlayersWithTool().add(event.getPlayer());
            }
        } else main.getPlayersWithTool().remove(event.getPlayer());
    }
}

