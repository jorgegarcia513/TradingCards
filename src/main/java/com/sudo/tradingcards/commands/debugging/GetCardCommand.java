package com.sudo.tradingcards.commands.debugging;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.commands.AbstractCommand;
import com.sudo.tradingcards.components.cards.Card;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class GetCardCommand extends AbstractCommand {

    private TradingCards plugin;

    @Inject
    public GetCardCommand(CommandSender sender, Command command, String label, String[] args, TradingCards plugin) {
        super(sender, command, label, args, plugin);
        this.plugin = plugin;
    }

    @Override
    public boolean runCommand() {
        String cardName = getArgs()[1];
        this.plugin.getCardLoader().initCard(cardName);
        getSender().sendMessage("Initializing card with name: " + cardName);
        this.plugin.getCardManager().getCards().values().forEach(c -> {
            getSender().sendMessage(c.getName());
        });
        return true;
    }
}
