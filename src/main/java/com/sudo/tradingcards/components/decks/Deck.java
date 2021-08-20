package com.sudo.tradingcards.components.decks;

import com.sudo.tradingcards.components.cards.Card;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Deck {
    private Player owner;
    private HashMap<String, Card> cards;

    public Deck() {
        this.cards = new HashMap<>();
    }

    public void addCard(String cardIdentifier, Card c) {
        this.cards.put(cardIdentifier, c);
    }

    public void removeCard(String cardIdentifier) {
        this.cards.remove(cardIdentifier);
    }

    public boolean hasCard(String cardIdentifier) {
        return this.cards.containsKey(cardIdentifier);
    }
}
