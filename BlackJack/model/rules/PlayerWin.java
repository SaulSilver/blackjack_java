package BlackJack.model.rules;

/**
 * Created by Hatem on 11/12/2015.
 */
public class PlayerWin implements IWinStrategy {
    @Override
    public boolean DealerWin() {
        return false;
    }
}
