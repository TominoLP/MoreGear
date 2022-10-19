package de.tomino.moregear.end.items.functions;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import de.tomino.moregear.MoreGear;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class EnderrideArmorListener implements Listener {

    private final MoreGear main;

    public EnderrideArmorListener(MoreGear main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();

        if ((event.getNewItem() != null && event.getNewItem().getItemMeta() != null &&
                event.getNewItem().getItemMeta().getDisplayName().contains("Enderride")) ||
                (event.getOldItem() != null && event.getOldItem().getItemMeta() != null &&
                        event.getOldItem().getItemMeta().getDisplayName().contains("Enderride"))) {

            if (this.hasFullSet(player)) {
                player.setAllowFlight(true);
                main.getFillSetPlayers().add(player);
                return;
            }
            player.setAllowFlight(false);
            player.setFlying(false);
            main.getFillSetPlayers().remove(player);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (this.hasFullSet(player)) {
            player.setAllowFlight(true);
            main.getFillSetPlayers().add(player);
            return;
        }
        player.setAllowFlight(false);
        player.setFlying(false);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        main.getFillSetPlayers().remove(event.getPlayer());
        main.getPlayersWithTool().remove(event.getPlayer());
    }

    private boolean hasFullSet(@NotNull Player player) {
        return Arrays.stream(player.getInventory().getArmorContents())
                .filter(itemStack -> itemStack != null && itemStack.getItemMeta() != null)
                .filter(itemStack -> itemStack.getItemMeta().getDisplayName().contains("Enderride"))
                .filter(itemStack -> List.of(10001, 10002, 10003, 10004, 10005, 10006).contains(itemStack.getItemMeta().getCustomModelData()))
                .count() == 4;
    }
}
