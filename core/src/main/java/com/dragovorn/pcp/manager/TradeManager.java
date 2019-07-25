package com.dragovorn.pcp.manager;

import com.dragovorn.pcp.api.manager.ITradeManager;
import com.dragovorn.pcp.entity.trade.TradeKey;
import com.dragovorn.pcp.entity.trade.TradeRequest;
import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.Map;

public final class TradeManager implements ITradeManager {

    private final Map<TradeKey, TradeRequest> requests = Maps.newHashMap();

    @Override
    public void requestTrade(Player player, Player target, int duration, int cooldown) {

    }

    @Override
    public void declineTrade(Player player, Player target) {

    }

    @Override
    public void acceptTrade(Player player, Player target) {

    }

    @Override
    public void startTrade(Player player, Player target) {

    }

    @Override
    public void endTrade(Player player, Player target) {

    }

    @Override
    public boolean hasTradeRequest(Player player, Player target) {
        return this.requests.containsKey(new TradeKey(player.getUniqueId(), target.getUniqueId()));
    }

    @Override
    public boolean isSender(Player player, Player target) {
        return this.requests.get(new TradeKey(player.getUniqueId(), target.getUniqueId())).getSender().equals(player.getUniqueId());
    }

    @Override
    public boolean isTrading(Player player) {
        return false;
    }
}
