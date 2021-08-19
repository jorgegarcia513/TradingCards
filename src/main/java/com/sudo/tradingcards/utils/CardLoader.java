package com.sudo.tradingcards.utils;

import com.google.inject.Inject;
import com.sudo.tradingcards.TradingCards;
import com.sudo.tradingcards.components.cards.Card;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class CardLoader extends YMLBase {

    @Inject
    private TradingCards plugin;
    private FileConfiguration cardsConfig;

    public CardLoader(JavaPlugin plugin, String name) {
        super(plugin, name);
        this.plugin = (TradingCards) plugin;
        this.cardsConfig = getConfiguration();
    }

    public void initCard(String cardName) {
        if (this.cardsConfig.contains(cardName)) {
            String name = this.cardsConfig.getString(cardName + ".name");
            String flavorText = this.cardsConfig.getString(cardName + ".flavor text");
            String rarity = this.cardsConfig.getString(cardName + ".rarity");
            boolean isHolo = this.cardsConfig.getBoolean(cardName + ".is holo");

            Card c = new Card (name, flavorText, rarity, isHolo);
            this.plugin.getCardManager().addCard(cardName, c);
        }
    }

    public void initAllCards() {
        Set<String> cards = this.cardsConfig.getKeys(false);
        cards.forEach(this::initCard);
    }
}
