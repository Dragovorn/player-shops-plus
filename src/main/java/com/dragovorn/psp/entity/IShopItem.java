package com.dragovorn.psp.entity;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface IShopItem {

    ItemStack getItem();

    Map<Integer, Integer> getPrices();

    int getAmount();
}
