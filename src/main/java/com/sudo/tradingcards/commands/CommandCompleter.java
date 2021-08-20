package com.sudo.tradingcards.commands;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandCompleter implements TabCompleter {

    private TradingCards plugin;

    @Inject
    public CommandCompleter(TradingCards plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if (alias.equals("cards")) {

            if (args.length == 2) {
                this.plugin.getServer().getOnlinePlayers().forEach(p -> {
                    list.add(p.getName());
                });
            }
            else if (args.length == 3) {
                return this.plugin.getCardManager().getCardIdentifiers();
            }
            else {
                return this.plugin.getCommandManager().getCommands();
            }
        }

        return null;
    }
}
