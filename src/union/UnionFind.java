/**
 * @(#)UnionFind.java, 11月 10, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package union;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author guochenghui
 */
public class UnionFind<V> {
    public HashMap<V, Node<V>> elementMap;
    public HashMap<Node<V>, Node<V>> fatherMap;
    public HashMap<Node<V>, Integer> sizeMap;

    public UnionFind(List<V> list){
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();

        for (V v : list) {
            Node<V> element = new Node<V>(v);
            elementMap.put(v, element);
            fatherMap.put(element, element); // 每个节点指向自己
            sizeMap.put(element, 1); // 主要根节点的节点个数
        }
    }

    private Node<V> findHeader(Node<V> element){
        Stack<Node<V>> path = new Stack<>();
        while(element != fatherMap.get(element)){ // 循环找到一个只指向自己的节点
            path.push(element);
            element = fatherMap.get(element);
        }

        // 这时候的element就是父节点

        // 将路径上所有父亲节点指向element的父亲节点， 打破链式结构

        while(!path.isEmpty()){
            fatherMap.put(path.pop(), element);
        }

        return element;
    }

    public boolean isSameSet(V a, V b){
        if(elementMap.containsKey(a) && elementMap.containsKey(b)){
            return findHeader(fatherMap.get(a)) == findHeader(fatherMap.get(b));
        }
        return false;
    }

    public void union(V a, V b){
        if(elementMap.containsKey(a) && elementMap.containsKey(b)){
            Node<V> aF = findHeader(fatherMap.get(a));
            Node<V> bF = findHeader(fatherMap.get(b));

            if(aF != bF){ // 说明还没有进行组合
                Node<V> bigF = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF; // 数量多的根节点
                Node<V> smallF = bigF == aF ? bF : aF; // 数量少的根节点
                fatherMap.put(smallF, bigF); // 数量少的挂在数量多的下面
                sizeMap.put(bigF, sizeMap.get(bigF) + sizeMap.get(smallF));
                sizeMap.remove(smallF);
            }
        }
    }

}

class Node<T>{
    private T num;

    public Node(T num) {
        this.num = num;
    }
}