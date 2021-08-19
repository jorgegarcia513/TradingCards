package com.sudo.tradingcards.components.cards;

public class Card {

    private String name;
    private String flavorText;
    private String rarity;
    private boolean isHolo;

    //TODO: Image stuff

    public Card(String name, String flavorText, String rarity, boolean isHolo) {
        this.name = name;
        this.flavorText = flavorText;
        this.rarity = rarity;
        this.isHolo = isHolo;
    }

    public String getName() {
        return this.name;
    }

    public String getFlavorText() {
        return this.flavorText;
    }

    public String getRarity() {
        return this.rarity;
    }

    public boolean getIsHolo() {
        return this.isHolo;
    }
}
