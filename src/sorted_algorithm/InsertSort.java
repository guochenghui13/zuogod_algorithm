/**
 * @(#)InsertSort.java, 11月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class InsertSort {

    public int[] sortArray(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = i -1; j >= 0 && nums[j] > nums[j + 1]; j--){
                swap(nums, j, j + 1);
            }
        }

        return nums;
    }


    public void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}