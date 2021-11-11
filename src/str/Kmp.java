/**
 * @(#)Kmp.java, 11月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package str;

/**
 * @author guochenghui
 */
class Kmp {
    //这段代码和暴力匹配类似，不过改变了回退。
    public static int kMP(String str, String sub) {
        //生成nextValue数组
        int[] next = generateNext(sub);
        int i = 0;
        int j = 0;
        //若str循环完毕，或者sub已经在str中出现就退出循环
        while (i < str.length() && j < sub.length()) {
            //若j==-1意味着直接从头开始匹配且当前str.charAt(i)必定不与sub.charAt(j)相同
            if (j == -1 || str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                //否则就进行指向sub的j回退，i保持原来位置
                j = next[j];
            }
        }
        if (j >= sub.length()) {
            return i - j;
        }
        return -1;
    }

    public static int[] generateNext(String sub) {
        int[] nextValue = new int[sub.length()];
        nextValue[0] = -1;
        nextValue[1] = 0;
        int i = 2;
        int k = 0;
        while (i < sub.length()) {
            if (k == -1 || sub.charAt(k) == sub.charAt(i - 1)) {
                nextValue[i] = k + 1;
                i++;
                k++;
            } else {
                k = nextValue[k];
            }
        }
        for (int j = 1; j < nextValue.length; j++) {
            if (sub.charAt(nextValue[j]) == sub.charAt(j)) {
                nextValue[j] = nextValue[nextValue[j]];
            }
        }
        return nextValue;
    }
}
