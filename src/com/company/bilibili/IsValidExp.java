package com.company.bilibili;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配是否合法
 */
public class IsValidExp {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     * chars[i] == '(' || chars[i] == '{' || chars[i] == '['
     */
    private Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };
    public boolean IsValidExp (String s) {
        // write code here
        if(s == null) {
            return false;
        }
        if(s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty()) {
                if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                    return false;
                }
                stack.push(chars[i]);
            } else {
                if(chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                    if(map.getOrDefault(stack.peek(), 'e') == chars[i]) {
                        stack.pop();
                    } else {
                        stack.push(chars[i]);
                    }
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValidExp res = new IsValidExp();
        boolean b = res.IsValidExp("([)]");
        System.out.println(b);
    }
}
