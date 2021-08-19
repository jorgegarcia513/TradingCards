package com.sudo.tradingcards.commands;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.commands.debugging.GetAllCardsCommand;
import com.sudo.tradingcards.commands.debugging.GetCardCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {

    private TradingCards plugin;

    @Inject
    public CommandManager(TradingCards plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AbstractCommand abstractCommand;

        switch (args[0]) {
            case "getallcards":
                abstractCommand = new GetAllCardsCommand(sender, command, label, args, this.plugin);
                break;
            case "getcard":
                abstractCommand = new GetCardCommand(sender, command, label, args, this.plugin);
                break;
            case "give":
                abstractCommand = new GiveCardCommand(sender, command, label, args, this.plugin);
                break;
            default:
                //TODO: fix this
                abstractCommand = null;

        }
        return abstractCommand.runCommand();
    }
}
