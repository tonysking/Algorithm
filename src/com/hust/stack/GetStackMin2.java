package com.hust.stack;

import java.util.Stack;

public class GetStackMin2 {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        if (stackMin.isEmpty()){
            stackMin.push(node);
        } else if (node <= min()) {
            stackMin.push(node);
        } else {
            stackMin.push(min());//重复弹入 使两栈保持一致
        }
        stackData.push(node);
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
