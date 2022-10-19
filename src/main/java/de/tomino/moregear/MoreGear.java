package de.tomino.moregear;

import de.tomino.moregear.end.items.functions.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class MoreGear extends JavaPlugin {

    public final HashMap<Player, Long> charges = new HashMap<>();
    private final List<Player> fillSetPlayers = new ArrayList<>();
    private final List<Player> playersWithTool = new ArrayList<>();

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new EnderrideArmorListener(this), this);
        this.getServer().getPluginManager().registerEvents(new EnderrideSwordListener(this), this);
        this.getServer().getPluginManager().registerEvents(new EnderridePickaxeListener(this), this);
        this.getServer().getPluginManager().registerEvents(new EnderrideAxtListener(this), this);
        this.getServer().getPluginManager().registerEvents(new EnderrideHoeListener(this), this);
        this.getServer().getPluginManager().registerEvents(new ToolListener(this), this);


        Objects.requireNonNull(this.getCommand("test")).setExecutor(new TestCommand());

        Bukkit.getScheduler().runTaskTimerAsynchronously(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("Moregear")), () ->
                this.fillSetPlayers.forEach(player -> {
                    player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 7, 0.5, 0.5, 0.5, 0.1);
                    player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation(), 10, 0.5, 0.5, 0.5, 0.2);
                }), 20, 5);

        Bukkit.getScheduler().runTaskTimerAsynchronously(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("Moregear")), () ->
                this.charges.forEach((player, aLong) -> {
                    this.playersWithTool.forEach(target -> {
                        target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(this.generateChargeDisplayString(aLong)));
                    });
                    if (aLong < 100) this.charges.put(player, aLong + 1);
                }), 0, 3);
    }

    private String generateChargeDisplayString(long aLong) {
        return "§6§lCharges §7§l: §6§l " + "■".repeat(Math.max(0, (int) (aLong / 10))) +
                "□".repeat(Math.max(0, 10 - (int) (aLong / 10)));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public List<Player> getFillSetPlayers() {
        return fillSetPlayers;
    }

    public List<Player> getPlayersWithTool() {
        return playersWithTool;
    }
}
