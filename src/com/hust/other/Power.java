package com.hust.other;

/**
 *给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。保证base和exponent不同时为0
 */
public class Power {
  public double Power(double base, int exponent) {
    if(exponent == 0) {
      return 1;
    }
    double cur = base;
    double res = 1;
    boolean isNeg = exponent > 0 ? false : true;
    if (isNeg) {
      exponent = -exponent;
    }
    // 注意循环条件是 > 1，要是 > 0就会多计算一次
    while (exponent > 1) {
      cur *= cur;
      if (exponent % 2 != 0) { // e & 1 == 1
        res = res * base;
      }
      exponent /= 2;
    }
    res = res * cur;
    return isNeg? 1/res : res;
  }

  public static void main(String[] args) {
    Power power = new Power();
    double res = power.Power(2, 3);
    System.out.println(res);
  }
}
