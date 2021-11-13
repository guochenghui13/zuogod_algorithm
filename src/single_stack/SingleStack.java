/**
 * @(#)SingleStack.java, 11月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package single_stack;

import java.util.Stack;

/**
 * @author guochenghui
 */
public class SingleStack {

    public void nextGreatElement(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
    }

}