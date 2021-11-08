/**
 * @(#)QuickSort.java, 11月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class QuickSort {


    public int[] sortArray(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int l , int r){
        if(l < r){
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l , r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public int[] partition(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;

        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr, l++, ++less);
            }else if(arr[l] > arr[r]){
                swap(arr, l, --more);
            }else if(arr[l] == arr[r]){
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1, more};
    }

    public void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}