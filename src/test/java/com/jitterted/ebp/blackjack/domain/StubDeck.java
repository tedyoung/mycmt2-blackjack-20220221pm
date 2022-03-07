package com.jitterted.ebp.blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StubDeck extends Deck {
    private static final Suit DUMMY_SUIT = Suit.HEARTS;
    private final ListIterator<Card> iterator;

    public StubDeck(List<Card> cards) {
        this.iterator = cards.listIterator();
    }

    public StubDeck(Rank... ranks) {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        this.iterator = cards.listIterator();
    }

    static Deck playerHitsAndGoesBust() {
        Deck playerHitsAndGoesBustDeck = new StubDeck(Rank.TEN, Rank.EIGHT,
                                                      Rank.QUEEN, Rank.JACK,
                                                      Rank.THREE);
        return playerHitsAndGoesBustDeck;
    }

    static Deck playerStandsAndBeatsDealer() {
        Deck playerStandsAndBeatsDealer = new StubDeck(Rank.TEN,   Rank.EIGHT,
                                                       Rank.QUEEN, Rank.JACK);
        return playerStandsAndBeatsDealer;
    }

    @Override
    public Card draw() {
        return iterator.next();
    }
}
