/**
 * @(#)ReverseStack.java, 12月 10, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package violence;

import java.util.Stack;

/**
 * @author guochenghui
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int tmp = f(stack);
        reverse(stack);
        stack.push(tmp);
    }

    public static int f(Stack<Integer> stack){
        int i = stack.pop();
        if(stack.isEmpty()){
            return i;
        }else {
            int last = f(stack);
            stack.push(i);
            return last;
        }
    }

}