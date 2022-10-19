package de.tomino.moregear.end.items.crafting;

import de.tomino.moregear.end.items.Enderride;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;

import java.util.Objects;


public class ArmorRecipi {

    ItemStack ingot = Enderride.EnderrideIngot();


    SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MoreGear")), "test"),
            new ItemStack(Material.NETHERITE_PICKAXE),
            new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET),
            new RecipeChoice.MaterialChoice(Material.BLUE_ICE));


    public void registerRecipes() {
        Bukkit.addRecipe(recipe);


    }

}
