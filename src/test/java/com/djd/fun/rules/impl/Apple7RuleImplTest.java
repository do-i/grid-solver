package com.djd.fun.rules.impl;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 8/13/12
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Apple7RuleImplTest {
  @Test
   public void applyRules(){
    Apple7RuleImpl rule = new Apple7RuleImpl();
    assertTrue(rule.applyRules(new int[]{3,2,7,6,4,5,1}));
  }
}
