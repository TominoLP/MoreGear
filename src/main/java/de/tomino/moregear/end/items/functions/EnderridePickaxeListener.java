package de.tomino.moregear.end.items.functions;

import de.tomino.moregear.MoreGear;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EnderridePickaxeListener implements Listener {

    private final MoreGear main;

    public EnderridePickaxeListener(MoreGear main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Block TargetBlock = event.getBlock();
        ItemStack drop = null;
        Player player = event.getPlayer();
        double dropCount = 0L;

        if (player.getInventory().getItemInMainHand().getItemMeta() != null
                && player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()
                && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 10010) {
            if (player.isSneaking()) {
                if (main.charges.get(player) < 50) {
                    player.sendMessage("§cDu hast nicht genug Charges!");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                    return;
                }
                main.charges.put(player, main.charges.get(player) - 50);
                if (TargetBlock.getType().toString().contains("ORE")) {
                    for (int x = -1; x < 4; x++) {
                        for (int y = -1; y < 4; y++) {
                            for (int z = -1; z < 4; z++) {
                                Block block = TargetBlock.getWorld().getBlockAt(TargetBlock.getX() + x, TargetBlock.getY() + y, TargetBlock.getZ() + z);
                                if (block.getType().toString().contains("ORE")) {
                                    dropCount = dropCount + block.getDrops().size();
                                    drop = (ItemStack) block.getDrops().toArray()[0];
                                    block.getDrops().clear();
                                    block.breakNaturally();
                                    block.getDrops().clear();
                                }
                            }
                        }
                    }
                }

                if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
                    if (player.getInventory().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                        dropCount = dropCount * 1.33;
                        player.sendMessage(dropCount + ": " + drop);
                        assert drop != null;
                        drop.setAmount((int) dropCount);
                        player.getInventory().addItem(drop);
                        return;
                    }
                    if (player.getInventory().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                        dropCount = dropCount * 1.55;
                        player.sendMessage(dropCount + ": " + drop);
                        assert drop != null;
                        drop.setAmount((int) dropCount);
                        player.getInventory().addItem(drop);
                        return;
                    }
                    if (player.getInventory().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                        dropCount = dropCount * 1.75;
                        player.sendMessage(dropCount + ": " + drop);
                        assert drop != null;
                        drop.setAmount((int) dropCount);
                        player.getInventory().addItem(drop);
                        return;
                    }
                }
                if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
                    if (player.getInventory().getItemInMainHand().getEnchantments().get(Enchantment.SILK_TOUCH) == 1) {
                        player.getInventory().addItem(TargetBlock.getDrops().toArray(new ItemStack[0]));
                        return;
                    }
                }
                assert drop != null;
                drop.setAmount((int) dropCount);
                player.getInventory().addItem(drop);

            }


        }
    }
}
