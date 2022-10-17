/**
 * @(#)code315.java, 5月 23, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package questions;
import java.util.List;

import java.util.ArrayList;

/**
 * @author guochenghui
 */
class code315 {

    public static void main(String[] args) {
        code315 code315 = new code315();
        int[] test = {1, 2, 0};
        List<Integer> integers = code315.countSmaller(test);
        System.out.println(integers);
    }

    int[] res = null;
    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0 && nums.length ==1){
            return list;
        }
        mergeSort(nums, 0, nums.length - 1);
        for(int i = 0; i < res.length; i++){
            list.add(res[i]);
        }
        return list;
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l == r){
            return;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int p = 0;
        int p1 = l;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= r){
            if(nums[p1] <= nums[p2]){
                res[p1] += p2 - (mid + 1);
                help[p++] = nums[p1++];
            } else{
                help[p++] = nums[p2++];
            }

        }

        while(p1 <= mid){
            res[p1] += p2 - (mid + 1);
            help[p++] = nums[p1++];
        }

        while(p2 <= r){
            help[p++] = nums[p2++];
        }

        for(int i = l; i <= r; i++){
            nums[i] = help[i-l];
        }
    }
}