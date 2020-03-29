package com.hust.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 公式字符串
 * exp = "48*((70-65)-43)+8*1, 返回-1816
 * exp = "3+1*4", 返回7
 * exp = "3+(1*4)", 返回7
 */
public class GetValueFromFormula {
  public int getValue(String exp) {
    return value(exp.toCharArray(), 0)[0];
  }

  private int[] value(char[] chars, int i) {
    Deque<String> deq = new LinkedList<>();
    // 保留之前的结果
    int pre = 0;
    // 保留（）中的结果
    int[] subRes = null;
    while (i < chars.length && chars[i] != ')') {
      // 遇到数字转换为int
      if (chars[i] >= '0' && chars[i] <= '9') {
        pre = pre * 10 + chars[i++] - '0';
      // 遇到 运算符 入队
      } else if (chars[i] != '(') {
        addNum(deq, pre); // 先入队数字
        deq.addLast(String.valueOf(chars[i++])); //再入队运算符
        pre = 0;
      // 遇到（ 递归求解
      } else {
        subRes = value(chars, i + 1);
        pre = subRes[0];
        i = subRes[1] + 1;
      }
    }
    addNum(deq, pre);
    // 最后栈中只有 数字和 +-，计算得出结果即可
    return new int[] {getNum(deq), i};
  }

  public void addNum(Deque<String> deq, int num) {
    if (!deq.isEmpty()) {
      int cur;
      // 通过判断 栈顶的运算符 选择入栈策略
      String top = deq.pollLast();
      if (top.equals("+") || top.equals("-")) {
        deq.addLast(top);
      } else {
        cur = Integer.valueOf(deq.pollLast());
        num = top.equals("*")? (cur * num) : (cur / num);
      }
    }
    deq.addLast(String.valueOf(num));
  }

  private int getNum(Deque<String> deq) {
    int res = 0;
    boolean add = true;
    String cur;
    int num;
    while (!deq.isEmpty()) {
      cur = deq.pollFirst();
      if (cur.equals("+")) {
        add = true;
      } else if (cur.equals("-")) {
        add = false;
      } else {
        num = Integer.valueOf(cur);
        res += add ? num : (-num);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    GetValueFromFormula getValueFromFormula = new GetValueFromFormula();
    String exp = "48*((70-65)-43)+8*1";
    String exp2 = "3+1*4";
    int res = getValueFromFormula.getValue(exp);
    System.out.println(res);
  }
}
