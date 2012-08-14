package com.djd.fun.rules;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Operator {
  PLUS("+") {
    public int apply(int x, int y) {
      return x + y;
    }
  },
  MINUS("-") {
    public int apply(int x, int y) {
      return x - y;
    }
  },
  TIMES("*") {
    public int apply(int x, int y) {
      return x * y;
    }
  },
  DIVIDE("/") {
    public int apply(int x, int y) {
      if(y==0){
        throw new IllegalArgumentException();
      }
      return x / y;
    }
  };
  private final String symbol;

  private Operator(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

  public abstract int apply(int x, int y);

}
