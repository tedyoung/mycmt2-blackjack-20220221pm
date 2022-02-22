package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Game;

// Adapter Controller
public class ConsoleGame {

    private final Game game;

    public ConsoleGame(Game game) {
        this.game = game;
    }

    public void start() {
        Game.displayWelcomeScreen();
        Game.waitForEnterFromUser();

        game.initialDeal();

        playerPlays();

        game.dealerTurn();

        game.displayFinalGameState();

        game.determineOutcome();

        Game.resetScreen();
    }

    // Control (play) loop
    public void playerPlays() {
        while (!game.isPlayerDone()) {
            game.displayGameState();
            String command = game.inputFromPlayer();
            handle(command);
        }
    }

    // translation of input to commands/queries against Domain
    public void handle(String command) {
        if (command.toLowerCase().startsWith("h")) {
            game.playerHits();
        } else if (command.toLowerCase().startsWith("s")) {
            game.playerStands();
        }
    }

}
