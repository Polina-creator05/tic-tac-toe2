package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.model.game.Sign;

public class WinNowComputerMoveStrategy extends AbstractComputerMoveStrategy {


    @Override
    protected Sign getSign(final Sign moveSign) {
        return moveSign;
    }
}
