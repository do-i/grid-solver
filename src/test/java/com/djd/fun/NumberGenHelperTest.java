package com.djd.fun;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberGenHelperTest {

  @Test
  public void toIntArray(){
    int [] result = NumberGenHelper.toIntArray("12345");
    assertEquals(5, result.length);
  }

  @Test
  public void generatePermutations(){
    List<String> permutations = NumberGenHelper.generatePermutations(3);
    assertEquals(factorial(3), permutations.size());
  }

  @Test
  public void keep_unique_true(){
    assertTrue(NumberGenHelper.keep("12345"));
  }


  @Test
  public void keep_dupDigit_false(){
    assertFalse(NumberGenHelper.keep("12341"));
  }

  private int factorial(int n){
    if( n < 1){
      throw new IllegalArgumentException("n is too small.");
    }
    if( n==1){
      return n;
    }
    return n * factorial(n-1);
  }
}
