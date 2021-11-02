/**
 * @(#)radixSort.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sorted_algorithm;

/**
 * @author guochenghui
 */
public class radixSort {

    public static void sort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0;
        int j = 0;
        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[r - l + 1];
        for (int d = 1; d <= digit; d++) {

            int[] count = new int[radix];
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 25, 64, 13};
        sort(arr, 0, arr.length - 1, 2);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}