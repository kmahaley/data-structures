package edu.basic.preparation.array;


import java.util.HashMap;
import java.util.Map;

public class Array {

    /**
     * Same solution can be applied to maximum/ minimum sum in an array.
     * also minimum/ maximum product in an array.
     *
     * @param a array  {-2, -3, 4, -1, -2, 1, 5, -3}
     * @return maximum 7
     *
     * sub array would be {4, -1, -2, 1, 5}, position is maintained,
     * while (max!= 0) {
     *     (max - a[pos])
     * }
     */
    public static int findMaximumSubArrayInArray(int[] a) {
        int newsum = a[0];
        int max = a[0];

//      sub array last index, then you can subtract max - a[position] and position-1 till max==0
        int position = 0;

        for (int i = 1; i < a.length; i++) {
            newsum = Math.max(newsum + a[i], a[i]);
            int newMax = Math.max(max, newsum);

            if(newMax > max){
                max = newMax;
                position = i;
            }
        }
        return max;
    }

    /**
     * find longest increasing sub sequence in an array
     * @param a array {3,4,-1,0,6,2,3}
     *
     * @return length =4
     * and sub sequence is {-1,0,2,3}
     */
    public static int longestCommonIncreasingSubSequence(int[] a) {

        int[] lengthArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            lengthArray[i] = 1;
        }
//      if j=4 then k =0 to 3
        int j = 1, max = a[j];
        while (j < a.length) {

            for (int k = 0; k < j; k++) {
                if (a[j] > a[k]) {
                    lengthArray[j] = lengthArray[k] + 1;
                    k++;
                    if (max < lengthArray[j]) {
                        max = lengthArray[j];
                    }
                }
            }
            j++;

        }
        return max;
    }


    /**
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length ;i++) {
            int curr = nums[i];
            int req = target - curr;

            if(map.containsKey(curr)) {
                return new int[]{map.get(curr),i};
            }
            map.put(req, i);
        }

        throw new IllegalArgumentException("No two sum solution");
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
                    dfs(i, j, grid, visited);
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
    private static void dfs(int i, int j, char[][] grid, boolean[][] visited) {

        if (isValidInGrid(i, j, grid, visited) && !visited[i][j] && grid[i][j] == '1') {
            visited[i][j] = true;
            dfs(i + 1, j, grid, visited); //below
            dfs(i - 1, j, grid, visited); //above
            dfs(i, j + 1, grid, visited); //right
            dfs(i, j - 1, grid, visited); //left
        } else {
            return;
        }

    }

    /**
     * Check if item belows to matrix
     */
    private static boolean isValidInGrid(int i, int j, char[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length &&
                j >= 0 && j < grid[0].length;
    }
}
