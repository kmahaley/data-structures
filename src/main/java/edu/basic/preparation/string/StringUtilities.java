package edu.basic.preparation.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author km185223
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
     * @param str
     */
    public static void isStringUnique(String str) {

        final char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int k = 0;
        boolean isUnique = true;
        for (int i = 1; i < str.length(); i++) {
            if (chars[k] != chars[i]) {
                k++;
            } else {
                isUnique = false;
                break;
            }
        }
        if (isUnique) {
            System.out.println("String has unique characters");
        } else {
            System.out.println("String has no unique characters");
        }
    }
}


