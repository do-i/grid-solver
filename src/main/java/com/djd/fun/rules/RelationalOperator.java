package com.djd.fun.rules;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public enum RelationalOperator {

  GT(">") {
    public boolean apply(double x, double y) {
      return x > y;
    }
  },
  LT("<") {
    public boolean apply(double x, double y) {
      return x < y;
    }
  },
  EQ("==") {
    public boolean apply(double x, double y) {
      return 0 == Double.compare(x, y);
    }
  },
  NQ("!=") {
    public boolean apply(double x, double y) {
      return 0 != Double.compare(x, y);
    }
  };
  private final String symbol;

  private RelationalOperator(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

  public abstract boolean apply(double x, double y);

}
