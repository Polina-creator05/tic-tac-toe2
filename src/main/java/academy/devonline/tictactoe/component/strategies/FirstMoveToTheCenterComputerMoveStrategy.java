package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public class FirstMoveToTheCenterComputerMoveStrategy implements ComputerMoveStrategy {


    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        final Cell cell= new Cell(1,1);
        if (gameTable.isEmpty(cell)){
            gameTable.setSign(cell, sign);
            return true;
        }
        return false;
    }
}
