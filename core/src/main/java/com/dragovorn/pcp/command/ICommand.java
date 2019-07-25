package com.dragovorn.pcp.command;

import org.bukkit.command.CommandExecutor;

public interface ICommand extends CommandExecutor {

    String getCommandLabel();
}
