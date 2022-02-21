package com.jitterted.ebp.blackjack;

public class ConsoleHand {
    // transform: Hand (DO) -> String (Console-specific)
    static String displayFirstCard(Hand hand) {
        return ConsoleCard.display(hand.dealerFaceUpCard());
    }
}
