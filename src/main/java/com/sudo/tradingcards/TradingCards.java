package com.sudo.tradingcards;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sudo.tradingcards.commands.CommandCompleter;
import com.sudo.tradingcards.commands.CommandManager;
import com.sudo.tradingcards.components.cards.Card;
import com.sudo.tradingcards.components.cards.CardManager;
import com.sudo.tradingcards.components.decks.Deck;
import com.sudo.tradingcards.components.decks.DeckManager;
import com.sudo.tradingcards.utils.CardLoader;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.ipvp.canvas.MenuFunctionListener;

import java.io.File;
import java.io.IOException;

@Getter
public class TradingCards extends JavaPlugin {

    @Inject
    private CommandManager commandManager;

    @Inject
    private CardManager cardManager;

    @Inject
    private DeckManager deckManager;

    private CardLoader cardLoader;

    @Override
    public void onEnable() {
        // Dependency Injection stuff
        TradingCardsModule module = new TradingCardsModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        this.commandManager = new CommandManager(this);
        this.cardManager = new CardManager(this);
        this.deckManager = new DeckManager(this);
        this.cardLoader = new CardLoader(this, "cards.yml");
        this.getCommand("cards").setExecutor(this.commandManager);
        this.getCommand("cards").setTabCompleter(new CommandCompleter(this));
        Bukkit.getPluginManager().registerEvents(new MenuFunctionListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
