package com.dragovorn.pcp;

import com.dragovorn.pcp.api.PCPAPI;
import com.dragovorn.pcp.command.ICommand;
import com.dragovorn.pcp.command.trade.TradeAcceptCommand;
import com.dragovorn.pcp.command.trade.TradeCommand;
import com.dragovorn.pcp.command.trade.TradeDeclineCommand;
import com.dragovorn.pcp.manager.TradeManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerCommercePlus extends JavaPlugin {

    private static PlayerCommercePlus instance;

    private static Economy economy;
    private static Permission permission;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            getLogger().severe("This plugin requires a Vault economy plugin to be present!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if (!setupPermissions()) {
            getLogger().severe("This plugin requires a Vault permission plugin to be present!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        register(new TradeCommand());
        register(new TradeAcceptCommand());
        register(new TradeDeclineCommand());

        PCPAPI.setTradeManager(new TradeManager());
        PCPAPI.init();
    }

    private void register(ICommand command) {
        getCommand(command.getCommandLabel()).setExecutor(command);
    }

    private void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);

        if (rsp == null) {
            return false;
        }

        permission = rsp.getProvider();

        return permission != null;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

        if (rsp == null) {
            return false;
        }

        economy = rsp.getProvider();
        return economy != null;
    }

    public static PlayerCommercePlus getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Permission getPermission() {
        return permission;
    }
}
