package BlackJack.model.rules;

public class DrawWinRule
{
    public enum WinRules{
        dealerAdvantage,
        playerAdvantage,
        draw
    }
    private WinRules win_rule;

    public WinRules getWin_rule() {
        return win_rule;
    }

    public void setWin_rule(WinRules win_rule) {
        this.win_rule = win_rule;
    }

    public DrawWinRule(WinRules win_rule)	{
        this.win_rule = win_rule;
    }

    public boolean whoWins(){

        if (win_rule == WinRules.dealerAdvantage)
        {
            return true;
        }
        else if (win_rule == WinRules.playerAdvantage)
        {
            return false;
        }
        return false;
    }
}
