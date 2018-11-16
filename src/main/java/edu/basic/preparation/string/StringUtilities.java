package edu.basic.preparation.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author Kartik Mahaley
 */
public final class StringUtilities {

    /**
     * Find unique elements within window size
     *
     * @param a integer array
     * @param windowSize window size to find unique elements
     */
    public static void getDuplicateInArrayWindow(int a[], int windowSize) {
        Map<Integer, Integer> map = new HashMap<>();
        final int arrayLength = a.length;
        for (int k = 0; k < arrayLength; k++) {

            int distinctCount = 0;
            for (int i = k; i < k + windowSize; i++) {
                if(!map.containsKey(a[i])){
                    distinctCount++;
                    map.put(a[i],1);
                }
            }
            map.clear();
            System.out.println(distinctCount);
            if (k + windowSize == arrayLength) {
                break;
            }
        }

    }

    /**
     * Is string unique without any data structures
     *
     * @param str string
     */
    public static void isStringUnique(String str) {
        str ="appl";
        boolean isUnique = true;
        final char[] chars = str.toCharArray();

        //Method 1
        Arrays.sort(chars);
        int k = 0;

        for (int i = 1; i < str.length(); i++) {
            if (chars[k] != chars[i]) {
                k++;
            } else {
                isUnique = false;
                break;
            }
        }

        //Method 2
//        int[] intArray = new int[128];
//        for (char ch : chars) {
//            intArray[(int) ch]++;
//        }
//        for (int i = 0; i < intArray.length; i++) {
//            if (intArray[i] > 1) {
//                isUnique = false;
//            }
//        }

        if (isUnique) {
            System.out.println("String has unique characters");
        } else {
            System.out.println("String has no unique characters");
        }

    }


    /**
     * Make string urlify for eg. "Mr John Smith apple banana" -> "Mr%20John%20Smith%20apple%20banana"
     * @param str string
     * @param trueLength actual string length
     */
    public static void stringURLify(String str, int trueLength) {
        final int length = str.length();
        final char[] charArray = str.toCharArray();
        int spaceCounter = 0;
        //count spaces
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                spaceCounter++;
            }
        }
        //remove trailing spaces
        for (int i = length - 1; i >= trueLength; i--) {
            if (charArray[i] == ' ') {
                spaceCounter--;
            }
        }
        System.out.println("no of space : " + spaceCounter);
        //final array size
        int finalLength = trueLength + spaceCounter * 2;
        char[] finalArray = new char[finalLength];

        finalLength = finalLength - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                finalArray[finalLength] = '0';
                finalArray[finalLength - 1] = '2';
                finalArray[finalLength - 2] = '%';
                finalLength = finalLength - 3;
            } else {
                finalArray[finalLength] = charArray[i];
                finalLength--;
            }
        }
        System.out.println(new String(finalArray));

    }


    /**
     * Permutation of string is palindrome or not
     *
     * @param str String value
     */
    public static void isPermutationPalindrome(String str){

        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i< str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i),1);
            }
        }

        System.out.println(map);
        int count =0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()%2 ==1)
                count++;
        }
        System.out.println("permutation of string is palindrome : "+ (count<=1));
    }


    /**
     * Read file and print unique url with number of occurrence in file two.
     *
     * file two output is
     * yahoo.com 3
     * google.com 10
     * live.com 5
     *
     *
     * @param filename name of the file, file with list of urls duplicated
     */
    public static void fileReader(String filename) {
        String line = null;
        Map<String,Integer> map = new TreeMap<>();
        try
        {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                final String[] strings = line.split(" ");
                final String url = strings[0];
                if(url != null && !url.isEmpty()){
                    if(map.containsKey(url)){
                        final Integer integer = map.get(url);
                        map.put(url, integer+1);

                    } else{
                        map.put(url, 1);
                    }
                }
            }

            bufferedReader.close();

            FileWriter fileWriter = new FileWriter("records_"+filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String,Integer> entry : map.entrySet()){
                bufferedWriter.write(entry.getKey()+" "+entry.getValue()+"\n");
            }

            bufferedWriter.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error in reading file");
        }
    }


    /**
     * Given a string and list of indexes then find the closest similar character.
     * if similar character  not present in string then -1.
     * if two characters are same distance then take least index value [2,5] -> [2]
     *
     * apple ,list[1,4] -> [2,-1]
     * ababa, list[2,3] ->[0, 1]
     *
     * @param s String
     * @param queries number of index
     *
     * @return list with closest same character index
     */
    public static List<Integer> closest(String s, List<Integer> queries) {

        List<Integer> toReturnIndexList = new ArrayList<>();

        int querySize = queries.size();

        char[] stringArray = s.toCharArray();

        int leftDistance, rightDistance, j, k;

        for (int queryIndex = 0; queryIndex < querySize; queryIndex++) {

            Integer checkIndex = queries.get(queryIndex);
            leftDistance = -1;
            rightDistance = -1;
            j = checkIndex - 1;
            k = checkIndex + 1;

            char requiredChar = stringArray[checkIndex];

            while (j >= 0) {
                if (requiredChar == stringArray[j]) {
                    leftDistance = Math.abs(checkIndex - j);
                    break;
                }
                j--;
            }
            while (k < s.length()) {

                if (requiredChar == stringArray[k]) {
                    rightDistance = Math.abs(k - checkIndex);
                    break;
                }
                k++;
            }

            if (leftDistance == -1 && rightDistance == -1) {
                toReturnIndexList.add(-1);
            } else if (leftDistance == rightDistance) {
                toReturnIndexList.add(j);
            } else if (leftDistance == -1 && rightDistance != -1) {
                toReturnIndexList.add(k);
            } else {
                toReturnIndexList.add(j);
            }
        }


        return toReturnIndexList;

    }

    /**
     * Given two strings t is subsequence of the of string s then get list of missing string in t in same order
     *
     * s= I like banana
     * t= I
     * ans = like, banana
     *
     * s= lets go to the match in stadium
     * t= go match in
     * ans= lets, to, the, stadium
     *
     * @param s original string
     * @param t subsequence of the string
     *
     * @return list of missing strings in same order
     */
    public static List<String> missingWords(String s, String t) {
        List<String> toReturnList = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return toReturnList;
        }
        String regex = " ";
        final List<String> originalStrings = Arrays.asList(s.split(regex));
        if (t == null || t.length() == 0) {
            return originalStrings;
        }

        final List<String> subSequenceString = Arrays.asList(t.split(regex));

        int i = 0, j = 0;
        while (i < originalStrings.size()) {
            final String original = originalStrings.get(i);

            if (j < subSequenceString.size() && original.equals(subSequenceString.get(j))) {
                i++;
                j++;
                continue;
            }
            toReturnList.add(original);
            i++;
        }
        return toReturnList;
    }

//    another variation of above problem
    /**
     * stringValue = i love mango and apple
     * subString = love and
     * ans : [i, mango,  apple]
     *
     * @param stringValue initial string
     * @param subString substring of stringValue
     *
     * @return list containing missing words in subString
     */
    public static List<String> missingWordsInInitialString(String stringValue, String subString) {

        final String[] s1 = stringValue.split(" ");
        final String[] s2 = subString.split(" ");

        List<String> list = new ArrayList<>();
        int j = 0, i;
        for (i = 0; i < s1.length && j < s2.length; ) {
            if (s1[i].equals(s2[j])) {
                j++;
                i++;
                continue;
            } else {
                list.add(s1[i]);
                i++;
            }
        }
        while (i < s1.length) {
            list.add(s1[i]);
            i++;
        }
        return list;

    }

    /**
     * Find all permutation of a given integer array which are parity combination
     *
     * Parity means no two odd or even numbers are together.
     * 1,2,3,4 true
     * 1,3,2,4 false
     *
     * @param n integer number 1<= n <= 11
     * @return list of parity combination
     */
    public static List<List<Integer>> alternatingParityPermutations(int n) {
        int[] arrayOfInteger = new int[n];
        for (int i = 0; i < n ; i++) {
            arrayOfInteger[i] = i+1;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        permutationOfArray(arrayOfInteger, 0, permutations);

        List<List<Integer>> parityList = getParityList(permutations);

        return parityList;
    }

    /**
     *
     * @param num array
     * @param start start index
     * @param result permutations of array
     */
    public static void permutationOfArray(int[] num, int start, List<List<Integer>> result) {

        if (start >= num.length) {
            result.add(arrayToList(num));
        }

        for (int p = start; p <= num.length - 1; p++) {
            swapInteger(num, start, p);
            permutationOfArray(num, start + 1, result);
            swapInteger(num, start, p);
        }
    }

    /**
     * Array to list
     */
    public static ArrayList<Integer> arrayToList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    /**
     * Swap two numbers
     */
    public static void swapInteger(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     *
     * @param permutations permutations
     * @return parity list of numbers
     */
    private static List<List<Integer>> getParityList(List<List<Integer>> permutations) {
        List<List<Integer>> parityList = new ArrayList<>();
        for (List<Integer> list: permutations) {
            if(isParity(list)){
                parityList.add(list);
            }
        }
        return parityList;
    }

    /**
     * Parity means no two odd or even numbers are together.
     * 1,2,3,4 true
     * 1,3,2,4 false
     *
     * @param list is list parity
     * @return boolean
     */
    private static boolean isParity(List<Integer> list) {
        int j=0;
        boolean isOdd = list.get(0) % 2 == 1;
        for (int i = 1; i < list.size() && j< list.size() ;) {
            if(isOdd){
                if(isParityInOddNumberSeries(list.get(j), list.get(i))){
                    i++;
                    j++;
                    isOdd = false;
                } else {
                    return false;
                }
            } else {
                if(isParityInEvenNumberSeries(list.get(j), list.get(i))){
                    i++;
                    j++;
                    isOdd = true;;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * if number is odd and even
     *
     * @param odd number
     * @param even number
     * @return boolean
     */
    private static boolean isParityInOddNumberSeries(Integer odd, Integer even) {
        return odd %2 ==1 && even%2==0;
    }

    /**
     * if number are even and odd
     *
     * @param even number
     * @param odd number
     * @return boolean
     */
    private static boolean isParityInEvenNumberSeries(Integer even, Integer odd) {
        return odd %2 ==1 && even%2==0;
    }

    /**
     * Node class with X and Y coordinates in matrix
     */
    public static class Node {
        public int x;

        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * Convert list of string to matrix
     *
     * @param grid2 string [100,000,111]
     * @param row row length
     * @param col col length
     *
     * @return matrix [][]
     */
    private static int[][] createMatrix(List<String> grid2, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                matrix[i][j] = Character.getNumericValue(grid2
                        .get(i)
                        .charAt(j));
            }
        }

        return matrix;
    }

    /**
     * Given two string with 1's and 0's find number of regions in grid2 present in grid 1
     * regions are surrounded by 1's
     *
     * 001
     * 011
     * 100
     *
     * 001
     * 011
     * 100
     *
     * ans = 2
     *
     * @param grid1 list of strings with 1's and 0's
     * @param grid2 list of strings with 1's and 0's
     *
     * @return count number of overlapping regions
     */
    public static int countMatches(List<String> grid1, List<String> grid2) {

        if (grid1 == null || grid1.isEmpty()) {
            return 0;
        }

        int row1 = grid1.size();
        int col1 = grid1
                .get(0)
                .length();

        int[][] grid1Matrix = createMatrix(grid1, row1, col1);


        int row2 = grid2.size();
        int col2 = grid2
                .get(0)
                .length();

        int[][] grid2Matrix = createMatrix(grid2, row2, col2);

        List<List<Node>> listOfRegions1 = getListOfRegions(grid1Matrix, row1, col1);
        List<List<Node>> listOfRegions2 = getListOfRegions(grid2Matrix, row2, col2);


        int overlaps = isRegionsOverlap(listOfRegions1, listOfRegions2);
        return overlaps;

    }

    /**
     *
     * @param matrix marix of 1's and 0's
     * @param row row length
     * @param col col length
     * @return list of of all regions
     */
    public static List<List<Node>> getListOfRegions(int[][] matrix, int row, int col) {
        boolean[][] visited = new boolean[row][col];

        List<List<Node>> listOfRegions = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                final int current = matrix[i][j];
                if (current == 1 && !visited[i][j]) {

                    List<Node> region = BFS(matrix, i, j, visited);

                    if (!region.isEmpty()) {
                        listOfRegions.add(region);
                    }
                }
            }
        }
        return listOfRegions;
    }

    /**
     * Apply Breadth first search to get the nodes which form region
     *
     * @param grid2Matrix matrix
     * @param row row position
     * @param col col position
     * @param visited visited matrix
     *
     * @return region with list of nodes
     */
    private static List<Node> BFS(int[][] grid2Matrix, int row, int col, boolean[][] visited) {
        int rowBoundary[] = new int[]{
                -1,
                0,
                0,
                1
        };
        int colBoundary[] = new int[]{
                0,
                -1,
                1,
                0
        };

        List<Node> regionBoundary = new ArrayList<>();
        Node initial = new Node(row, col);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(initial);

        while (!queue.isEmpty()) {

            final Node polled = queue.poll();
            visited[polled.x][polled.y] = true;
            regionBoundary.add(polled);

            for (int k = 0; k < rowBoundary.length; k++) {
                int rowVal = polled.x + rowBoundary[k];
                int colVal = polled.y + colBoundary[k];

                if (isValid(grid2Matrix, rowVal, colVal, visited)) {
                    final Node newNode = new Node(rowVal, colVal);
                    if (!queue.contains(newNode)) {
                        queue.add(newNode);
                    }
                }
            }
        }

        return regionBoundary;
    }

    /**
     * If node value ==1 and visited = false, i and j are in boundry of the matrix
     *
     * @param grid2Matrix matrix
     * @param row row position
     * @param col col position
     * @param visited visited matrix
     *
     * @return boolean value
     */
    private static boolean isValid(int[][] grid2Matrix, int row, int col, boolean[][] visited) {

        final boolean isValid = (row >= 0 && row < grid2Matrix.length) &&
                (col >= 0 && col < grid2Matrix[0].length) &&
                (grid2Matrix[row][col] == 1 && !visited[row][col]);

        return isValid;
    }

    /**
     * @param listOfRegions1 list of regions from grid 1
     * @param listOfRegions1 list of regions from grid 2
     *
     * @return return overlapping region count
     */
    private static int isRegionsOverlap(List<List<Node>> listOfRegions1, List<List<Node>> listOfRegions2) {
        int count = 0;
        for (int i = 0; i < listOfRegions1.size(); i++) {
            final List<Node> regionList1 = listOfRegions1.get(i);

            boolean matched = listOfRegions2
                    .stream()
                    .filter(list -> list.size() == regionList1.size())
                    .anyMatch(listInTwo -> {
                        final boolean allMatch = listInTwo
                                .stream()
                                .allMatch(node -> regionList1.contains(node));
                        return allMatch;
                    });

            if (matched) {
                count++;
            }
        }

        return count;
    }

    /**
     * Check if number is palindrome
     *
     * @param n number
     * @return boolean
     */
    public static boolean isNumberPalindrome(int n) {
        if (n <= 0) {
            return false;
        }
        String str = String.valueOf(n);
        int i = 0, j = str.length() - 1;
        while (j > i) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    /**
     * Reverse string using recursion
     *
     * @param reverse reverse string
     * @param initial original string
     */
    public static void reverseString(String reverse, String initial){
        if (initial.length() == 0) {
            System.out.println(reverse);
            return;
        }

        reverseString(reverse + initial.charAt(initial.length()-1), initial.substring(0,initial.length()-1));
    }

    /**
     * get permutation of strings
     * @param prefix permutation of string
     * @param original original string
     */
    public static void permutationOfString(String prefix, String original) {
        final int length = original.length();

        if (length == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < length; i++) {
            permutationOfString(prefix + original.charAt(i), original.substring(0, i) + original.substring(i + 1));
        }
    }

    /**
     * Get substring of the orginal string
     * abc -> a,b,c,ab,bc,ca,abc
     *
     * @param original original string
     */
    public static void subStringsOfString(String original) {

        for (int i = 0; i < original.length() ; i++) {

            for (int j = i; j < original.length() ; j++) {

                String initial = original.substring(i, j+1);
                System.out.println(initial);
            }
        }
    }

    /**
     * Start permutation with intial index
     *
     * @param integerList list of integers
     * @param start start index
     */
    public static void permutationOfArray(List<Integer> integerList, int start) {

        for (int i = start; i < integerList.size(); i++) {

            Collections.swap(integerList, i, start);
            permutationOfArray(integerList, start + 1);
            Collections.swap(integerList, start, i);

        }

        if (start == integerList.size() - 1) {
            System.out.println(integerList);
        }
    }


}


