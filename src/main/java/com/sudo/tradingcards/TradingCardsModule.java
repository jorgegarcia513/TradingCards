package com.sudo.tradingcards;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TradingCardsModule extends AbstractModule {

    private final TradingCards tradingCards;

    public TradingCardsModule(TradingCards tradingCards) {
        this.tradingCards = tradingCards;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(TradingCards.class).toInstance(this.tradingCards);
    }
}
