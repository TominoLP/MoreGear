package de.tomino.moregear.end.items.functions;

import de.tomino.moregear.Moregear;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnderrideHoeListener implements Listener {


    private final Moregear main;


    public EnderrideHoeListener(Moregear main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        ItemStack newItem = event.getPlayer().getInventory().getItem(event.getNewSlot());
        if (newItem != null && newItem.getItemMeta() != null && newItem.getItemMeta().hasCustomModelData()
                && newItem.getItemMeta().getCustomModelData() == 10013) {
            if (!main.charges.containsKey(event.getPlayer())) main.charges.put(event.getPlayer(), 100L);
            main.getPlayerWithSword().add(event.getPlayer());
        } else main.getPlayerWithSword().remove(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if (event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta().hasCustomModelData() && event.getItem().getItemMeta().getCustomModelData() == 10013) {
            if (main.charges.get(event.getPlayer()) < 5) {
                event.getPlayer().sendMessage("§cDu hast nicht genug Charges!");
                return;
            }


            if (Objects.requireNonNull(event.getClickedBlock()).getType().equals(Material.GRASS_BLOCK)
                    || event.getClickedBlock().getType().equals(Material.DIRT)
                    || event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                Block block = event.getClickedBlock();
                Location location = block.getLocation();
                List<Block> blocks = new ArrayList<>();
                Player player = event.getPlayer();
                main.charges.put(player, main.charges.get(player) - 5);

                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        Block block1 = location.getWorld().getBlockAt(location.getBlockX() + x, location.getBlockY(), location.getBlockZ() + z);
                        if (block1.getType().equals(Material.GRASS_BLOCK) || block1.getType().equals(Material.DIRT)
                                || block1.getType().equals(Material.FARMLAND) & !block1.getRelative(0, 1, 0).getType().equals(Material.AIR)) {
                            blocks.add(block1);
                        }
                    }
                }

                for (Block b : blocks) {
                    if (b.getRelative(0, 1, 0).getType().equals(Material.AIR)
                            || b.getRelative(0, 1, 0).getType().equals(Material.GRASS)
                            || b.getRelative(0, 1, 0).getType().equals(Material.TALL_GRASS)
                            || b.getRelative(0, 1, 0).getType().equals(Material.FERN)
                            || b.getRelative(0, 1, 0).getType().equals(Material.LARGE_FERN)) {
                        b.setType(Material.FARMLAND);
                    }

                    if (b.getRelative(0, 1, 0).getType().equals(Material.GRASS)
                            || b.getRelative(0, 1, 0).getType().equals(Material.TALL_GRASS)
                            || b.getRelative(0, 1, 0).getType().equals(Material.FERN)
                            || b.getRelative(0, 1, 0).getType().equals(Material.LARGE_FERN)) {
                        b.getRelative(0, 1, 0).setType(Material.AIR);
                        b.getDrops().forEach(itemStack -> b.getWorld().dropItemNaturally(b.getLocation(), itemStack));
                    }

                }

            }

        }

    }

}
