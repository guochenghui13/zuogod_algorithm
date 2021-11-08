/**
 * @(#)MergeSort.java, 11月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class MergeSort {

    public int[] sortArray(int[] nums) {
        if(nums.length == 0 | nums.length == 1){
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int l, int r){
        if(l == r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l , mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int index = 0;
        int p = l;
        int q = mid + 1;

        while(p <= mid && q <= r){
            help[index++] = arr[p] > arr[q] ? arr[q++] : arr[p++];
        }

        while(p <= mid){
            help[index++] = arr[p++];
        }

        while(q <= r){
            help[index++] = arr[q++];
        }

        for(int i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }

    }
}