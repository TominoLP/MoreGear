package de.tomino.moregear.utils;

import com.google.common.annotations.Beta;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    static {
        new ItemBuilder();
    }

    public ItemBuilder() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glow glow = new Glow();
            Enchantment.registerEnchantment(glow);
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ItemStack createItem(Material material, String displayName, int amount, String[] lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (displayName != null) {
            assert itemMeta != null;
            itemMeta.setDisplayName(displayName);
        }
        if (lore != null) {
            assert itemMeta != null;
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, MetaCallback callback) {
        ItemStack stack = createItem(material);
        stack.setItemMeta(callback.meta(stack.getItemMeta()));
        return stack;
    }

    public static ItemStack createItem(Material material, String displayName, String... lore) {
        return createItem(material, displayName, 1, lore);
    }

    public static ItemStack createItem(Material material, String displayName, int amount, List<String> lore) {
        if (lore != null) {
            String[] array = new String[lore.size()];
            for (int i = 0; i < lore.size(); i++) array[i] = lore.get(i);
            return createItem(material, displayName, amount, array);
        }
        return createItem(material, displayName, amount, new String[]{});
    }

    public static ItemStack createItem(Material material, String[] lore) {
        return createItem(material, null, 1, lore);
    }

    public static ItemStack createItem(Material material, String displayName, int amount, String lore) {
        return createItem(material, displayName, amount, new String[]{lore});
    }

    public static ItemStack createItem(Material material) {
        return new ItemStack(material);
    }

    public static ItemStack createItemWD(Material material, String displayName, int amount, int Data, String[] lore) {
        ItemStack itemStack = new ItemStack(material, amount, (byte) Data);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, Enchantment enchantment, int level) {
        ItemStack itemStack = new ItemStack(material);
        itemStack.addEnchantment(enchantment, level);
        return itemStack;
    }

    public static ItemStack createItemWithGlowEffect(Material material) {
        return applyEnchantment(createItem(material));
    }

    public static ItemStack applyEnchantment(ItemStack itemStack) {
        Glow glow = new Glow();
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addEnchant(glow, 1, true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createItemWDOL(Material material, String displayName, int amount, int Data) {
        ItemStack itemStack = new ItemStack(material, amount, (byte) Data);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, String displayName) {
        return createItem(material, displayName, 1, new String[0]);
    }

    public static ItemStack createItem(Material material, String displayName, String lore) {
        return createItem(material, displayName, 1, new String[]{lore});
    }

    @Deprecated
    public static ItemStack createItem(Material material, String displayName, String lore, Enchantment enchantment, int level) {
        ItemStack item = createItem(material, displayName, 1, new String[]{lore});
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

    public static void fillInv(Inventory inv, ItemStack item, int row) {
        for (int j = 0; j < 9; j++) {
            int a = (row - 1) * 9 + j;
            if (inv.getItem(a) == null)
                inv.setItem(a, item);
        }

    }

    @Beta
    public static void fillInvVertical(Inventory inv, ItemStack item, int row) {
        int maxHeight = inv.getMaxStackSize() / 9 - 1;

        int currentHeight = 0;
        for (int i = 0; i < maxHeight; i++) {
            int slot = currentHeight * 9 + (row - 1);
            if (inv.getItem(slot) == null)
                inv.setItem(slot, item);

            currentHeight++;
        }
    }

    @Deprecated
    public static void setItemsInRange(Inventory inv, int min, int max, List<ItemStack> items, boolean javaCount) {
        int toDo = max - min;
        if (javaCount)
            toDo--;

        for (ItemStack item : items) {
            inv.setItem(toDo, item);
            toDo++;
        }
    }

    public static void setArmor(Player p, ItemStack helm, ItemStack chestplate, ItemStack leggins, ItemStack boots) {
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chestplate);
        p.getInventory().setLeggings(leggins);
        p.getInventory().setBoots(boots);
    }

    public interface MetaCallback {
        ItemMeta meta(ItemMeta meta);
    }

    public static class Glow extends Enchantment {

        public Glow() {
            super(NamespacedKey.minecraft("glow"));
        }

        @Override
        public boolean canEnchantItem(ItemStack arg0) {
            return false;
        }

        @Override
        public boolean conflictsWith(Enchantment arg0) {
            return false;
        }

        @Override
        public @NotNull EnchantmentTarget getItemTarget() {
            return null;
        }

        @Override
        public boolean isTreasure() {
            return false;
        }

        @Override
        public boolean isCursed() {
            return false;
        }

        @Override
        public int getMaxLevel() {
            return 0;
        }

        @Override
        public @NotNull String getName() {
            return null;
        }

        @Override
        public int getStartLevel() {
            return 0;
        }
    }
}