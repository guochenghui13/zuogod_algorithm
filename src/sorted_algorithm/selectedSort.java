/**
 * @(#)selectedSort.java, 11月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class selectedSort {

    public int[] sortArray(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }

        for(int i = 0; i < nums.length -1; i++){
            int min = nums[i];
            int index = i;

            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }

            swap(nums, i, index);
        }
        return nums;

    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}