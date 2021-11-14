/**
 * @(#)StackTraversal.java, 11月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package tree;

import netscape.security.UserTarget;

import java.util.Stack;
import java.util.concurrent.locks.StampedLock;

/**
 * @author guochenghui
 */
public class StackTraversal {

    public static void preTraversal(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val + " ");
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }
        }
    }

    public static void inTraversal(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val + " ");
                stack.push(root.right);
            }
        }
    }

    public static void poTraversal(Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            help.push(root);
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        while(!help.isEmpty()){
            System.out.println(help.pop() + " ");
        }
    }



}