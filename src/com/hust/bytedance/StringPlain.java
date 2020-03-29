package com.hust.bytedance;
import java.util.Scanner;
import java.util.Stack;

/**
 * 字节跳动2019夏令营笔试题第一轮
 * 编程3
 * 给定一个形如num%string#的字符串，将它展开，规则是string复写num次，允许嵌套
 */
public class StringPlain {
    private static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {

        // 直接测试
        String input1 = "3%g2%n##";
        String input2 = "3%acm#2%acm#";
        String s = readString(input2);
        System.out.println(s);

        // 手动输入测试
        Scanner sc = new Scanner(System.in);
        String inS = sc.nextLine();
        System.out.println(readString(inS));
    }
    // 栈方法
    public static String readString(String input) {
        char[] chars = input.toCharArray();
        StringBuilder solu = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#'){
                stack.push(chars[i]);
            } else {
                String repeat = ""; // 记录%到#之间的重复部分
                while (stack.peek()!='%') {
                    repeat += stack.pop();
                }
                stack.pop(); // 弹出%
                int count = stack.pop() - '0'; // 重复次数
                System.out.println("重复次数:"+count);
                // ------ 重复res自身count次千万不能用 res += res 这样会得到res * 2^count
                StringBuilder sb = new StringBuilder();
                while (count-- > 0){
                    sb.append(repeat);
                }
                System.out.println("重复后："+sb.toString());
                // 重新入栈
                char[] charArray = sb.toString().toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    stack.push(charArray[j]);
                }
            }

        }
        while (!stack.isEmpty()) {
            solu.append(stack.pop());
        }
        return solu.toString();

    }


   /*
     类似公式字符串的解法（递归）
     重点在于递归函数返回 递归结束的位置 以便继续遍历
    */

    public static String readString2(String input) {
        // 假设整体也是一个从 -1 到 input.length 重复一次的字符串：1% input #
        int begin = -1;
        int num = 1;
        return getString(input, begin, num).res;


    }

    // 每次递归的返回类型
    public static class returnType {
        String res; // 解析得到的字符串
        int end; // 递归结束的位置

        public returnType(String res, int begin) {
            this.res = res;
            this.end = begin;
        }
    }

    // begin % num 次数   计算字符串s从 %开始到#结束 重复num次的 递归函数
    public static returnType getString(String s, int begin, int num) {
        char[] chars = s.toCharArray();
        String res = "";
        returnType returnType;
        int end = 0; // 递归结束位置 '#'
        for (int i = begin+1; i < chars.length; i++) {
            if (i< chars.length-1 && chars[i+1] == '%') { // 遇到 % 开始递归
                returnType = getString(s, i+1, chars[i]-'0');
                i = returnType.end; // ---i从递归结束的地方继续遍历 由于for循环i会自动+1,故将从i+1开始读取
                System.out.println("遍历结束位置："+chars[i]);
                res += returnType.res; // 把递归得到的结果加进来
            } else if (chars[i] == '#'){ // 遇到 # 递归结束
                end = i;
                break;
            } else {
                res += chars[i];
            }
        }
        System.out.println("重复部分:"+res);
        System.out.println("重复次数："+num);
        StringBuilder sb = new StringBuilder();
        while (num-- > 0) {
            sb.append(res);
        }
        System.out.println("重复后部分"+sb.toString());
        return new returnType(sb.toString(), end);
    }
}
