package com.sudo.tradingcards.components.cards;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class CardManager {

    private TradingCards plugin;

    private HashMap<String, Card> cards;

    @Inject
    public CardManager(TradingCards plugin) {
        this.cards = new HashMap<String, Card>();
        this.plugin = plugin;
    }

    public void addCard(String cardIdentifier, Card c) {
        this.cards.put(cardIdentifier, c);
    }

    public Card getCard(String cardIdentifier) {
        if (!this.cardExistsInMap(cardIdentifier)) {
            this.plugin.getCardLoader().initCard(cardIdentifier);
        }
        return this.cards.get(cardIdentifier);
    }

    public boolean cardExistsInConfig(String cardIdentifier) {
        return this.plugin.getCardLoader().getConfiguration().contains(cardIdentifier);
    }

    public boolean cardExistsInMap(String cardIdentifier) {
        return this.cards.containsKey(cardIdentifier);
    }

    public HashMap<String, Card> getCards() {
        return this.cards;
    }

    public ItemStack getCardItem(String cardIdentifier) {
        Card c = this.getCard(cardIdentifier);
        String cardName = c.getName();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Description: " + c.getFlavorText());
        lore.add("Rarity: " + c.getRarity());

        ItemStack cardItem = new ItemStack(Material.PAPER);
        ItemMeta cardItemMeta = cardItem.getItemMeta();

        cardItemMeta.setDisplayName(cardName);
        cardItemMeta.setUnbreakable(true);
        cardItemMeta.setLore(lore);

        cardItem.setItemMeta(cardItemMeta);

        return cardItem;
    }
}
