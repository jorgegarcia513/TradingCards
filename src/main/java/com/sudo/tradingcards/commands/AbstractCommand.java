package com.sudo.tradingcards.commands;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class AbstractCommand {

    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;
    private TradingCards plugin;

    @Inject
    public AbstractCommand(CommandSender sender, Command command, String label, String[] args, TradingCards plugin) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        this.plugin = plugin;
    }

    public abstract boolean runCommand();

    public CommandSender getSender() {
        return this.sender;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getLabel() {
        return this.label;
    }

    public String[] getArgs() {
        return this.args;
    }

    public TradingCards getPlugin() {
        return this.plugin;
    }
}
