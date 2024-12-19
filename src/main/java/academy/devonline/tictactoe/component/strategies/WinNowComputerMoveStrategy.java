package academy.devonline.tictactoe.component.strategies;

import academy.devonline.tictactoe.model.game.Sign;

public class WinNowComputerMoveStrategy extends AbstractComputerMoveStrategy {


    public WinNowComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getSign(final Sign moveSign) {
        return moveSign;
    }
}
