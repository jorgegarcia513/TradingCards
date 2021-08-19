package com.sudo.tradingcards.commands;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.components.cards.Card;
import com.sudo.tradingcards.components.cards.CardManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveCardCommand extends AbstractCommand {

    private TradingCards plugin;
    private CardManager cardManager;

    @Inject
    public GiveCardCommand(CommandSender sender, Command command, String label, String[] args, TradingCards plugin) {
        super(sender, command, label, args, plugin);
        this.plugin = plugin;
        this.cardManager = this.plugin.getCardManager();
    }

    @Override
    public boolean runCommand() {
        String[] args = getArgs();
        CommandSender sender = getSender();

        if (args.length != 3) {
            sender.sendMessage("[TradingCards] Usage: /cards give <player name> <card name>");
            return true;
        }

        String playerName = args[1];
        String cardIdentifier = args[2];

        if (this.plugin.getServer().getPlayer(playerName) == null) {
            sender.sendMessage("[TradingCards] Player does not exist.");
            return true;
        }

        if (!this.cardManager.cardExistsInConfig(cardIdentifier)) {
            sender.sendMessage("[TradingCards] That card does not exist.");
            return true;
        }

        Player player = this.plugin.getServer().getPlayer(playerName);
        PlayerInventory inventory = player.getInventory();

        ItemStack cardItem = this.cardManager.getCardItem(cardIdentifier);
        inventory.addItem(cardItem);

        sender.sendMessage("[TradingCards] Successfully gave card to " + playerName);
        return true;
    }
}
