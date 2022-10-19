package de.tomino.moregear.end.items.functions;

import de.tomino.moregear.Moregear;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public class EnderrideSwordListener implements Listener {


    private final Moregear main;

    public EnderrideSwordListener(Moregear main) {
        this.main = main;
    }


    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            Location entityloc = event.getEntity().getLocation();
            player.getInventory().getItemInMainHand();

            if (player.getInventory().getItemInMainHand().getItemMeta() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 10015) {
                if (player.getWorld().getEnvironment() == org.bukkit.World.Environment.THE_END
                        && main.getFillSetPlayers().contains(player)) {
                    event.setDamage(event.getDamage() * 2);
                    player.getWorld().spawnParticle(Particle.CRIT, entityloc, 10);
                    swordEffect(event, player, entityloc);
                    return;
                }
                swordEffect(event, player, entityloc);

            }
        }
    }

    protected void swordEffect(EntityDamageByEntityEvent event, Player player, Location entityloc) {
        player.sendMessage(event.getFinalDamage() + "");
        entityloc.getWorld().spawnParticle(Particle.SUSPENDED_DEPTH, entityloc, 2, 0.5, 0.5, 0.5, 0.0);
        entityloc.getWorld().spawnParticle(Particle.SOUL, entityloc, 20, 0.5, 0.5, 0.5, 0.0);
        entityloc.getWorld().playSound(entityloc, Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1, 5);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        ItemStack newItem = event.getPlayer().getInventory().getItem(event.getNewSlot());
        if (newItem != null && newItem.getItemMeta() != null && newItem.getItemMeta().hasCustomModelData()
                && newItem.getItemMeta().getCustomModelData() == 10015) {
            main.getPlayerWithSword().add(event.getPlayer());
        } else main.getPlayerWithSword().remove(event.getPlayer());
    }


    @EventHandler()
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (!main.charges.containsKey(event.getPlayer())) main.charges.put(event.getPlayer(), 100L);
            warpPlayerToBlock(event.getPlayer());

        }
    }

    private void warpPlayerToBlock(@NotNull Player player) {
        if (player.isSneaking()) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 10015) {
                if (main.charges.get(player) < 100) {
                    player.sendMessage("§cDu hast nicht genug Charges!");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                    return;
                }
                Block block = player.getTargetBlock(null, 100);
                if (block.getType().equals(Material.AIR)) return;
                if (!block.getRelative(0, 1, 0).getType().equals(Material.AIR)) return;
                teleportPlayer(player, block);
                player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 10);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 5);
                main.charges.put(player, main.charges.get(player) - 100);

            }
            return;
        }
        warpPlayerToTarget(player);
    }

    private void warpPlayerToTarget(@NotNull Player player) {
        if (player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()
                && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 10015) {
            if (main.charges.get(player) < 10) {
                player.sendMessage("§cDu hast nicht genug Charges um dich zu teleportieren!");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                return;
            }
            Block block = player.getTargetBlock(null, 8);
            if (!block.getRelative(0, 1, 0).getType().equals(Material.AIR)) return;
            teleportPlayer(player, block);
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 5);
            main.charges.put(player, main.charges.get(player) - 10);
        }
    }

    private void teleportPlayer(@NotNull Player player, Block block) {
        Location location = block.getLocation();
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();
        location.add(0, 1.5, 0);
        location.setYaw(yaw);
        location.setPitch(pitch);
        player.teleport(location);
    }

}
