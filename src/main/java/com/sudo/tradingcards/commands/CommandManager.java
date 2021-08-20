package com.sudo.tradingcards.commands;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.commands.debugging.GetAllCardsCommand;
import com.sudo.tradingcards.commands.debugging.GetCardCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {

    private TradingCards plugin;
    private List<String> commands;

    @Inject
    public CommandManager(TradingCards plugin) {
        this.plugin = plugin;
        this.commands = new ArrayList<String>();
        initCommands();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AbstractCommand abstractCommand;

        switch (args[0]) {
            case "showallcards":
                abstractCommand = new GetAllCardsCommand(sender, command, label, args, this.plugin);
                break;
            case "initcard":
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

    public void initCommands() {
        this.commands.add("give");
        this.commands.add("initcard");
        this.commands.add("showallcards");
    }

    public List<String> getCommands() {
        return this.commands;
    }
}
