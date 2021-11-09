/**
 * @(#)Split_Wooden.java, 11月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package greed_question;

import java.util.PriorityQueue;

/**
 * @author guochenghui
 */
public class Split_Wooden {

    public int greed(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while(queue.size() > 1){
            cur = queue.poll() + queue.poll();
            sum = cur + sum;
            queue.add(cur);
        }

        return sum + queue.poll();
    }

}