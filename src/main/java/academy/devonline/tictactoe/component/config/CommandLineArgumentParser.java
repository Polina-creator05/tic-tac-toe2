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

package academy.devonline.tictactoe.component.config;

import academy.devonline.tictactoe.model.config.Level;
import academy.devonline.tictactoe.model.config.PlayerType;
import academy.devonline.tictactoe.model.config.UserInterface;

import static academy.devonline.tictactoe.model.config.Level.*;
import static academy.devonline.tictactoe.model.config.PlayerType.COMPUTER;
import static academy.devonline.tictactoe.model.config.PlayerType.USER;
import static academy.devonline.tictactoe.model.config.UserInterface.CONSOLE;
import static academy.devonline.tictactoe.model.config.UserInterface.GUI;
import static java.lang.String.format;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        Level level = null;
        UserInterface userInterface = null;
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        for (final String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because player types alredy set: playerType1 = '%s', playerType2 = '%s'!%n",
                            arg, playerType1, playerType2);
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because userInterface alredy set: userInterface= '%s'!%n",
                            arg, userInterface);
                }
            } else if (LEVEL1.name().equalsIgnoreCase(arg) ||
                    LEVEL2.name().equalsIgnoreCase(arg) ||
                    LEVEL3.name().equalsIgnoreCase(arg)) {
                if (level == null) {
                    level = Level.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because level already set: level='%s'!%n",
                            arg, level);
                }
            } else {
                System.err.printf(
                        "Unsupported command line argument: '%s'!%n",
                        arg);
            }
        }
        if (level == null) {
            level = LEVEL3;
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        if (playerType1 == null) {
            return new CommandLineArguments(level, userInterface, USER, COMPUTER);
        } else if (playerType2 == null) {
            return new CommandLineArguments(level, userInterface, USER, playerType1);
        } else {
            return new CommandLineArguments(level, userInterface, playerType1, playerType2);
        }
    }

    public static class CommandLineArguments {

        private final Level level;

        private final UserInterface userInterface;

        private final PlayerType playerType1;

        private final PlayerType playerType2;

        private CommandLineArguments(final Level level, final UserInterface userInterface, final PlayerType playerType1, final PlayerType playerType2) {
            this.level = level;
            this.userInterface = userInterface;
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }

        public Level getGameLevel() {return level;}

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
