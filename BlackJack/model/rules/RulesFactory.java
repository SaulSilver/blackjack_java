package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() { return new BasicHitStrategy(); }

  public INewGameStrategy GetNewGameRule() { return new AmericanNewGameStrategy();  }

  public IHitStrategy GetSoft17Rule() { return  new Soft17Strategy(); }

  public DrawWinRule GetWinRule() { return new DrawWinRule(DrawWinRule.WinRules.dealerAdvantage); }

}