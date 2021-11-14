/**
 * @(#)MorrisTraversel.java, 11月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package tree;

/**
 * @author guochenghui
 */
public class MorrisTraversal {

    // 有左子树的节点能会到该节点2次
    public static void morrisProcess(Node root){
        if(root == null){
            return;
        }

        Node cur = root;
        Node mostRight = null;

        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisInProcess(Node root){
        if(root == null){
            return;
        }

        Node cur = root;
        Node mostRight = null;

        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight = null;
                }
            }
            // 第二次回到
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void morrisPreProcess(Node root){
        if(root == null){
            return;
        }

        Node cur = root;
        Node mostRight = null;

        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null) {
                while (mostRight != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    // 第一次碰到节点的时候
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                }
            } else{
                // 这里要有else判断，没子树进行打印
                System.out.print(cur.val + " ");
            }
            // 能回到自己两次的节点
            cur = cur.right;
        }

    }

    /**
     *  1. 回到自己两次节点， 并且第二次回到自己， 逆序打印自己左树的右边界
     *  2. 前面遍历完了之后， 单独打印整个树的右边界， 逆序
     * @param root
     */
    public static void morrisPostProcess(Node root){
        if(root != null){
            return;
        }

        Node cur = root;
        Node mostRight = null;

        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight = null;
                }
            }
            // 第二次回到的节点， 逆序打印自己的左子树的右节点们
            printEdge(cur.left);
            cur = cur.right;
        }
        // 打印根节点的那些右节点了
        printEdge(root);
    }

    public static Node reverse(Node from){
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void printEdge(Node node){
        Node tail = reverse(node);
        Node cur = tail;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverse(tail);
    }




}

