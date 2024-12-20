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

package academy.devonline.tictactoe.component.console.keypad;

import academy.devonline.tictactoe.component.console.CellNumberConverter;
import academy.devonline.tictactoe.model.game.Cell;

import static java.lang.String.format;

public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    final char[][] mapping = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };


    @Override
    public Cell toCell(final char number) {
            if (number >= 1 && number <= 9) {
                final int value = number - '0' - 1;
                return new Cell(value / 3, value % 3);
            }else {
                throw new IllegalArgumentException(
                        format("Number parametr must be between '1' and '9'! Current value is '%s'!", number)
                );
            }
    }

    @Override
    public char toNumber(Cell cell) {
        if (cell.getRow() >= 0 && cell.getRow()<= 2 && cell.getCol()>=0 && cell.getCol()<=2) {
            return (char) ('0' + (cell.getRow() * 3 + cell.getCol() + 1));
        }else{
            throw new IllegalArgumentException(
                    format("Row and col indexes must be between 0 and 2. Current row is %s, current col is %s!",
                            cell.getRow(),cell.getCol())
            );
        }
    }
}


