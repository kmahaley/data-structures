package edu.basic.preparation.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

            for (Integer child : graph.get(poll)) {

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

        Set<Integer> visited = new HashSet<>();
        graphDFSUtil(0, graph, visited);
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

        for (Integer child : graph.get(current)) {
            if (!visited.contains(child)) {

                graphDFSUtil(child, graph, visited);
            }

        }
    }

    /**
     * If directed graph contains cycle return true else false
     *
     * @param graph
     *
     * @return if cycle return true
     */
    public static boolean isCycleInDirectedGraph(Map<Integer, List<Integer>> graph) {

        final Set<Integer> toBeVisited = new HashSet<>();
        final Set<Integer> inProcess = new HashSet<>();
        final Set<Integer> visited = new HashSet<>();

        for (Integer key : graph.keySet()) {
            toBeVisited.add(key);
        }

        while (!toBeVisited.isEmpty()) {
            final Integer key = toBeVisited.iterator().next();

            if (isCycleInDirectedGraphDFS(key, toBeVisited, inProcess, visited, graph)) {
                return true;
            }
        }

        return false;

    }

    private static boolean isCycleInDirectedGraphDFS(Integer key, Set<Integer> toBeVisited, Set<Integer> inProcess,
            Set<Integer> visited,
            Map<Integer, List<Integer>> graph) {

        moveElementFromSetToSet(key, toBeVisited, inProcess);

        for (Integer child : graph.get(key)) {
            //visited node
            if(visited.contains(child))
                continue;

            //cycle
            if (inProcess.contains(child)) {
                return true;
            }

            //check for child
            if (isCycleInDirectedGraphDFS(child, toBeVisited, inProcess, visited, graph)) {
                return true;
            }
        }

        moveElementFromSetToSet(key, inProcess, visited);
        return false;

    }

    private static void moveElementFromSetToSet(Integer key, Set<Integer> toBeVisited, Set<Integer> inProcess) {
        toBeVisited.remove(key);
        inProcess.add(key);
    }

    /**
     * topological sort
     *
     * @param graph graph
     * @return stack
     */
    public static Stack<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {

        final Set<Integer> visited = new HashSet<>();
        final Stack<Integer> stack = new Stack<>();

        for (Integer key : graph.keySet()) {
            if (visited.contains(key)) {
                continue;
            }
            isTopologicalSortDFS(key, visited, stack, graph);
        }

        return stack;

    }

    private static void isTopologicalSortDFS(Integer key, Set<Integer> visited, Stack<Integer> stack,
            Map<Integer, List<Integer>> graph) {

        visited.add(key);

        for (Integer child : graph.get(key)) {
            if (visited.contains(child)) {
                continue;
            }
            isTopologicalSortDFS(child, visited, stack, graph);
        }
        stack.add(key);
    }

    /**
     * if cycle exists in undirected graph then true else false
     *
     * @param graph graph
     * @return boolean
     */
    public static boolean isCycleInUnDirectedGraph(Map<Integer, List<Integer>> graph) {
        final Set<Integer> visited = new HashSet<>();
        for (Integer key:graph.keySet()) {
            if (visited.contains(key))
                continue;
            if(isCycleInUnDirectedGraphDFS(key, null, visited, graph)){
                return true;
            }
        }
        return false;
    }

    private static boolean isCycleInUnDirectedGraphDFS(Integer key, Integer parent, Set<Integer> visited,
            Map<Integer, List<Integer>> graph) {

        visited.add(key);
        for (Integer child : graph.get(key)) {

            if (child == parent) {
                continue;
            }

            if (visited.contains(child)) {
                return true;
            }

            if (isCycleInUnDirectedGraphDFS(child, key, visited, graph)) {
                return true;
            }

        }
        return false;
    }

    /**
     * find if path exists from start to end
     *
     * @param start start node
     * @param end end node
     * @param graph graph
     * @return boolean
     */
    public static boolean isPathExists(int start, int end, Map<Integer, List<Integer>> graph){

        Set<Integer> visited = new HashSet<>();
        return isPathExistsDFS(start, end, visited, graph);
    }

    private static boolean isPathExistsDFS(int start, int end, Set<Integer> visited, Map<Integer, List<Integer>> graph) {

        visited.add(start);

        for (Integer child : graph.get(start)) {
            if(visited.contains(child))
                continue;

            if(child == end)
                return true;

            if(isPathExistsDFS(child, end, visited, graph))
                return true;
        }
        return false;
    }


    /**
     * Print path from start to end node
     * @param start start node
     * @param end end node
     * @param graph graph
     */
    public static void getPathFromSourceToDest(int start, int end, Map<Integer, List<Integer>> graph){

        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        int index = 0;

        getPathFromSourceToDestDFS(start, end, visited, path, index, graph);
    }

    private static void getPathFromSourceToDestDFS(int start, int end, Set<Integer> visited,
            List<Integer> path, int index,
            Map<Integer, List<Integer>> graph) {

        visited.add(start);
        path.add(index, start);
        index++;

        if(start == end){
            printPath(path, index);
        } else {
            for (Integer child : graph.get(start)) {
                if(visited.contains(child))
                    continue;

                getPathFromSourceToDestDFS(child, end, visited, path, index, graph);
            }
        }

    }

    private static void printPath(List<Integer> path, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(path.get(i)+" - ");
        }
        System.out.println();
    }


    /**
     * Print path from start to end node
     * @param start start node
     * @param graph graph
     */
    public static void getAllPathFromSource(int start, Map<Integer, List<Integer>> graph){

        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        int index = 0;

        getAllPathFromSourceDFS(start, visited, path, index, graph);
    }

    private static void getAllPathFromSourceDFS(
            int start, Set<Integer> visited, List<Integer> path, int index,
            Map<Integer, List<Integer>> graph) {

        visited.add(start);
        path.add(index, start);
        index++;

        final List<Integer> children = graph.get(start);
        if (children.isEmpty()) {
            printPath(path, index);
        } else {
            for (Integer child : children) {
                if (visited.contains(child)) {
                    continue;
                }
                getAllPathFromSourceDFS(child, visited, path, index, graph);
            }
        }
    }
}
