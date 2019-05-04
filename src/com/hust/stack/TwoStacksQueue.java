package com.hust.stack;

import java.util.Stack;

public class TwoStacksQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    private void pushToPop(){
        //只有stackPop为空时才压入
        if (stackPop.empty()){
            //一次压入全部stackPush
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void push(int node) {
        stackPush.push(node);
    }

    public int pop() {
        pushToPop();
        return stackPop.pop();
    }
}
