package com.sudo.tradingcards.components.cards;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardManager {

    private TradingCards plugin;

    private HashMap<String, Card> cards;
    private CardItemBuilder cardItemBuilder;

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

    /**
     * Get the ItemStack used to represent a card.
     * @param cardIdentifier
     * @return ItemStack
     */
    public ItemStack getCardItem(String cardIdentifier) {
        Card c = this.getCard(cardIdentifier);
        this.cardItemBuilder = new CardItemBuilder();
        return this.cardItemBuilder.buildCardItem(c);
    }

    public List<String> getCardIdentifiers() {
        return new ArrayList<>(this.cards.keySet());
    }
}
