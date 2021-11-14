/**
 * @(#)NormalTree.java, 11月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package tree;

/**
 * @author guochenghui
 */
public class NormalTree {

    public void process(Node root){
        if(root == null){
            return;
        }

        // 1

        process(root.left);

        // 2

        process(root.right);

        //3

    }


}

class Node{
    public int val;
    public Node left;
    public Node right;
}