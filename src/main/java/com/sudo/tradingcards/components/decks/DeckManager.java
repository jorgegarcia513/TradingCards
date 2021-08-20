package com.sudo.tradingcards.components.decks;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class DeckManager {

    private TradingCards plugin;

    private HashMap<String, Deck> decks;

    @Inject
    public DeckManager(TradingCards plugin) {
        this.plugin = plugin;
    }

    public void initDeck(Player p) {

    }

    public Deck getDeck(String owner) {
        return this.decks.get(owner);
    }
}
