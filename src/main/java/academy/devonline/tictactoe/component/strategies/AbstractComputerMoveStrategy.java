package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

import java.util.Random;

public abstract class AbstractComputerMoveStrategy implements ComputerMoveStrategy {


    private final int expectedCountEmptyCells;

    protected AbstractComputerMoveStrategy(final int expectedCountEmptyCells) {
        this.expectedCountEmptyCells = expectedCountEmptyCells;
    }

    protected abstract Sign getSign(Sign moveSign);

    @Override
    public final boolean tryToMakeMove(final GameTable gameTable, final Sign moveSign) {
        final Sign findSign = getSign(moveSign);
        final BestCell bestCell = new BestCell();
        findBestCellForMoveByRows(gameTable, findSign, bestCell);
        findBestCellForMoveByCols(gameTable, findSign, bestCell);
        findBestCellForMoveByMainDioganal(gameTable, findSign, bestCell);
        findBestCellForMoveBySecondaryDioganal(gameTable, findSign, bestCell);

        if (bestCell.count != 0) {
            final Cell randomCell = bestCell.emptyCells[new Random().nextInt(bestCell.count)];
            gameTable.setSign(randomCell, moveSign);
            return true;
        }
        return false;
    }

    private void findBestCellForMoveByMainDioganal(final GameTable gameTable, final Sign findSign,
                                                   final BestCell bestCell) {
        findBestCellForMoveUsingLambdaConversion(gameTable, findSign, bestCell, 0, (i, j) -> new Cell(j, j));
    }



    private void findBestCellForMoveBySecondaryDioganal(final GameTable gameTable, final Sign findSign,
                                                        final BestCell bestCell) {
        findBestCellForMoveUsingLambdaConversion(gameTable, findSign, bestCell, 0, (i, j) -> new Cell(j, 2 - j));

    }

    private void findBestCellForMoveByCols(final GameTable gameTable, final Sign findSign,
                                           final BestCell bestCell) {
        for (int i1 = 0; i1 < 3; i1++) {
            findBestCellForMoveUsingLambdaConversion(gameTable, findSign, bestCell, i1, (i, j) -> new Cell(j, i));
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    private void findBestCellForMoveByRows(final GameTable gameTable, final Sign findSign,
                                           final BestCell bestCell) {
        for (int i1 = 0; i1 < 3; i1++) {
            findBestCellForMoveUsingLambdaConversion(gameTable, findSign, bestCell, i1, (i, j) -> new Cell(i, j));
        }
    }


    @FunctionalInterface
    private interface Lambda {
        Cell convert(int i, int j);
    }

    private void findBestCellForMoveUsingLambdaConversion(final GameTable gameTable,
                                                          final Sign findSign,
                                                          final BestCell bestCell,
                                                          int i,
                                                          final Lambda lambda) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        final Cell[] localEmptyCells = new Cell[3];
        for (int j = 0; j < 3; j++) {
            Cell cell = lambda.convert(i, j);
            if (gameTable.getSign(cell) == findSign) {
                countSignCells++;
            } else if (gameTable.isEmpty(cell)) {
                localEmptyCells[countEmptyCells++] = cell;
            } else {
                break;
            }
        }
        if (countEmptyCells == expectedCountEmptyCells && countSignCells == 3 - expectedCountEmptyCells) {
            for (int j = 0; j < countEmptyCells; j++) {
                bestCell.add(localEmptyCells[j]);
            }
        }
    }

    private static class BestCell {

        private final Cell[] emptyCells = new Cell[9];
        private int count;

        private void add(final Cell cell) {
            emptyCells[count++] = cell;
        }

    }
}
