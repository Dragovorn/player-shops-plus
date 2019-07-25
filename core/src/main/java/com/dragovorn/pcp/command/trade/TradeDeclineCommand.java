package com.dragovorn.pcp.command.trade;

import com.dragovorn.pcp.command.ICommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class TradeDeclineCommand implements ICommand {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command is player only!");

            return true;
        }

        return true;
    }

    @Override
    public String getCommandLabel() {
        return "tradedecline";
    }
}
