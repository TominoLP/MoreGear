package de.tomino.moregear.end.items.crafting;

import de.tomino.moregear.utils.ItemBuilder;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CustomSmitingTable implements Listener {

    Boolean crafteble = false;
    ItemStack first;
    ItemStack second;
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getInventory() instanceof SmithingInventory) {
            Player player = (Player) event.getPlayer();
            event.setCancelled(true);

            Inventory inventory = Bukkit.createInventory(null, 3 * 9, ("§6Custom Smiting Table"));
            ItemStack not = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta notMeta = not.getItemMeta();
            assert notMeta != null;
            notMeta.setDisplayName(" ");
            not.setItemMeta(notMeta);

            ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta yesMeta = yes.getItemMeta();
            assert yesMeta != null;
            yesMeta.setDisplayName(" ");
            yes.setItemMeta(yesMeta);

            ItemStack bg = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta bgMeta = bg.getItemMeta();
            assert bgMeta != null;
            bgMeta.setDisplayName(" ");
            bg.setItemMeta(bgMeta);

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            assert skullMeta != null;
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowRight"));
            skullMeta.setDisplayName(" ");
            skull.setItemMeta(skullMeta);

            ItemStack arrow = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta arrowMeta = arrow.getItemMeta();
            assert arrowMeta != null;
            arrowMeta.setDisplayName(" ");
            arrow.setItemMeta(arrowMeta);

            ItemBuilder.fillInv(inventory ,not, 1);
            ItemBuilder.fillInv(inventory ,not, 3);

            inventory.setItem(9, bg);
            inventory.setItem(11, bg);
            inventory.setItem(13, bg);
            inventory.setItem(14, skull);
            inventory.setItem(15, bg);
            inventory.setItem(17, bg);

            player.openInventory(inventory);
        }
    }
    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§6Custom Smiting Table")) {
            ItemStack clickedItem = event.getCurrentItem();

            if (event.getSlot() == 10 || event.getSlot() == 12) {
                if (event.getInventory().getItem(10) == null || event.getInventory().getItem(12) == null) return;
                if (event.getInventory().getItem(10).getType().equals(Material.AIR)
                        || event.getInventory().getItem(12).getType().equals(Material.AIR)) return;
                first = event.getInventory().getItem(10);
                second = event.getInventory().getItem(12);
                isCraftable(first, second, (Player) event.getWhoClicked());
            }
            if (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE) || event.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE) || event.getCurrentItem().getType().equals(Material.GREEN_STAINED_GLASS_PANE) || event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
                event.setCancelled(true);
            }

        }
    }

    public void isCraftable(ItemStack first, ItemStack second, Player player) {
        Bukkit.recipeIterator().forEachRemaining(recipe -> {
            if (recipe instanceof SmithingRecipe) {

                SmithingRecipe smithingRecipe = (SmithingRecipe) recipe;
                if (smithingRecipe.getBase().equals(first) && smithingRecipe.getAddition().equals(second)) {
                    ItemStack result = smithingRecipe.getResult();
                    player.sendMessage(first.getType().toString() + " 2:" + second.getType().toString());
                    player.sendMessage("Result: " + result.getType());
                    crafteble = true;



                }
            }

        });




    }
}
