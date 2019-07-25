package com.dragovorn.pcp.api;

import com.dragovorn.pcp.api.manager.ITradeManager;
import org.bukkit.Bukkit;

public class PCPAPI {

    private static boolean init;

    private static ITradeManager tradeManager;

    public static void init() {
        if (init) {
            throw new IllegalStateException("You cannot initialize the PCPAPI again!");
        }

        if (tradeManager == null) {
            throw new IllegalStateException("PCPAPI cannot be initialized with out a trade manager!");
        }

        init = true;
    }

    public static void setTradeManager(ITradeManager tradeManager) {
        if (init) {
            throw new IllegalStateException("You cannot change PCPAPI after it's been initialized!");
        }

        if (PCPAPI.tradeManager != null) {
            Bukkit.getLogger().warning("[PCPAPI]: Failed to register new trade handler " + tradeManager.getClass().getName() + " there already is a trade handler present!");
            return;
        }

        PCPAPI.tradeManager = tradeManager;
    }

    public static ITradeManager getTradeManager() {
        return tradeManager;
    }
}
