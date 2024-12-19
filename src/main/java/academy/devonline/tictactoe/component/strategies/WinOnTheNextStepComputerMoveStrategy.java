package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

import java.util.Random;

public class WinOnTheNextStepComputerMoveStrategy extends AbstractComputerMoveStrategy {


    public WinOnTheNextStepComputerMoveStrategy() {
        super(2);
    }

    @Override
    protected Sign getSign(final Sign moveSign) {
        return moveSign;
    }
}
