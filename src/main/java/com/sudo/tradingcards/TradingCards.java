package com.sudo.tradingcards;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sudo.tradingcards.commands.CommandManager;
import com.sudo.tradingcards.components.cards.Card;
import com.sudo.tradingcards.components.cards.CardManager;
import com.sudo.tradingcards.utils.CardLoader;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@Getter
public class TradingCards extends JavaPlugin {

    @Inject
    private CommandManager commandManager;

    @Inject
    private CardManager cardManager;

    private CardLoader cardLoader;

    private File cardsConfigFile;
    private FileConfiguration cardsConfig;

    @Override
    public void onEnable() {
        // Dependency Injection stuff
        TradingCardsModule module = new TradingCardsModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        this.commandManager = new CommandManager(this);
        this.cardManager = new CardManager(this);
        this.cardLoader = new CardLoader(this, "cards.yml");
        this.getCommand("cards").setExecutor(this.commandManager);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getCardsConfig() {
        return this.cardsConfig;
    }

}
