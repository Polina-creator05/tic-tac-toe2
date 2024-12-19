package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public class WinNowComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveByMainDioganal(gameTable, sign) ||
                tryToMakeMoveBySecondaryDioganal(gameTable, sign) ||
                tryToMakeMoveByCols(gameTable, sign) ||
                tryToMakeMoveByRows(gameTable, sign);
    }

    private boolean tryToMakeMoveByMainDioganal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUsingLambdaConversion(gameTable, sign, 0, (i, j) -> new Cell(j, j));
    }

    private boolean tryToMakeMoveBySecondaryDioganal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUsingLambdaConversion(gameTable, sign, 0, (i, j) -> new Cell(j, 2 - j));

    }

    private boolean tryToMakeMoveByCols(final GameTable gameTable, final Sign sign) {
        for (int i1 = 0; i1 < 3; i1++) {
            if (tryToMakeMoveUsingLambdaConversion(gameTable, sign, i1, (i, j) -> new Cell(j, i))) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("Convert2MethodRef")
    private boolean tryToMakeMoveByRows(final GameTable gameTable, final Sign sign) {
        for (int i1 = 0; i1 < 3; i1++) {
            if (tryToMakeMoveUsingLambdaConversion(gameTable, sign, i1, (i, j) -> new Cell(i, j))) {
                return true;
            }
        }
        return false;
    }



    @FunctionalInterface
    private interface Lambda {
        Cell convert(int i, int j);
    }

    private boolean tryToMakeMoveUsingLambdaConversion(final GameTable gameTable,
                                                       final Sign sign,
                                                       int i,
                                                       final Lambda lambda) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            Cell cell = lambda.convert(i, j);
            if (gameTable.getSign(cell) == sign) {
                countSignCells++;
            } else if (gameTable.isEmpty(cell)) {
                countEmptyCells++;
                lastEmptyCell = cell;
            } else {
                break;
            }
        }
        if (countSignCells == 2 && countEmptyCells == 1) {
            gameTable.setSign(lastEmptyCell, sign);
            return true;
        }
        return false;
    }
}
