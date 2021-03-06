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

    public static Deck playerHitsAndGoesBust() {
        Deck playerHitsAndGoesBustDeck = new StubDeck(Rank.TEN, Rank.EIGHT,
                                                      Rank.QUEEN, Rank.JACK,
                                                      Rank.THREE);
        return playerHitsAndGoesBustDeck;
    }

    public static Deck playerStandsAndBeatsDealer() {
        Deck playerStandsAndBeatsDealer = new StubDeck(Rank.TEN,   Rank.EIGHT,
                                                       Rank.QUEEN, Rank.JACK);
        return playerStandsAndBeatsDealer;
    }

    public static Deck playerHitsAndDoesNotGoBust() {
        return new StubDeck(Rank.NINE, Rank.EIGHT,
                            Rank.SIX, Rank.JACK,
                            Rank.FOUR);
    }

    public static Deck playerDealtBlackjack() {
        return new StubDeck(Rank.TEN, Rank.EIGHT,
                            Rank.ACE, Rank.JACK);
    }

    @Override
    public Card draw() {
        return iterator.next();
    }
}
