package com.djd.fun.rules.impl;


import com.djd.fun.rules.Rule;

import static com.djd.fun.rules.Operator.PLUS;
import static com.djd.fun.rules.RelationalOperator.EQ;

/**
 * <pre>
 * B + A = 6
 * E + B = C
 * E + C + B = 8
 *
 * [0] A
 * [1] B
 * [2] C
 * [3] D
 * [4] E
 * </pre>
 *
 *
 */
public class Egg5RuleImpl implements Rule {

  private static final int GRID_SIZE = 5;

  @Override
  public int size() {
    return GRID_SIZE;
  }

  @Override
  public boolean applyRules(int[] a) {
    boolean result = true;
    result &= EQ.apply(PLUS.apply(a[1], a[0]), 6);
    result &= EQ.apply(PLUS.apply(a[4], a[1]), a[2]);
    result &= EQ.apply(PLUS.apply(a[4], PLUS.apply(a[2], a[1])), 8);
    return result;
  }

  @Override
  public String toString(){
    return this.getClass().getName();
  }

}

