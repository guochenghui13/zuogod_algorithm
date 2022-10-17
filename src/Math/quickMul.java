/**
 * @(#)quickMul.java, 6月 04, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package Math;

/**
 * @author guochenghui
 */
public class quickMul {

    static int mul(int a, int b){
        int res = 0;
        while(b > 0){
            if((b & 1) == 1){
                res+= a;
            }
            b = b >> 1;
            a += a;
        }
        return res;
    }

    public static void main(String[] args) {
        quickMul quickMul = new quickMul();
        int      mul      = quickMul.mul(3, 5);
        System.out.println(mul);
        System.out.println("hello");
    }
}