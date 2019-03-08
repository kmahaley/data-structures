package edu.basic.preparation.array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.google.gson.Gson;

public class Array {

    /**
     * Same solution can be applied to maximum/ minimum sum in an array.
     * also minimum/ maximum product in an array.
     *
     * MAX(max+ a[i], a[i])
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
     * Similar to find maximum sub array, use same technique to find minimum subarray.
     * example = {3, -4, 2, -3, -1, 7, -5}
     * ans = -6
     * {-4, 2, -3, -1}
     *
     * @param a
     * @return min
     */
    public static int findMinimumSubArrayInArray(int[] a) {
        int newMin = a[0];
        int min = a[0];

//      sub array last index, then you can subtract max - a[position] and position-1 till max==0
        int position = 0;

        for (int i = 1; i < a.length; i++) {
            newMin = Math.min(newMin + a[i], a[i]);
            min = Math.min(min, newMin);

        }
        return min;
    }


    /**
     * Largest sum contiguous increasing subarray
     * if [i+1] > [i] add them else current = [i+1]
     *
     * {2, 1, 4, 7, 3, 6}
     * {1, 4, 7} = 12
     *
     * https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/
     *
     * @param a
     * @return
     */
    public static int largestSumContiguousArray(int[] a) {

        int maxSum = a[0];
        int newSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i] > a[i-1]) {
                newSum = newSum + a[i];
                maxSum = Math.max(maxSum, newSum);
            } else {
                newSum = a[i];
            }
        }
        return maxSum;
    }

    /**
     * find longest increasing sub sequence in an array
     * @param a array {3,4,-1,0,6,2,3}
     *
     * @return length = 4
     * and sub sequence is {-1,0,2,3}
     */
    public static int longestCommonIncreasingSubSequence(int[] a) {

        int[] lengthArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            lengthArray[i] = 1;
        }
//      if j=4 then k =0 to 3
        int j = 1, max = lengthArray[j];
        while (j < a.length) {

            for (int k = 0; k < j; k++) {
                if (a[j] > a[k]) {
                    lengthArray[j] = lengthArray[k] + 1;
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
     * User picks 2 highest weighted stone,
     * if weights are equal they disintegrates
     * else smaller disintegrates and big one (big stone - small stone)
     *
     * 2,4,5 -> 1
     *
     * @param a list with stone weight
     * @return last stone or 0
     */
    public static int lastStoneWeight(List<Integer> a) {
        final IntComparator intComparator = new IntComparator();
        PriorityQueue<Integer> queue = new PriorityQueue<>(intComparator);
        queue.addAll(a);

        while (! queue.isEmpty() && queue.size() != 1) {
            final Integer big = queue.poll();
            final Integer small = queue.poll();
            if(big == small) {
                continue;
            } else {
                int remaining = big - small;
                queue.add(remaining);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();

    }

    public static class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }


    /**
     * arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
     * return = [3, 4, 5, 6, 7, 1, 2]
     *
     * @param array [1, 2, 3, 4, 5, 6, 7]
     * @param d rotate array by number
     */
    public static void rotateArrayAntiClockWise(int[] array, int d) {

        final int length = array.length;
        for (int i = 0; i < d; i++) {
            int temp = array[0];

            //should iterate less till one less than last element.
            for (int j = 0; j < length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[length - 1] = temp;
        }
    }

    /**
     * arr[] = {1, 2, 3, 4, 5}, d = 1
     * return = {5, 1, 2, 3, 4}
     *
     * @param array
     * @param d rotate array by number
     */
    public static void rotateArrayClockWise(int[] array, int d) {

        final int length = array.length;
        for (int i = 0; i < d; i++) {
            int temp = array[length-1];

            for (int j = length-1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }

    public static void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" - ");
        }
        System.out.println();
    }

    /**
     * Get movie titles sorted by year and then titles alphabetically.
     * select only those titles with poster "N/A"
     *
     * get movies from http get call and populate. use google gson library to map.
     *
     * @param substr
     * @return
     */
    static String[] getMovieTitles(String substr) {

        if (substr == null || substr.length() == 0) {
            return new String[0];
        }
        final List<Movie> movieList = new ArrayList<>();
        int start = 0, end = 0;
        do {
            start++;
            final PageResponse pageResponse = getData(substr, start);
            end = pageResponse.total_pages;
            if(pageResponse.data.size() > 0) {
                movieList.addAll(pageResponse.data);
            } else {
                break;
            }

        } while (start != end);

        final Iterator<Movie> iterator = movieList.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();

            if (movie.Poster.equals("N/A")){
                iterator.remove();
            }
        }

        movieList.sort(new MovieComparator());
        List<String> titles = new LinkedList<>();
        movieList.forEach(m -> titles.add(m.Title));
        final String[] toArray = titles.toArray(new String[titles.size()]);
        return toArray;
    }


    public static PageResponse getData(String subStr, int page) {
        PageResponse pageResponse = new PageResponse();
        HttpURLConnection connection = null;
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+subStr+"&page="+page;

        try {
            URL getUrl = new URL(url);
            connection = (HttpURLConnection) getUrl.openConnection();
            connection.setRequestMethod("GET");
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
            }
            final String response = content.toString();
            Gson gson = new Gson();
            return gson.fromJson(response, PageResponse.class);

        } catch (MalformedURLException ex) {
            System.out.println("Url if incorrect "+url);
        } catch (IOException ex) {
            System.out.println("Enable to read the response from get call");
        } finally {
            connection.disconnect();
        }
        return pageResponse;
    }

    public static class PageResponse {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<Movie> data;

        public PageResponse() {
        }

    }

    public static class Movie {
        String Title;
        String Poster;
        String Type;
        int Year;
        String imdbID;
    }

    public static class MovieComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie m1, Movie m2) {

            int yearCompare = m1.Year - m2.Year;
            if (yearCompare != 0) {
                return yearCompare;
            } else {
                return m1.Title.compareTo(m2.Title);
            }
        }
    }

    /**
     * Judge in town. Judge trusts no one and every one trusts judge
     *
     * @param N no of people
     * @param trust trust matrix
     * @return number
     *
     * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * Output: 3
     *
     * Judge will have inDegree  = N-1 and outDegree = 0
     */
    public static int findJudge(int N, int[][] trust) {

        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];

        for(int i=0; i < trust.length ; i++) {
            inDegree[trust[i][1]]++;
            outDegree[trust[i][0]]++;
        }

        int judge = -1;

        for(int i= 0; i < N+1 ; i++) {
            if(inDegree[i] == N-1 && outDegree[i] == 0) {
                judge= i;
            }
        }
        return judge;

    }

    /**
     * Find maximum profit when you can buy and sell stock only once
     * Start with first element of the stock array, keep track of profit and minimum stock price
     *
     * https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
     */
    public static int maximumProfit(int[] stock) {

        int result = 0;
        if(stock == null || stock.length == 0) {
            return result;
        }
        int min = stock[0];

        for (int i = 1; i < stock.length; i++) {
            result = Math.max(result, stock[i] - min);
            min = Math.min(min, stock[i]);

        }
        return result;
    }
}
