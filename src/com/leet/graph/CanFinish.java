package com.leet.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 */
public class CanFinish {
    private static final int UN_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    int[] visited;
    boolean valid = true;
    Map<Integer, List<Integer>> edgeMap;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edgeMap = new HashMap<>();
        for (int[] c: prerequisites) {
            List<Integer> cList = edgeMap.getOrDefault(c[1], new ArrayList<>());
            cList.add(c[0]);
            edgeMap.put(c[1], cList);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == UN_VISITED) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = VISITING;

        List<Integer> list = edgeMap.get(i);
        if (list != null) {
            for(Integer edge : list) {
                if(visited[edge] == UN_VISITED) {
                    dfs(edge);
                    if(!valid) {
                        return;
                    }
                } else if (visited[edge] == VISITING) {
                    valid = false;
                    return;
                }
            }
        }

        visited[i] = VISITED;
    }
}
