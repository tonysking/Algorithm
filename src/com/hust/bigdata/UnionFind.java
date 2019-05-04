package com.hust.bigdata;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class UnionFind {
    public static class Node {
        // 任何类型 string char int ...
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap; // Key : child , Value : father
        public HashMap<Node, Integer> sizeMap; // Node 所在集合的大小

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            // 初始化集合：各个节点自成一个集合
            for(Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        // 查找节点所在集合的代表节点head
        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father); // 将node到head链上所有节点的父节点都置为head
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                Integer aSetSize = sizeMap.get(aHead);
                Integer bSetSize = sizeMap.get(bHead);
                // 小集合并入大集合
                if (aSetSize < bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }

        }
    }

    public static void main(String[] args) {

    }
}
