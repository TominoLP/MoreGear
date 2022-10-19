package de.tomino.moregear.end.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class Enderride {

    public static ItemStack EnderrideSword() {
        ItemStack EnderrideSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = EnderrideSword.getItemMeta();
        AttributeModifier dmgmodifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dmgmodifier);
        AttributeModifier speedmodifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speedmodifier);
        meta.setDisplayName("§cEnderride Sword");
        meta.setLore(Arrays.asList(" ", "doubled Damage while in end", "§6§lAbility §e§lRight Click:", "§7Teleports you 8 in the Direction you looking at", "§7consume 10 charge", " ", "§6§lAbility §e§lSneak Right Click:", "§7Teleportport you 100 in the Direction you looking at", "§7consume 100 charge", " ", "§5§lEPIC SWORD"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10015);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideSword.setItemMeta(meta);
        return EnderrideSword;
    }

    public static ItemStack EnderrideBow() {
        ItemStack EnderrideBow = new ItemStack(Material.BOW);
        ItemMeta meta = EnderrideBow.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Bow");
        meta.setUnbreakable(true);
        meta.setCustomModelData(10016);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideBow.setItemMeta(meta);
        return EnderrideBow;
    }

    public static ItemStack EnderrideCrossbow() {
        ItemStack EnderrideCrossbow = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = EnderrideCrossbow.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Crossbow");
        meta.setUnbreakable(true);
        meta.setCustomModelData(10017);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideCrossbow.setItemMeta(meta);
        return EnderrideCrossbow;
    }

    public static ItemStack EnderridePickaxe() {
        ItemStack EnderridePickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = EnderridePickaxe.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Pickaxe");
        meta.setLore(Arrays.asList("§7Grands you 2x Drops", " ", "§6§lAbility §e§lSneak:", " ", "§7Veinminer (max 9 Blocks)", "§7consumes 50 charges", " ", "§5§lEPIC PICKAXE"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10010);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        EnderridePickaxe.setItemMeta(meta);
        return EnderridePickaxe;
    }

    public static ItemStack EnderrideAxe() {
        ItemStack EnderrideAxe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = EnderrideAxe.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Axe");
        meta.setLore(Arrays.asList(" ", "§6§lAbility §e§lSneak:", "§7Tree Chopper cuts down the", "§7entire tree at once", "§7consumes 20 charges", " ", "§5§lEPIC AXE"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10011);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideAxe.setItemMeta(meta);
        return EnderrideAxe;
    }

    public static ItemStack EnderrideShovel() {
        ItemStack EnderrideShovel = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = EnderrideShovel.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Shovel");
        meta.setLore(Arrays.asList(" ", "§6§lAbility §e§lSneak:", "§7Grants you 2x Speed", "§7consumes 20 charges", " ", "§5§lEPIC SHOVEL"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10012);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideShovel.setItemMeta(meta);
        return EnderrideShovel;
    }

    public static ItemStack EnderrideHoe() {
        ItemStack EnderrideHoe = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = EnderrideHoe.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Hoe");
        ;
        meta.setLore(Arrays.asList(" ", "§6§lAbility §e§l:", "§7Cultivater", "§7replace a 3x3 area with farmland", "§7consumes 5 charges", " ", "§5§lEPIC HOE"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10013);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideHoe.setItemMeta(meta);
        return EnderrideHoe;
    }

    public static ItemStack EnderrideIngot() {
        ItemStack enderrideIngot = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = enderrideIngot.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Ingot");
        meta.setCustomModelData(10020);
        enderrideIngot.setItemMeta(meta);
        return enderrideIngot;
    }

    public static ItemStack EnderrideScrap() {
        ItemStack enderrideScrap = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = enderrideScrap.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lEnderride Scrap");
        meta.setCustomModelData(10021);
        enderrideScrap.setItemMeta(meta);
        return enderrideScrap;
    }

    public static ItemStack CrsytalPearl() {
        ItemStack crystalPearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = crystalPearl.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5§lCrystal Pearl");
        meta.setCustomModelData(10022);
        crystalPearl.setItemMeta(meta);
        return crystalPearl;

    }

    public static ItemStack EnderrideHelmet() {
        ItemStack EnderrideHelmet = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = EnderrideHelmet.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        meta.setDisplayName("§5§lEnderride Helmet");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC HELMET"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10001);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideHelmet.setItemMeta(meta);
        return EnderrideHelmet;
    }

    public static ItemStack EnderrideChest() {
        ItemStack EnderrideChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = EnderrideChest.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        meta.setDisplayName("§5§lEnderride Chestplate");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC CHESTPLATE"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10002);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideChest.setItemMeta(meta);
        return EnderrideChest;
    }

    public static ItemStack EnderrideLeggins() {
        ItemStack EnderrideLeggins = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = EnderrideLeggins.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        meta.setDisplayName("§5§lEnderride Leggins");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC LEGGINS"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10003);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideLeggins.setItemMeta(meta);
        return EnderrideLeggins;
    }


    public static ItemStack EnderrideBoots() {
        ItemStack EnderrideBoots = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = EnderrideBoots.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        AttributeModifier movementspeedmodifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movementspeedmodifier);
        meta.setDisplayName("§5§lEnderride Boots");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC BOOTS"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10004);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideBoots.setItemMeta(meta);
        return EnderrideBoots;
    }

    public static ItemStack EnderrideElytra() {
        ItemStack EnderrideElytra = new ItemStack(Material.ELYTRA);
        ItemMeta meta = EnderrideElytra.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        meta.setDisplayName("§5§lEnderride Elytra");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC ELYTRA"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10005);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideElytra.setItemMeta(meta);
        return EnderrideElytra;
    }

    public static ItemStack EnderrideElytraAndChest() {
        ItemStack EnderrideElytraAndChest = new ItemStack(Material.ELYTRA);
        ItemMeta meta = EnderrideElytraAndChest.getItemMeta();
        assert meta != null;
        AttributeModifier healthmodifier = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthmodifier);
        AttributeModifier armormodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 12, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armormodifier);
        AttributeModifier armortoughnessmodifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armortoughnessmodifier);
        AttributeModifier knockbackresistancemodifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackresistancemodifier);
        meta.setDisplayName("§5§lEnderride Chestplate");
        meta.setLore(Arrays.asList(" ", "§6§lFull Set Bonus:", " ", "§7Increases your Overall Stats", "§7Give you the ability to", "§7glide in the Void", " ", "§6EPIC CHESTPLATE"));
        meta.setUnbreakable(true);
        meta.setCustomModelData(10006);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EnderrideElytraAndChest.setItemMeta(meta);
        return EnderrideElytraAndChest;
    }
}
