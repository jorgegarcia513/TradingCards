package com.sudo.tradingcards.commands.debugging;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.commands.AbstractCommand;
import com.sudo.tradingcards.components.cards.Card;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class GetAllCardsCommand extends AbstractCommand {

    private TradingCards plugin;

    @Inject
    public GetAllCardsCommand(CommandSender sender, Command command, String label, String[] args, TradingCards plugin) {
        super(sender, command, label, args, plugin);
        this.plugin = plugin;
    }

    @Override
    public boolean runCommand() {
        HashMap<String, Card> cards = plugin.getCardManager().getCards();
        CommandSender sender = getSender();
        cards.values().forEach(card -> {
            sender.sendMessage("---------------");
            sender.sendMessage("Name: " + card.getName());
            sender.sendMessage("Flavor Text: " + card.getFlavorText());
            sender.sendMessage("Rarity: " + card.getRarity());
            sender.sendMessage("Is Holo: " + card.getIsHolo());
        });
        return true;
    }
}
