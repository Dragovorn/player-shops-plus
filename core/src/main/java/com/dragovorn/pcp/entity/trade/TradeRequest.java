package com.dragovorn.pcp.entity.trade;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class TradeRequest {

    private final BukkitRunnable runnable;

    private final UUID sender;

    public TradeRequest(UUID sender) {
        this.sender = sender;
        this.runnable = null; // TODO: Construct the runnable in here.
    }

    public UUID getSender() {
        return this.sender;
    }

    public BukkitRunnable getRunnable() {
        return this.runnable;
    }
}
