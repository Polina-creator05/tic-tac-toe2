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

package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.*;
import academy.devonline.tictactoe.component.config.CommandLineArgumentParser;
import academy.devonline.tictactoe.component.console.CellNumberConverter;
import academy.devonline.tictactoe.component.console.ConsoleDatePrinter;
import academy.devonline.tictactoe.component.console.ConsoleGameOverHandler;
import academy.devonline.tictactoe.component.console.ConsoleUserInputReader;
import academy.devonline.tictactoe.component.console.keypad.DesktopNumericKeypadCellNumberConverter;
import academy.devonline.tictactoe.component.strategies.RandomComputerMoveStrategy;
import academy.devonline.tictactoe.component.swing.GameWindow;
import academy.devonline.tictactoe.model.config.PlayerType;
import academy.devonline.tictactoe.model.config.UserInterface;
import academy.devonline.tictactoe.model.game.Player;

import static academy.devonline.tictactoe.model.config.PlayerType.USER;
import static academy.devonline.tictactoe.model.config.UserInterface.GUI;
import static academy.devonline.tictactoe.model.game.Sign.O;
import static academy.devonline.tictactoe.model.game.Sign.X;

public class GameFactory {

    private final UserInterface userInterface;

    private final PlayerType playerType1;

    private final PlayerType playerType2;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parse();
        this.playerType1 = commandLineArguments.getPlayerType1();
        this.playerType2 = commandLineArguments.getPlayerType2();
        this.userInterface = commandLineArguments.getUserInterface();
    }

    public Game create() {
        final ComputerMoveStrategy[] strategies={
                new RandomComputerMoveStrategy()

        };
        final GameOverHandler gameOverHandler;
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;// ConsoleDatePrinter(cellNumberConverter);
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;//new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            // final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDatePrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        final Player player1;
        if (playerType1 == USER) {
            player1 = new Player(X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove(strategies));
        }
        final Player player2;
        if (playerType2 == USER) {
            player2 = new Player(O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove(strategies));
        }

        final boolean canSecondPlayerMakeFirstMove = playerType1 != playerType2;
        return new Game(
                dataPrinter,
                userInputReader, player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandler,
                canSecondPlayerMakeFirstMove);
    }
}
