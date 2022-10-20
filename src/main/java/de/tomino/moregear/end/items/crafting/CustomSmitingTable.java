package de.tomino.moregear.end.items.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CustomSmitingTable implements Listener {



    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getInventory() instanceof SmithingInventory) {
            Player player = (Player) event.getPlayer();
            event.setCancelled(true);
            Inventory inventory = Bukkit.createInventory(null, 3 * 9, ("§6Custom Smiting Table"));
            ItemStack not = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta notMeta = not.getItemMeta();
            notMeta.setDisplayName(" ");
            not.setItemMeta(notMeta);
            ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta yesMeta = yes.getItemMeta();
            yesMeta.setDisplayName(" ");
            yes.setItemMeta(yesMeta);
            ItemStack bg = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta bgMeta = bg.getItemMeta();
            bgMeta.setDisplayName(" ");
            bg.setItemMeta(bgMeta);

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowRight"));
            skullMeta.setDisplayName(" ");
            skull.setItemMeta(skullMeta);

            ItemStack arrow = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta arrowMeta = arrow.getItemMeta();
            arrowMeta.setDisplayName(" ");
            arrow.setItemMeta(arrowMeta);

            inventory.setItem(0, not);
            inventory.setItem(1, not);
            inventory.setItem(2, not);
            inventory.setItem(3, not);
            inventory.setItem(4, not);
            inventory.setItem(5, not);
            inventory.setItem(6, not);
            inventory.setItem(7, not);
            inventory.setItem(8, not);
            inventory.setItem(9, bg);

            inventory.setItem(11, bg);

            inventory.setItem(13, bg);
            inventory.setItem(14, skull);
            inventory.setItem(15, bg);

            inventory.setItem(17, bg);
            inventory.setItem(18, not);
            inventory.setItem(19, not);
            inventory.setItem(20, not);
            inventory.setItem(21, not);
            inventory.setItem(22, not);
            inventory.setItem(23, not);
            inventory.setItem(24, not);
            inventory.setItem(25, not);
            inventory.setItem(26, not);

            player.openInventory(inventory);

        }
    }
    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§6Custom Smiting Table")) {
            if (!(event.getSlot() == 10 || event.getSlot() == 12 || event.getSlot() == 16)) event.setCancelled(true);
            /*
            get item in Slot 10 ,12 , 16
            if item is null return
             */
            if (event.getSlot() == 10) {
                ItemStack item = event.getInventory().getItem(10);
                if (item == null) return;
                if (item.getType() == Material.AIR) return;
            }
        }










    }
}
