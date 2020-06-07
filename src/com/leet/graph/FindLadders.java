package com.leet.graph;

import java.util.*;

/**
 * 126. 单词接龙 II
 */
public class FindLadders {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId;
    private ArrayList<String> idWord;
    private ArrayList<Integer>[] edges;

    public FindLadders() {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }

        if (!wordId.containsKey(endWord)) {
            return  new ArrayList<>();
        }

        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord);
        List<List<String>> res = new ArrayList<>();
        // 到每个点的代价
        int[] cost = new int[id];
        for (int i = 0; i < id; i++) {
            cost[i] = INF;
        }

        // 队列的每一个节点中保存从起点开始的所有路径。
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        // 将起点加入队列 并将其cost设为0
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // bfs
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index));
                }
                res.add(tmp);
            } else {
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp);
                    }
                }
            }
        }

        return res;
    }

    private boolean transformCheck(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
