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

package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.GameOverHandler;

import java.util.Scanner;

public class ConsoleGameOverHandler implements GameOverHandler {


    final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("Game over!");
        new Scanner(System.in).nextLine();
    }
}
