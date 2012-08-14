package com.djd.fun.rules.impl;

import com.djd.fun.rules.Rule;

import static com.djd.fun.rules.Operator.*;
import static com.djd.fun.rules.RelationalOperator.*;

/**
 * <pre>
 *
 * A ≠ 2
 * A + B = F
 * C - D = G
 * D + E = 2F
 * E + G = F
 *
 * A[0] B[1] C[2] D[3] E[4] F[5] G[6]
 * </pre>
 */
public class Apple7RuleImpl implements Rule {

  private static final int GRID_SIZE = 7;

  @Override
  public boolean applyRules(int[] a) {
    if( a == null || a.length > GRID_SIZE){
      throw new IllegalArgumentException();
    }
    boolean result = true;
    result &= NQ.apply(a[0], 2);
    result &= EQ.apply(PLUS.apply(a[0], a[1]), a[5]);
    result &= EQ.apply(MINUS.apply(a[2], a[3]), a[6]);
    result &= EQ.apply(PLUS.apply(a[3], a[4]), TIMES.apply(2, a[5]));
    result &= EQ.apply(PLUS.apply(a[4], a[6]), a[5]);
    return result;
  }

  @Override
  public int size() {
    return GRID_SIZE;
  }


  @Override
  public String toString(){
    return this.getClass().getName();
  }
}
