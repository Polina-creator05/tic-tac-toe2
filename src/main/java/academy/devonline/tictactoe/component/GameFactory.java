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

import academy.devonline.tictactoe.component.keypad.CellNumberConverter;
import academy.devonline.tictactoe.component.keypad.TerminalNumericKeypadCellNumberConverter;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.PlayerType;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

public class GameFactory {

    private PlayerType playerType1 = PlayerType.USER;

    private PlayerType playerType2 = PlayerType.COMPUTER;

    public GameFactory(final String[] args) {
        //TODO
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        return new Game(new DataPrinter(cellNumberConverter),
                //FIXME
                new Player(X, new UserMove(cellNumberConverter)),
                new Player(O, new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier(),
                true);
    }
}
