package edu.basic.preparation.graph;

import java.util.ArrayList;
import java.util.HashMap;
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
     * Keep stack as path from first element and add child if parent exists in stack while exploring children
     * then cycle exists
     *
     * @param graph graph
     * @return boolean
     */
    public static boolean isCycleInDirectedGraphVersion2(Map<Integer, List<Integer>> graph) {

        Stack<Integer> st = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer ele : graph.keySet()) {

            if(visited.contains(ele)) {
                continue;
            }
            if(isCycleInDirectedGraphVersion2Helper(ele, st, visited, graph)) {
                System.out.println(st);
                return true;
            }
        }
        return false;
    }

//  Helper method
    private static boolean isCycleInDirectedGraphVersion2Helper(
            Integer ele,
            Stack<Integer> st, Set<Integer> visited, Map<Integer, List<Integer>> graph) {

        st.push(ele);
        visited.add(ele);

        for (Integer child : graph.get(ele)) {
            if (st.contains(child)) {
                return true;
            }

            if (visited.contains(child)) {
                continue;
            }

            if (isCycleInDirectedGraphVersion2Helper(child, st, visited, graph)) {
                return true;
            }
        }
        st.remove(ele);
        return false;
    }

    /**
     * topological sort
     * in u -> v, u comes before v
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

    /**
     * explode all children and then put parent in stack
     */
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
        for (Integer key : graph.keySet()) {
            if (visited.contains(key))
                continue;
            if (isCycleInUnDirectedGraphDFS(key, null, visited, graph)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycleInUnDirectedGraphDFS(Integer key, Integer parent, Set<Integer> visited,
                                                       Map<Integer, List<Integer>> graph) {
        visited.add(key);
        for (Integer child : graph.get(key)) {
            if (child.equals(parent)) {
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
     * find if path exists from start to end undirected graph
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


    /**
     *
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     */
    public static int numIslands(char[][] grid) {

        int count = 0;
        if(grid == null || grid.length == 0) {
            return count;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!visited[i][j] && grid[i][j] == '1') {
                    dfsNumIslands(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * @param i row
     * @param j col
     * @param grid matrix
     * @param visited visited matrix
     */
    private static void dfsNumIslands(int i, int j, char[][] grid, boolean[][] visited) {

        if (isValidInMatrix(i, j, grid) && !visited[i][j] && grid[i][j] == '1') {
            visited[i][j] = true;
            dfsNumIslands(i + 1, j, grid, visited); //below
            dfsNumIslands(i - 1, j, grid, visited); //above
            dfsNumIslands(i, j + 1, grid, visited); //right
            dfsNumIslands(i, j - 1, grid, visited); //left
        }

    }

    /**
     * Check if item belows to matrix
     */
    private static boolean isValidInMatrix(int i, int j, char[][] matrix) {
        return i >= 0 && i < matrix.length &&
                j >= 0 && j < matrix[0].length;
    }

    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * leave the border 0's untouched and its all connecting 0's
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     */
    public static void solve(char[][] board) {

        if( board == null || board.length == 0){
            return;
        }
        int length = board.length, width = board[0].length;

//        find border 'O', first and last column
        for (int i = 0; i < length ; i++) {
            if(board[i][0] == 'O') {
                dfsSolveBoard(i,0, board);//first column
            }
            if(board[i][width-1] == 'O') {
                dfsSolveBoard(i, width-1, board);// last column
            }
        }
//      find first and last row 'O'
        for (int j = 0; j < width; j++) {
            if(board[0][j] == 'O') {
                dfsSolveBoard(0, j, board);// first row
            }
            if(board[length-1][j] == 'O') {
                dfsSolveBoard(length-1, j, board);// last row
            }
        }
//      set matrix values to X if not #, and convert # to O
        for (int i = 0; i < length ; i++) {
            for (int j = 0; j < width; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * Set border O to # using dfs search
     */
    private static void dfsSolveBoard(int row, int col, char[][] board) {

        if(isValidInMatrix(row, col, board) && board[row][col] == 'O') {
            board[row][col] = '#';
            dfsSolveBoard(row-1, col, board);//above
            dfsSolveBoard(row+1, col, board);//below
            dfsSolveBoard(row, col-1, board);//left
            dfsSolveBoard(row, col+1, board);//right
        }
    }


    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
     * expressed as a pair: [0,1]
     *
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * topological sort and graph cycle.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) {
            return true;
        }
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        final Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edges : prerequisites) {

            if(map.containsKey(edges[0])) {
                map.get(edges[0]).add(edges[1]);
            } else {
               Set<Integer> set = new HashSet<>();
               set.add(edges[1]);
               map.put(edges[0], set);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for(Integer key : map.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            if(dfsCycleCheck(key, queue, visited, map, numCourses)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfsCycleCheck(
            Integer key, LinkedList<Integer> queue, Set<Integer> visited,
            Map<Integer, Set<Integer>> map, int numCourses) {

        if (queue.contains(key)) {
            return true;
        }
        queue.add(key);
        final Set<Integer> children = map.get(key);
        if (children != null && !children.isEmpty()) {

            for (Integer val : children) {
                if(visited.contains(val)) {
                    continue;
                }
                if (dfsCycleCheck(val, queue, visited, map, numCourses)) {
                    return true;
                }
            }
        }

        visited.add(key);
        queue.remove(key);
        if (visited.size() > numCourses) {
            return true;
        }
        return false;
    }

    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
     * expressed as a pair: [0,1]
     *
     * Input: 2, [[1,0],[0,1]]
     * Output: [], return list of courses students should take
     * topological sort and graph cycle.
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];

        for(int i=0; i< numCourses ;i++) {
            courses[i] =i;
        }
        if(numCourses <= 1) {
            return courses;
        }
        if(prerequisites == null || prerequisites.length == 0) {
            return courses;
        }
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i =0 ; i < numCourses ; i++) {
            map.put(i, new HashSet<Integer>());
        }

        for (int[] edges : prerequisites) {
            map.get(edges[0]).add(edges[1]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> visited = new Stack<>();

        for(Integer key : map.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            if(dfsfindOrder(key, queue, visited, map, numCourses)) {
                return new int[0];
            }
        }
        int i= numCourses-1;
        while(!visited.isEmpty()) {
            courses[i] = visited.pop();
            i--;
        }
        return courses;
    }

    public static boolean dfsfindOrder(
            Integer key, LinkedList<Integer> queue, Stack<Integer> visited,
            Map<Integer, Set<Integer>> map, int numCourses) {

        if (queue.contains(key)) {
            return true;
        }
        queue.add(key);
        final Set<Integer> children = map.get(key);
        if (children != null && !children.isEmpty()) {

            for (Integer val : children) {
                if (visited.contains(val)) {
                    continue;
                }
                if (dfsfindOrder(val, queue, visited, map, numCourses)) {
                    return true;
                }
            }
        }

        queue.remove(key);
        if (visited.size() > numCourses) {
            return true;
        }
        return false;
    }


    /**
     * Optimized solution referred from leet code
     *
     * create in degree array for the elements. If all element have in degree more than 0 then there are cycles
     * and course can't be completed. start with in degree zero and find all courses needed to complete that course.
     * Decrease dependent course indegree.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinishVersion2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (x == prerequisites[i][0]) {
                    final int dependentOnCourse = prerequisites[i][1];
                    inDegree[dependentOnCourse]--;
                    if (inDegree[dependentOnCourse] == 0)
                        queue.offer(dependentOnCourse);
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }


    public static class Employee {
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    /**
     * Importance of manager and all its subordinates
     *
     * mid, importance, list of subordinates
     *
     * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * Output: 11
     * @param employees [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]
     * @param id 1
     * @return 11
     */
    public static int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach( e -> map.put(e.id, e));

        return getImportanceOfManager(id, map);

    }

    private static int getImportanceOfManager(Integer id, Map<Integer, Employee> map) {

        int imp = map.get(id).importance;

        for(Integer i : map.get(id).subordinates) {
            imp += getImportanceOfManager(i, map);
        }

        return imp;
    }
}
