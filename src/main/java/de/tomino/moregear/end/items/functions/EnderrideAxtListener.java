package de.tomino.moregear.end.items.functions;

import de.tomino.moregear.Moregear;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class EnderrideAxtListener implements Listener {

    private final Moregear main;

    public EnderrideAxtListener(Moregear main) {
        this.main = main;
    }
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        main.getPlayersWithTool().remove(event.getPlayer());
        ItemStack newItem = event.getPlayer().getInventory().getItem(event.getNewSlot());
        if (newItem != null && newItem.getItemMeta() != null && newItem.getItemMeta().hasCustomModelData()
                && newItem.getItemMeta().getCustomModelData() == 1001) {
            if (!main.charges.containsKey(event.getPlayer())) main.charges.put(event.getPlayer(), 100L);
            main.getPlayersWithTool().add(event.getPlayer());
        } else main.getPlayersWithTool().remove(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Block TargetBlock = event.getBlock();
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getItemMeta() != null
                && player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()
                && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 10011) {
            if (player.isSneaking()) {
                if (main.charges.get(player) < 20) {
                    player.sendMessage("§cDu hast nicht genug Charges!");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                    return;
                }
                main.charges.put(player, main.charges.get(player) - 20);
                if (TargetBlock.getType().toString().contains("LOG")) {
                    for (int x = -1; x < 4; x++) {
                        for (int y = -1; y < 12; y++) {
                            for (int z = -1; z < 4; z++) {
                                Block block = TargetBlock.getWorld().getBlockAt(TargetBlock.getX() + x, TargetBlock.getY() + y, TargetBlock.getZ() + z);
                                if (block.getType().toString().contains("LOG")) {
                                    block.breakNaturally();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}