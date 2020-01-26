package edu.basic.preparation.array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import org.apache.commons.collections4.CollectionUtils;

import static edu.basic.preparation.string.StringUtilities.swapInteger;

public class Array {

    /**
     * Find maximum subarray value
     *
     * Same solution can be applied to maximum/ minimum sub array sum in an array.
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
     * maximum product in above array is 24, {-2,-3, 4}
     * another example  {2 ,-1, -3, 2, -1, 4, 3, -6},  maxSum= 8
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
     * find minimum subarray. Similar to find maximum sub array, use same technique.
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

    public static int findMaximumProductSubArrayInArray(int[] a) {
        int newsum = a[0];
        int max = a[0];

//      sub array last index, then you can subtract max - a[position] and position-1 till max==0
        int position = 0;

        for (int i = 1; i < a.length; i++) {
            newsum = Math.max(newsum * a[i], a[i]);
            int newMax = Math.max(max, newsum);

            if(newMax > max){
                max = newMax;
                position = i;
            }
        }
        return max;
    }


    /**
     * Largest sum contiguous INCREASING subarray
     * increasing sub array is important here
     *
     * if [i+1] > [i] add them else current = [i+1]
     *
     * https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/
     *
     * Input : arr[] = {2, 1, 4, 7, 3, 6}
     * Output : 12
     * Contiguous Increasing subarray {1, 4, 7} = 12
     *
     * Input : arr[] = {38, 7, 8, 10, 12}
     * Output : 38
     */
    public static int largestSumInIncreasingContiguousSubArray(int[] a) {

        int maxSum = a[0];
        int newSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
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
     *
     * you can maintain uniqueness by keeping set of integers which formed sum = 9
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
     * conditions
     * - if weights are equal they disintegrates
     * - else smaller disintegrates and big one (big stone - small stone)
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

            if(!big.equals(small)) {
                int remaining = big - small;
                queue.add(remaining);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();

    }

    /**
     * Comparator in descending order
     */
    public static class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
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
            //Save first element
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
        //Collections.sort(movieList, new MovieComparator());
        List<String> titles = new LinkedList<>();
        movieList.forEach(m -> titles.add(m.Title));
        final String[] toArray = titles.toArray(new String[titles.size()]);
        return toArray;
    }

    /**
     * Code to read from restful json call
     */
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
     * @param no no of people
     * @param trust trust matrix
     * @return number
     *
     * Input: no = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * [1,3] -> 1 trust 3, 1 --> 3
     * Output: 3
     *
     * Judge will have inDegree  = no-1 and outDegree = 0
     * if numbers don't start as 1,2,3,4, create map<integer,integer[0,1]>
     */
    public static int findJudge(int no, int[][] trust) {

        int[] inDegree = new int[no + 1];
        int[] outDegree = new int[no + 1];

        for (int i = 0; i < trust.length; i++) {
            inDegree[trust[i][1]]++;
            outDegree[trust[i][0]]++;
        }

        int judge = -1;
        for (int i = 0; i < no + 1; i++) {
            // all trust judge and judge don't trust anyone
            if (inDegree[i] == no - 1 && outDegree[i] == 0) {
                judge = i;
            }
        }
        return judge;
    }

    /**
     * Find maximum profit when you can buy and sell stock only once
     * Start with first element of the stock array, keep track of profit and minimum stock price
     *
     * [15, 25, 30, 5, 25]
     * profit = 20
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
            int currentMax = stock[i] - min;
            result = Math.max(result, currentMax);
            min = Math.min(min, stock[i]);

        }
        return result;
    }

    /**
     * Sample Example input: {{1, 2, 3}, {1}, {0, 0}}
     *
     * Output for the above input: {{1,1,0}, {1,1,0}, {2,1,0}, {2,1,0}, {3,1,0}, {3,1,0}}
     *
     * {{1,2} ,{3}, {4,5}
     *
     * 0
     * {1}
     *     1
     *     {1,3}
     *             2
     *             {1,3,4}
     *                     3 == termination
     *                     {1,3,4}
     *                         2
     *             {1,3,5}
     *                     3 == termination
     *                     {1,3,5}
     *
     * 0
     * {2}
     *     1
     *     {2,3}
     *             2
     *             {2,3,4}
     *                    3 == term
     *                    {2,3,4}
     *             2
     *             {2,3,5}
     *                    3 == term
     *                    {2,3,5}
     *
     * @param input array
     * @param n size
     * @param <T> type
     *
     * @return combinations
     */
    public static <T> List<List<T>> getAllCombinations(List<List<T>> input,int n){
        List<List<T>> resultList = new ArrayList<>();
        // Your implementation here

        int totalSize = input.size();
        List<T> ans = new ArrayList<T>();
        combinations(0, input, totalSize , ans, resultList );

        System.out.println("Total number of combinations:" + resultList.size());
        return resultList;
    }

    private static <T> void combinations(int listNo, List<List<T>> input, int totalSize, List<T> ans, List<List<T>> resultList) {

        if (listNo == totalSize) {
            List<T> newList = new ArrayList<>();
            // Collections.copy(ans, newList);
            for (int i = 0; i < listNo; i++) {
                newList.add(ans.get(i));
            }
            resultList.add(newList);

        } else {
            List<T> curr = input.get(listNo);

            for (int i = 0; i < curr.size(); i++) {
//                System.out.println(listNo+ "   -----    "+ curr.get(i));
                ans.add(listNo, curr.get(i));

                combinations(listNo + 1, input, totalSize, ans, resultList);

            }
        }
    }

    /**
     * Create subsets of the set
     * [1,2] -> {[], [1], [2], [1,2]}
     *
     * 2 raise to n subset. 3 elements -> subset size = 6, 4 elements -> subset size = 16
     * include element or not include element
     *
     * @param start list
     */
    public static void subset(List<Integer> start) {

        if(CollectionUtils.isEmpty(start)) {
            return;
        }
        List<List<Integer>> results = new ArrayList<>();
        helper(start, results, new ArrayList<Integer>(), 0);
        System.out.println(results);
    }

    private static void helper(List<Integer> input, List<List<Integer>> results, List<Integer> initial, int index) {

        if(index == input.size()) {
            results.add(initial);
        } else {
            helper(input, results, new ArrayList<>(initial), index + 1);
            final ArrayList<Integer> addTo = new ArrayList<>(initial);
            addTo.add(input.get(index));
            helper(input, results, addTo, index + 1);
        }

    }


    /**
     * Same as above but using array and index of the array
     */
    public static void subsetArray(int[] start) {
        if(start.length == 0) {
            return;
        }
        helperArray(start, new int[]{-1,-1}, 0);
    }

    private static void helperArray(int[] input, int[] initial, int index) {

        if (index == input.length) {
            for (int i = 0; i < input.length; i++) {
                System.out.print(initial[i] + " , ");
            }
            System.out.println();
        } else {
            // Don't add element
            initial[index] = -1;
            helperArray(input, initial, index + 1);

            //Add element
            initial[index] = input[index];
            helperArray(input, initial, index + 1);
        }
    }

//    public static void subsetArrayVersion2(List<Integer> start) {
//        if(start.isEmpty()) {
//            return;
//        }
//        List<List<Integer>> results = new ArrayList<>();
//        int index = 0;
//        Integer[] mid = new Integer[start.size()];
//
//        for (int i = 0; i < start.size(); i++) {
//
//            mid[index] = start.get(i);
//            addInResults(index, mid, results);
//            helperSubsetArrayVersion2(i+1, start, results, mid);
//        }
//        System.out.println(results);
//    }
//
//    private static void helperSubsetArrayVersion2(
//            int in, List<Integer> start, List<List<Integer>> results, Integer[] mid) {
//        if(in == start.size()) {
//            return;
//        } else {
//            mid[in] = start.get(in);
//            addInResults(in, mid, results);
//            helperSubsetArrayVersion2(in+1, start, results, mid);
//        }
//
//    }
//
//
//    private static void addInResults(int in, Integer[] mid, List<List<Integer>> results) {
//        List<Integer> finalList = new ArrayList<>();
//        for (int i = 0; i <= in; i++) {
//            finalList.add(mid[i]);
//        }
//        results.add(finalList);
//    }



    /**
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * @param s string
     *
     * O(n*n)
     */
    public static int lengthOfLongestSubstring(String s) {

        int count = 0;
        if (s.isEmpty()) {
            return count;
        }
        int maxCount = 1;
        for (int i = 1; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            final char c = s.charAt(i);
            set.add(c);
            count = 1;
            for (int j = i - 1; j >= 0; j--) {
                final char prev = s.charAt(j);
                if (!set.contains(prev)) {
                    set.add(prev);
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                } else {
                    count = 0;
                    set.clear();
                    break;
                }
            }
        }
        return maxCount;
    }

    /**
     * str= AABCDDBBBEA count= 3, BBB
     * build int array of same size and initialize with 1
     * iterate from 1 to size and compare prev character and update count in int array
     *
     * @param str string
     * @return count
     *
     * O(n)
     */
    public static int getLongestConsecutiveCharacters(String str) {

        if(str == null || str.isEmpty()) return 0;

        final int[] intArray = new int[str.length()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < str.length() ; i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if(prev == curr) {
                intArray[i] = intArray[i-1] + intArray[i];
            }
            if(intArray[i] > max){
                max = intArray[i];
            }
        }
        return max;

    }

    /**
     * reverse an signed integer and number should be beyond integer range.
     * x can be +ve or -ve
     */
    public static int reverse(int x) {

        long reverse = 0;
        while (x != 0) {
            int rem = x % 10;
            reverse = reverse * 10 + rem;
            x = x / 10;
        }
        //  integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
     * and return the new length. array should contain unique elements at the start.
     *
     * @param nums array
     * @return length
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

    public static void find3Numbers(int[] a, int length, int sum, List<List<Integer>> result) {

        for (int i = 0; i < length; i++) {
            // first element
            int first = a[i];
            //remaining sum
            int currSum = sum - first;
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();

            // find 2 element's sum which equals currSum
            for (int j = i + 1; j < length; j++) {
                int second = a[j];
                int remainder = currSum - second;

                if (map.containsKey(second)) {
                    final List<Integer> integerList = Arrays.asList(first, second, remainder);
                    System.out.println(set);
                    if(!set.containsAll(integerList)) {
                        set.addAll(integerList);
                        result.add(integerList);
                    }
                } else {
                    map.put(remainder, second);
                }
            }
        }
    }

    /**
     * Permutation of all quadruplets of array elements whose sum is target element
     *
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     *
     * @return permutations of array  eg. [-2,0,0,2],[-2,2,0,0],[0,0,-2,2],[0,2,-2,0]]
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        int start = 0;
        List<List<Integer>> result = new ArrayList<>();

        fourSumRecursive(nums, start, target, result);

        return result;
    }

    public static void fourSumRecursive(int[] nums, int start, int target, List<List<Integer>> result) {

        //if number of array elements are less than 4 (base condition)
        if (start == nums.length) {
            return;
        }
        // limiting number of elements to 4
        if (start == 4) {
            int sum = 0;
            final ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                sum = sum + nums[i];
                list.add(nums[i]);
            }

            if (sum == target) {
                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        } else {
            //generating permutation
            for (int i = start; i < nums.length; i++) {
                swapInteger(nums, start, i);
                fourSumRecursive(nums, start + 1, target, result);
                swapInteger(nums, start, i);
            }
        }
    }

    /**
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     *
     * Sliding Window Maximum problem
     */
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        //return size array
        int[] maxArray = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int limit = i + k - 1;
            int maxNumber = nums[i];

            for (int j = i; j <= limit ; j++) {

                int curr = nums[j];
                if(curr > maxNumber) {
                    maxNumber = curr;
                }
            }
            maxArray[i] = maxNumber;
        }

        return Arrays.stream(maxArray)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Sliding Window Maximum optimized solution
     * queue saves index
     * list saves maximum element
     * 1) first window
     * 2) start from second window to end of the array
     */
    public static List<Integer> maxSlidingWindow_Optimized(int[] nums, int k) {

        if (nums.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        // index of the nums to compare window size
        Deque<Integer> queue = new ArrayDeque<>();
        // first window of the array
        for (int i = 0; i < k; i++) {
            int curr = nums[i];
            // remove all elements from back when curr element is bigger
            while (!queue.isEmpty() && queue.peekLast() < curr) {
                queue.removeLast();
            }
            //add curr in queue
            queue.add(i);
        }
        List<Integer> list = new ArrayList<>();
        // start from second window ie. k
        for (int i = k; i < nums.length; i++) {
            int curr = nums[i];
            list.add(nums[queue.peek()]);

            // maintain current windows size
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.remove();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < curr) {
                queue.remove();
            }
            // add current index
            queue.add(i);
        }
        list.add(nums[queue.peek()]);
        return list;
    }

    //properties of XOR
    //a^a = 0, a^0 = a,


    /**
     * this is simple approach based on american coins system
     * find maximum coin number and keep decrementing. This approach fails if coins system is random
     * [1,3,4].Better approach is use of Dynamic programming
     *
     * @param amt 43
     * @param coins [1,5,10,25]
     * @return number of coins
     */
    public static int getNumberOfCoins(int amt, int[] coins) {
        int c = 0;
        while (amt > 0){
            int minDiff = Integer.MAX_VALUE;
            int curr = 0;
            // find maximum coin amount
            for (int i = 0; i < coins.length; i++) {
                int diff = amt - coins[i];
                if (diff < 0) {
                    continue;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    curr = coins[i];
                }
            }
            amt = amt - curr;
//            System.out.println(amt);
            c++;
        }
        return c;
    }
}
