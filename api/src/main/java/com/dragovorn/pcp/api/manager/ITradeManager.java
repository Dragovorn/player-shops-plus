package com.dragovorn.pcp.api.manager;

import org.bukkit.entity.Player;

public interface ITradeManager {

    void requestTrade(Player player, Player target, int duration, int cooldown);
    void declineTrade(Player player, Player target);
    void acceptTrade(Player player, Player target);
    void startTrade(Player player, Player target);
    void endTrade(Player player, Player target);

    boolean hasTradeRequest(Player player, Player target);
    boolean isSender(Player player, Player target);
    boolean isTrading(Player player);
}
