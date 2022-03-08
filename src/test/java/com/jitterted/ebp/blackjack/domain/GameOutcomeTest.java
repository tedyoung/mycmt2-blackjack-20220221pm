package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

    @Test
    public void playerHitsAndGoesBustThenOutcomeReturnsPlayerBusted() throws Exception {
        Game game = new Game(StubDeck.playerHitsAndGoesBust());
        game.initialDeal();

        game.playerHits();

        assertThat(game.determineOutcome())
                .isEqualByComparingTo(GameOutcome.PLAYER_BUSTED);
    }

    @Test
    public void playerDealtBetterHandThanDealerAndStandsThenPlayerBeatsDealer() throws Exception {
        Game game = new Game(StubDeck.playerStandsAndBeatsDealer());
        game.initialDeal();

        game.playerStands();

        assertThat(game.determineOutcome())
                .isEqualByComparingTo(GameOutcome.PLAYER_BEATS_DEALER);
    }

    @Test
    public void playerDealtBlackjackUponInitialDealThenWinsBlackjackAndIsDone() throws Exception {
        Deck playerDealtBlackjackAndDealerNotDealtBlackjack = new StubDeck(Rank.ACE, Rank.NINE,
                                                                           Rank.JACK, Rank.EIGHT);
        Game game = new Game(playerDealtBlackjackAndDealerNotDealtBlackjack);

        game.initialDeal();

        assertThat(game.determineOutcome())
                .isEqualByComparingTo(GameOutcome.PLAYER_WINS_BLACKJACK);
        assertThat(game.isPlayerDone())
                .isTrue();
    }

    @Test
    public void playerNotDealtBlackjackThenUponInitialPlayerIsNotDone() throws Exception {
        Deck playerNotDealtBlackjack = new StubDeck(Rank.SEVEN, Rank.EIGHT,
                                                    Rank.NINE, Rank.JACK);
        Game game = new Game(playerNotDealtBlackjack);

        game.initialDeal();

        assertThat(game.isPlayerDone())
                .isFalse();
    }


    @Test
    public void standResultsInDealerDrawingCardOnTheirTurn() throws Exception {
        Deck dealerDrawsCardFromDeck =
                new StubDeck(Rank.TEN,  Rank.QUEEN,
                             Rank.NINE, Rank.FIVE,
                             Rank.SIX);
        Game game = new Game(dealerDrawsCardFromDeck);
        game.initialDeal();

        game.playerStands();

        assertThat(game.dealerHand().cards())
                .hasSize(3);
    }


}

