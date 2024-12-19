package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public class PreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {


    @Override
    protected Sign getSign(final Sign moveSign) {
        return moveSign.oppositeSign();
    }
}


