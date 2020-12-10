package com.aaron.ren.leetcode20201031;

import java.util.Stack;

public class ValidateStackSequences {

    //判断栈的顺序  利用
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int j=0;
        Stack<Integer>  stack=new Stack<>();
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(j<popped.length&&!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }

        }
        return  j==popped.length;

    }
}
