package com.djd.fun.rules;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelationalOperatorTest {

  @Test
  public void eq() {
    assertTrue(RelationalOperator.EQ.apply(1, 1));
  }

  @Test
  public void gt() {
    assertTrue(RelationalOperator.GT.apply(8, 1));
  }

  @Test
  public void lt() {
    assertTrue(RelationalOperator.LT.apply(1, 2));
  }

  @Test
  public void nq() {
    assertTrue(RelationalOperator.NQ.apply(4, 2));
  }
}
