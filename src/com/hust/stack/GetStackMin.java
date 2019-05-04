package com.hust.stack;

import java.util.Stack;

public class GetStackMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetStackMin() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int node) {
        if (stackMin.isEmpty()){
            stackMin.push(node);
        } else if (node <= min()) {
            stackMin.push(node);
        }
        stackData.push(node);
    }

    public void pop() {
        //---注意判断栈空
        if (stackData.isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        Integer popValue = stackData.pop();
        if (popValue == min()){
            stackMin.pop();
        }

    }

    public int top() {
        //---注意判断栈空
        if (stackData.isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return stackData.peek();
    }

    public int min() {
        //---注意判断栈空
        if (stackMin.isEmpty()){
            throw  new RuntimeException("栈为空！");
        }
        return stackMin.peek();
    }
}
