/**
 * @(#)StoneGame.java, 12月 10, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package violence;

/**
 * @author guochenghui
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int i = 0; i < piles.length; i++){
            sum = sum + piles[i];
        }
        int first = f(piles, 0, piles.length - 1);
        return first > (sum - first);
    }

    public int f(int[] piles, int l , int r){
        if(l == r){
            return piles[l];
        }

        return Math.max(piles[l] + s(piles, l + 1, r), piles[r] + s(piles, l , r - 1));
    }

    public int s(int[] piles, int l, int r){
        if(l == r){
            return 0;
        }

        return Math.min(f(piles, l + 1, r), f(piles, l, r - 1));
    }
}