package edu.basic.preparation.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

    /**
     * BFS
     *
     * @param start start of the traversal
     * @param graph graph
     */
    public static void graphBFS(Integer start, Map<Integer, List<Integer>> graph) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();
            System.out.println(poll);

            final List<Integer> children = graph.get(poll);
            for (Integer child : children) {

                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }

            }
        }
    }

    /**
     * DFS
     *
     * @param graph Graph
     */
    public static void graphDFS(Map<Integer, List<Integer>> graph) {

        graphDFSUtil(0, graph, new HashSet<>());
    }

    /**
     * DFS util
     *
     * @param current current node
     * @param graph graph
     * @param visited visited set to avoid cycle
     */
    public static void graphDFSUtil(Integer current, Map<Integer, List<Integer>> graph, Set<Integer> visited) {

        visited.add(current);
        System.out.println(current);

        final List<Integer> children = graph.get(current);
        for (Integer child : children) {

            graphDFSUtil(child, graph, visited);

        }
    }
}
