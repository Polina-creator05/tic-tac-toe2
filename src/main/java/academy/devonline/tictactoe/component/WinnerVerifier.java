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

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class WinnerVerifier {

    public boolean isWinner(final GameTable gameTable, final Player player) {
        return iswinnerByRows(gameTable, player.getSign()) ||
                isWinnerByCols(gameTable, player.getSign()) ||
                isWinnerByMainDioganal(gameTable, player.getSign()) ||
                isWinnerBySecondaryDioganal(gameTable, player.getSign());
    }

    private boolean isWinnerBySecondaryDioganal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 0)) &&
                gameTable.getSign(new Cell(0, 2)) == sign;
    }

    private boolean isWinnerByMainDioganal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(0, 0)) == sign;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final Sign sign) {
        for (int j = 0; j < 3; j++) {
            if (gameTable.getSign(new Cell(0, j)) == gameTable.getSign(new Cell(1, j)) &&
                    gameTable.getSign(new Cell(1, j)) == gameTable.getSign(new Cell(2, j)) &&
                    gameTable.getSign(new Cell(0, j)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean iswinnerByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 0)) == sign) {
                return true;
            }
        }
        return false;
    }
}
