package com.hust.stack;

public class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        if (top>0){
            int last = stackLast(stack,top-1);
            top--;
            System.out.println("栈底元素："+last);
            System.out.println("元素个数："+top);
            reverseStackRecursively(stack,top);
            stack[top++]  = last;

        }
        return stack;
    }

    //获取并清除栈底元素
    private int stackLast(int[] stack,int top){
        if (top != -1){
            //出栈
            int pop = stack[top--];
            //如果栈空 返回栈底元素
            if (top == -1){
                return pop;
            }else {
                //否则递归查找栈底元素
                System.out.println("栈底过程"+pop);
                int last = stackLast(stack, top);
                stack[top++] = pop; //重新入栈-----注意此处top++则覆盖掉先前的栈底
                return last;
            }
        } else {
            throw  new RuntimeException("栈空！");
        }


    }


}
