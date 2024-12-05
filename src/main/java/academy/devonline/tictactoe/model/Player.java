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

package academy.devonline.tictactoe.model;

import academy.devonline.tictactoe.component.Move;

public final class Player {

    private final Sign sign;

    private final Move move;

    public Player(final Sign sign, final Move move) {
        this.sign = sign;
        this.move = move;
    }

    public Sign getSign() {
        return sign;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "'" + sign + "'";
    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sign);
    }
}
