package com.dragovorn.psp.manager;

import com.dragovorn.psp.entity.IShop;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface IDataManager {

    void deleteShop(IShop shop);

    boolean isShop(Location location);

    IShop createShop(String name, Player player);

    IShop getShop(Location location);
}
