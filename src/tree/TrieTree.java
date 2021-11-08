/**
 * @(#)TrieTree.java, 11月 08, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package tree;

import sun.text.normalizer.Trie;

/**
 * @author guochenghui
 */
public class TrieTree {

    TreeNode root;

    public TrieTree(){
        root = new TreeNode();
    }

    public void insert(String word){
        if(word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TreeNode node = root;
        int index = 0;

        for (char c : chars) {
            index = c - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TreeNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word){
        if(search(word) == 0){
            return;
        }

        char[] chars = word.toCharArray();
        TreeNode node = root;
        int index = 0;
        for (char c : chars) {
            index = c - 'a';
            if(--node.nexts[index].pass == 0) {
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    public int search(String word){
        if(word == null){
            return 0;
        }
        char[] chars = word.toCharArray();
        TreeNode node = root;
        int index = 0;

        for (char c : chars) {
            index = c - 'a';
            if(node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;

    }

    public int prefixNumber(String pre){
        if(pre == null){
            return 0;
        }

        char[] chars = pre.toCharArray();
        TreeNode node = root;
        int index = 0;

        for (char c : chars) {
            index = c - 'a';
            if(node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

}

class TreeNode{
    public int pass;
    public int end;
    public TreeNode[] nexts;

    public TreeNode(){
        nexts = new TreeNode[26];
    }
}