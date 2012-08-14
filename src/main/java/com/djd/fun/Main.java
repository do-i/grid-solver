package com.djd.fun;

import com.djd.fun.rules.impl.Apple7RuleImpl;
import com.djd.fun.rules.impl.Egg5RuleImpl;
import com.djd.fun.rules.impl.Orange6RuleImpl;
import com.djd.fun.rules.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOG = Logger.getLogger(Main.class.getName());
  public static void main(String... j) {
    long startTime = System.currentTimeMillis();
    List<Rule> rules = new ArrayList<Rule>();
    rules.add(new Orange6RuleImpl());
    rules.add(new Apple7RuleImpl());
    rules.add(new Egg5RuleImpl());

    loopRules(rules);
    LOG.log(Level.INFO, "Process Time: {0}", System.currentTimeMillis() - startTime);
  }

  private static void loop(List<String> possibilities, Rule rule) {
    for (String s : possibilities) {
      int[] intArray = NumberGenHelper.toIntArray(s);
      if (rule.applyRules(intArray)) {
        LOG.log(Level.INFO, "{0} solution found: {1}", new Object[]{rule, s});
      }
    }
  }

  private static void loopRules(List<Rule> rules) {
    for (Rule rule : rules) {
      List<String> possibilities = NumberGenHelper
          .generatePermutations(rule.size());
      LOG.log(Level.INFO, "possibilities: {0}", possibilities.size());
      loop(possibilities, rule);
    }
  }

}
