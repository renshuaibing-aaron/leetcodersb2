package com.aaron.ren.nieke;

import java.util.Stack;

public class IsValid {

    public static void main(String[] args){
        IsValid solution = new IsValid();
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
    public boolean isValid (String s) {
        // write code here
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char item:chars){
            if(item=='('||item=='['||item=='{'){
                stack.push(item);
            }
            if(item==')'&&stack.peek().equals('(')){
                stack.pop();
            }
            if(item==']'&&stack.peek().equals('[')){
                stack.pop();
            }
            if(item=='}'&&stack.peek().equals('{')){
                stack.pop();
            }

        }

        return stack.isEmpty();
    }
}
