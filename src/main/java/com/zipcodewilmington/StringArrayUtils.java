package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(int i = 0; i < array.length; i++){
            if(array[i].equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] s = new String[array.length];
        int j = 0;
        for(int i = array.length-1; i >= 0 ; i--){
            s[j] = array[i];
            j++;
        }
        return s;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] rev = reverse(array);
        for(int i = 0 ; i < array.length; i++){
            if(!array[i].equalsIgnoreCase(rev[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(String arr : array){
            String[] s = arr.toLowerCase().split("");
            for(String c : s){
                if(alphabet.contains(c)){
                    alphabet = alphabet.replace(c,"");
                }
            }
        }
        if(alphabet.length()==0){
            return true;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for(String arr : array){
            if(arr.equals(value)){
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int numOcrn = getNumberOfOccurrences(array,valueToRemove);
        String[] s = new String[array.length-numOcrn];
        int index = 0;
        for(String arr : array){
            if(!arr.equals(valueToRemove)){
                s[index] = arr;
                index++;
            }
        }
        return s;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        StringBuilder sb = new StringBuilder("");
        for(int i  = 0; i < array.length-1; i++){
            if(!array[i].equals(array[i+1])){
                sb.append(array[i]);
                sb.append(","); //to used as delimiter
            }
        }
        sb.append(array[array.length-1]); //to append last element

        return sb.toString().split(",");
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        StringBuilder sb = new StringBuilder("");
        sb.append(array[0]);
        String cur = array[0];
        for(int i  = 1; i < array.length; i++){
            if(array[i].equalsIgnoreCase(cur)){
                sb.append(array[i]);
            } else {
                sb.append(","); //to used as delimiter
                cur = array[i];
                sb.append(array[i]);
            }

        }
        System.out.println(sb);
        return sb.toString().split(",");
    }
}
