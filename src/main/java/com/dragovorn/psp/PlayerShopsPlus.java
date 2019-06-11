package com.dragovorn.psp;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerShopsPlus extends JavaPlugin {

    private static PlayerShopsPlus instance;

    private static Economy economy;
    private static Permission permission;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

    public static PlayerShopsPlus getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Permission getPermission() {
        return permission;
    }
}
