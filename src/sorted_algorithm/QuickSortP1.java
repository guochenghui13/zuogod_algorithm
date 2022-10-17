/**
 * @(#)QuickSortP1.java, 2月 10, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class QuickSortP1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.findKthLargest(new int[]{2,1,5,6,4},2);

    }

}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int kSmall = nums.length - k ;

        while(l <= r){
            swap(nums, l + (int)(Math.random() * (r - l + 1)), r);
            int[] i = partition(nums, l, r);
            if(kSmall > i[0] && kSmall < i[1]){
                return nums[i[0] + 1];
            } else if(kSmall <= i[0]){
                r = i[0];
            } else if(kSmall >= i[1]){
                l = i[1];
            }
        }

        return -1;
    }


    public int[] partition(int[] nums, int l, int r){
        int less = l - 1;
        int more = r;
        int target = nums[r];
        int i = l;

        while(i < more){
            if(nums[i] < target){
                swap(nums, ++less, i++);
            } else if(nums[i] > target){
                swap(nums, --more, i);
            } else{
                i++;
            }
        }
        swap(nums, more, r);
        return new int[]{less, more + 1};
    }

    public void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}