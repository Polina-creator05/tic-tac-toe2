package academy.devonline.tictactoe.model.config;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.component.strategies.*;

public enum Level {

    LEVEL1(new ComputerMoveStrategy[]{
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()}),

    LEVEL2(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()}),

    LEVEL3(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new WinOnTheNextStepComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()});

    private final ComputerMoveStrategy [] computerMoveStrategies;

    Level(final ComputerMoveStrategy[] computerMoveStrategies) {
        this.computerMoveStrategies = computerMoveStrategies;
    }

    public ComputerMoveStrategy[] getComputerMoveStrategies(){
        return computerMoveStrategies.clone();
    }


}
