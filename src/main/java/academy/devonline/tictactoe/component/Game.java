/*
 *
 *    Copyright 2024. http://devonline-academy
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Player;

import java.util.Random;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class Game {


    private final DataPrinter dataPrinter;

    private final UserInputReader userInputReader;

    private final Player player1;

    private final Player player2;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    final GameOverHandler gameOverHandler;

    private final boolean canSecondPlayerMakeFirstMove;


    public Game(final DataPrinter dataPrinter,
                final UserInputReader userInputReader,
                final Player player1,
                final Player player2,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier,
                final GameOverHandler gameOverHandler,
                final boolean canSecondPlayerMakeFirstMove) {
        this.dataPrinter = dataPrinter;
        this.userInputReader = userInputReader;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.gameOverHandler = gameOverHandler;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    public void play() {
        dataPrinter.printInstructions();
        final GameTable gameTable = new GameTable();

        if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        final Player[] players = {player1, player2};
        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWinner(gameTable, player)) {
                    dataPrinter.printInfoMessage(player + "win!");
                    gameOverHandler.gameOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    dataPrinter.printInfoMessage("Sorry, Draw!");
                    gameOverHandler.gameOver();
                    return;
                }
            }
        }
    }
}


