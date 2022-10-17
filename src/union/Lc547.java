/**
 * @(#)Lc547.java, 6月 13, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package union;

/**
 * @author guochenghui
 */
class Lc547 {
    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int count = 0;
        int[] p = new int[n + 1];

        for(int i = 0; i < n; i++){
            p[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    System.out.println(i);
                    int a = find(p, i);
                    int b = find(p, j);

                    if(a != b){
                        p[a] = b;
                        count++;
                    }
                }
            }
        }

        return n - count;
    }

    public static int find(int[] p, int x){
        while(x != p[x]) p[x] = find(p, p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        int[][] data = {{1,1,0},{1,1,0},{0,0,1}};
        int     circleNum = Lc547.findCircleNum(data);
        System.out.println(circleNum);
    }
}