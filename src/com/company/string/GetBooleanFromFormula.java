package com.company.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 美团2020
 * 链接：https://www.nowcoder.com/questionTerminal/e06d50b938d24a2b8a2c14edebee5478
 * 来源：牛客网
 *
 * 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，布尔求值，
 * 计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。
 * 注意：
 * and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
 */
public class GetBooleanFromFormula {
  /*
    1.根据栈顶的运算符判断，
    ---优先级高的运算符（and）计算出结果入栈
    ---值（true/false）和优先级低的运输符（or）入栈
    2.计算栈中结果

   */
  public String getValue(String exp) {
    String[] s = exp.split(" ");
    if (s.length == 1) {
      if (s[0].equals("and") || s[0].equals("or")) {
        return "error";
      } else {
        return s[0];
      }
    }
    Stack<String> stack = new Stack<>();
    int i = 0;
    String top;
    while (i < s.length) {
      if (!stack.isEmpty()) {
        top = stack.pop();
        // 栈顶是and则取出前一个值计算
        if (top.equals("and")) {
          String pre = stack.pop();
          // 非法判断
          if (!checkExp(pre) || !checkExp(s[i])) {
            return "error";
          }
          s[i] = pre.equals(s[i]) ? s[i] : "false"; // 注意： false and false结果为false
        // or
        } else if (top.equals("or")){
          // 非法判断
          String pre = stack.peek();
          if (!checkExp(pre) || !checkExp(s[i])) {
            return "error";
          }
          stack.push(top);
        // true或false
        } else {
          // 非法判断
          if (!checkBoolean(s[i]) || (i == s.length - 1 && !checkExp(s[i]))) {
            return "error";
          }
          stack.push(top);
        }
      }
      stack.push(s[i++]);
    }
    // 从只有true, false, or的栈中得出结果
    return getBooleanRes(stack);
  }

  private boolean checkExp(String exp) {
    if (exp.equals("and") || exp.equals("or")) {
      return false;
    }
    return true;
  }

  private boolean checkBoolean(String boo) {
    if (boo.equals("true") || boo.equals("false")) {
      return false;
    }
    return true;
  }

  private String getBooleanRes(Stack<String> stack) {
    String top;
    Boolean res = false;
    while (!stack.isEmpty()) {
      top = stack.pop();
      if (top.equals("true")) { // 可优化：只要有一个true直接返回true，遍历完没有返回false
        res = true;
      } else if (top.equals("false")) {
        res = res || false;
      }
    }
    return res ? "true" : "false";
  }

  public static void main(String[] args) {
    GetBooleanFromFormula getBooleanFromFormula = new GetBooleanFromFormula();
    String exp = "true or false and false";
    String exp2 = "true and false";
    String exp4 = "true";
    String err1 = "and";
    String err2 = "true true";
    String err3 = "true or false or or";
    String err4 = "true or false or";
    String res = getBooleanFromFormula.getValue(exp);
    System.out.println(res);

   /* Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(getBooleanFromFormula.getValue(s));*/
  }
}
