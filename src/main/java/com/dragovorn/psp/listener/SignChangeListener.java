package com.dragovorn.psp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public final class SignChangeListener implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        if (event.getBlock().getType() != Material.WALL_SIGN) {
            return;
        }

        Block signBlock = event.getBlock();

        WallSign sign = (WallSign) signBlock.getBlockData();

        Block attachedBlock = signBlock.getRelative(sign.getFacing().getOppositeFace());

        if (attachedBlock.getType() != Material.CHEST) {
            return;
        }

        if (!event.getLine(0).equalsIgnoreCase("[shop]")) {
            return;
        }

        String name = ChatColor.translateAlternateColorCodes('&', event.getLine(1));
    }
}
