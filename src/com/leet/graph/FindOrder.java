package com.leet.graph;

import java.util.*;

/**
 * n 门课需要选，记为 0 到 n-1。
 * 先修课程：想学课程 0 ，需要先完成课程 1 ，表示为: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * eg:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1]
 */
public class FindOrder {
    // 存储有向图(key为先修课程，value为以key为先修课程的课程)
    Map<Integer, List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n - 1 为栈底，0 为栈顶 (倒着入栈, 最后入栈的为最先的先修课程)
    int[] result;
    int top;
    // 判断有向图中是否有环
    boolean invalid;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        result = new int[numCourses];
        top = numCourses - 1;

        edges = new HashMap<>(numCourses);
        // 初始化邻接表
        for (int[] info : prerequisites) {
            List<Integer> list = edges.getOrDefault(info[1], new ArrayList<>());
            list.add(info[0]);
            edges.put(info[1], list);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && !invalid; i++) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        if (invalid) {
            return new int[0];
        }
        return result;
    }

    private void dfs(int i) {
        // 将节点标记为「搜索中」
        visited[i] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        List<Integer> list = edges.get(i);
        if (list != null) {
            for(Integer edge : list) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[edge] == 0) {
                    dfs(edge);
                    if (invalid) {
                        return;
                    }
                    // 如果「搜索中」说明找到了环
                } else if (visited[edge] == 1) {
                    invalid = true;
                    return;
                }
            }
        }
        // 将节点标记为「已完成」
        visited[i] = 2;
        // 将节点入栈
        result[top--] = i;
    }

    public static void main(String[] args) {
        FindOrder res = new FindOrder();
        int[][] prerequisites = {{1,0}};
        int[] order = res.findOrder(2, prerequisites);
        Arrays.stream(order).forEach(System.out::println);
    }
}
