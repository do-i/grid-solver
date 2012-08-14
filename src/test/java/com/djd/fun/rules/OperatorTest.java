package com.djd.fun.rules;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class OperatorTest {

  @Test
  public void plus() {
    assertEquals(2, Operator.PLUS.apply(1, 1));
  }

  @Test
  public void minus() {
    assertEquals(7, Operator.MINUS.apply(8, 1));
  }

  @Test
  public void times() {
    assertEquals(4, Operator.TIMES.apply(4, 1));
  }

  @Test
  public void divide() {
    assertEquals(2, Operator.DIVIDE.apply(4, 2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void divide_byZero() {
    Operator.DIVIDE.apply(4, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void divide_byNegativeZero() {
    Operator.DIVIDE.apply(4, -0);
  }
}
