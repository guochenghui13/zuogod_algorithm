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

        System.out.println(getNextTens("101"));
    }

    public static String getNextTens(String str){
        int len = str.length();

        StringBuilder sb = new StringBuilder();

        long num = Long.parseLong(str.substring(0, (len + 1) / 2));

        if(Long.toString(num + 1).length() != Long.toString(num).length()){
            for(int i = 0; i < len + 1; i++){
                if(i == 0 || i == len){
                    sb.append(1);
                } else{
                    sb.append(0);
                }
            }
        }else{
            sb.append(num + 1);
            for(int i = (len + 1) / 2; i < len; i++){
                sb.append(sb.charAt(len - i - 1));
            }
        }
        return sb.toString();
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