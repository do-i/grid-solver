package com.djd.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberGenHelper {
  private static final Logger LOG = Logger.getLogger(NumberGenHelper.class.getName());

  private static final int GRID_SIZE_MIN = 3;
  private static final int GRID_SIZE_MAX = 9;

  private NumberGenHelper() {
  }

  /**
   * result list size is gridSize! on the other words, gridSize factorial.
   * i.e., gridSize = 5 then 5! = 5 * 4 * 3 * 2 = 120.
   *
   * @param gridSize
   * @return permutations
   */
  public static List<String> generatePermutations(int gridSize) {
    if (gridSize < GRID_SIZE_MIN || gridSize > GRID_SIZE_MAX) {
      throw new IllegalArgumentException("Digits out of bounds.");
    }
    List<String> result = new ArrayList<String>();
    int start = startInt(gridSize);
    int end = endInt(gridSize);
    LOG.log(Level.INFO,"start={0}, end={1}", new Object[]{start, end});
    for (int i = start; i <= end; i++) {
      String textValue = String.valueOf(i);
      if (keep(textValue)) {
        result.add(textValue);
      }
    }
    return result;
  }

  /**
   * This is dumb way. And it works very inefficiently.
   *
   * @param gridSize
   * @return
   */
  private static int startInt(int gridSize) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= gridSize; i++) {
      sb.append(i);
    }
    return Integer.parseInt(sb.toString());
  }

  /**
   * This is dumb way. And it works very inefficiently.
   *
   * @param gridSize
   * @return
   */
  private static int endInt(int gridSize) {
    StringBuilder sb = new StringBuilder();
    for (int i = gridSize; i >= 1; i--) {
      sb.append(i);
    }
    return Integer.parseInt(sb.toString());
  }

  /**
   * If textValue contains duplicated digit, returns false. If textValue does
   * not contain all of 1,2,3,4,5 returns false. Otherwise returns true.
   *
   * @param textValue
   */
  static boolean keep(String textValue) {
    boolean[] bitMap = new boolean[textValue.length()];
    int[] intArray = toIntArray(textValue);
    for (int i = 0; i < intArray.length; i++) {
      int bitMapIndex = intArray[i] - 1; // -1 to adjust for 0 based
      // indexing
      if (0 <= bitMapIndex && bitMapIndex < bitMap.length) {
        bitMap[bitMapIndex] = true; // mark this bit.
      }
    }
    return allTrue(bitMap);
  }

  private static boolean allTrue(boolean[] bitMap) {
    for (boolean bit : bitMap) {
      if (!bit) {
        return false;
      }
    }
    return true;
  }

  public static int[] toIntArray(String textValue) {
    int[] intArray = new int[textValue.length()];
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = Character.digit(textValue.charAt(i), 10);
    }
    return intArray;
  }
}
