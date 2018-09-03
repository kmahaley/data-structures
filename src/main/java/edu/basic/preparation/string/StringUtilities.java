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
}


