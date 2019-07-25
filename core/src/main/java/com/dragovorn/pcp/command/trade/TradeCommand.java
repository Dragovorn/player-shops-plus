package com.dragovorn.pcp.command.trade;

import com.dragovorn.pcp.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class TradeCommand implements ICommand {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command is player only!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Incorrect arguments! Please use " + ChatColor.GOLD + "/trade <player>" + ChatColor.RED + "!");
            return true;
        }

        String otherName = args[0];

        OfflinePlayer otherOffline = Bukkit.getOfflinePlayer(args[0]);

        if (otherOffline == null) {
            sender.sendMessage(ChatColor.RED + "Cannot find player: " + ChatColor.GOLD + otherName + ChatColor.RED + "!");
            return true;
        }

        if (!otherOffline.isOnline()) {
            sender.sendMessage(ChatColor.GOLD + otherName + ChatColor.RED + " isn't online!");
            return true;
        }

        Player other = (Player) otherOffline;

        return true;
    }

    @Override
    public String getCommandLabel() {
        return "trade";
    }
}
