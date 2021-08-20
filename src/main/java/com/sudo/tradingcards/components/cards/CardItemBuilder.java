package com.sudo.tradingcards.components.cards;

import com.sudo.tradingcards.utils.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CardItemBuilder {
    private ItemBuilder cardItem;

    public CardItemBuilder() {
        this.cardItem = new ItemBuilder(Material.PAPER, 1);
    }

    public ItemStack buildCardItem(Card c) {
        this.setCardName(c.getName())
                .setCardDescription(c.getFlavorText())
                .setCardRarity(c.getRarity());
        return this.cardItem.toItemStack();
    }

    public CardItemBuilder setCardName(String cardName) {
        this.cardItem.setName(ChatColor.RED + cardName);
        return this;
    }

    public CardItemBuilder setCardDescription(String cardDescription) {
        this.cardItem.setLore("Description: " + ChatColor.translateAlternateColorCodes('&', cardDescription));
        return this;
    }

    public CardItemBuilder setCardRarity(String cardRarity) {
        this.cardItem.addLoreLine("Rarity: " + ChatColor.translateAlternateColorCodes('&', cardRarity));
        return this;
    }



}
