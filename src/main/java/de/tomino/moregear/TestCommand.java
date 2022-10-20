package de.tomino.moregear;


import de.tomino.moregear.end.items.Enderride;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.getInventory().addItem(Enderride.EnderrideHelmet());
        player.getInventory().addItem(Enderride.EnderrideAxe());
        player.getInventory().addItem(Enderride.EnderridePickaxe());
        player.getInventory().addItem(Enderride.EnderrideBoots());
        player.getInventory().addItem(Enderride.EnderrideLeggins());
        player.getInventory().addItem(Enderride.EnderrideChest());
        player.getInventory().addItem(Enderride.EnderrideSword());
        player.getInventory().addItem(Enderride.EnderrideHoe());
        player.getInventory().addItem(Enderride.EnderrideShovel());
        player.getInventory().addItem(Enderride.EnderrideIngot());
        return false;
    }
}

