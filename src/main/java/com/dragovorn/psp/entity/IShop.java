package com.dragovorn.psp.entity;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface IShop {

    void open(Player player);

    List<IShopItem> getItems();

    String getName();

    Location getLocation();

    UUID getOwner();
    
    boolean isOpen();
}
