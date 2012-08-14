package com.djd.fun.rules.impl;

import com.djd.fun.rules.Rule;

import static com.djd.fun.rules.Operator.MINUS;
import static com.djd.fun.rules.Operator.PLUS;
import static com.djd.fun.rules.Operator.TIMES;
import static com.djd.fun.rules.RelationalOperator.EQ;
import static com.djd.fun.rules.RelationalOperator.GT;
import static com.djd.fun.rules.RelationalOperator.NQ;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * <p/>
 * 3A = 2D
 * 3C = 2E
 * 3A = 4E
 * B > F
 *  A[0] B[1] C[2] D[3] E[4] F[5]
 */
public class Orange6RuleImpl implements Rule {


  private static final int GRID_SIZE = 6;

  @Override
  public boolean applyRules(int[] a) {
    if( a == null || a.length > GRID_SIZE){
      throw new IllegalArgumentException();
    }
    boolean result = true;
    result &= EQ.apply(TIMES.apply(3, a[0]), TIMES.apply(2, a[3]));
    result &= EQ.apply(TIMES.apply(3, a[2]), TIMES.apply(2, a[4]));
    result &= EQ.apply(TIMES.apply(3, a[0]), TIMES.apply(4, a[4]));
    result &= GT.apply(a[1],a[5]);
    return result;
  }

  @Override
  public int size() {
    return GRID_SIZE;
  }
}
