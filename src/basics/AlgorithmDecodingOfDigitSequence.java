/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

/**
 *
 * @author marco
 * Input:  digits[] = "121" 121,1 21,12 1
 * Output: 3
 * The possible decodings are "ABA", "AU", "LA"
 *  Input: digits[] = "1234" 1234 12 3 4, 1 23 4
 *  Output: 3
 *  The possible decodings are "ABCD", "LCD", "AWD"
 *  Input: digits[] = "123456" 123456 12 3 4 5 6, 1 23 4 5 6, 
 *  Output: 3
 *  The possible decodings are "ABCD", "LCD", "AWD"
 */
public class AlgorithmDecodingOfDigitSequence {
    final static char[] digits = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                           'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                           'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static int countCombinations(int[] arr, int index) {
        if (index == 0 || index == 1)
            return 1;

        int count = 1;  // Initialize count with 1 because it counts the whole once

        // If the last digit is not 0, then last digit must add to
        // the number of words
        if (arr[index-1] > 0)
            count +=  countCombinations(arr, index-1);

        // If the last two digits form a number smaller than or equal to 26,
        // then consider last two digits and recur
        if (arr[index-2] < 2 || (arr[index-2] == 2 && arr[index-1] < 7) )
            count +=  countCombinations(arr, index-2);
        
        return count;

    }
    
    public static int findCombination(String original, String toCompare, LinkedList<String> queue){
        System.out.println("original:"+original);
        System.out.println("toCompare:"+toCompare);
        if(queue.peek() == null) {
            return 0;
        }
        toCompare+=queue.poll();
        if(original.equals(toCompare)){
            return 1 + findCombination(original, toCompare, queue)+ findCombination(original, "", queue);
        } else {
            return findCombination(original, toCompare, queue)+ findCombination(original, "", queue);
        }
    }
    
    public static void findOtherDigits(int[] numbers) {
        LinkedList<String> queue = new LinkedList();
        String original ="";        
        for (int i = 0; i<numbers.length; i++) {
            queue.add(String.valueOf(numbers[i]));
            if(i+1<numbers.length && numbers[i] <= 2 && numbers[i+1]<=6){
                queue.add(String.valueOf(numbers[i])+String.valueOf(numbers[i+1]));
            }
            System.out.print(digits[numbers[i]-1]);
            original+=String.valueOf(numbers[i]);
        }
        System.out.println(" ");
        int x = findCombination(original, "", queue);
        System.out.println("x:"+x);

    }
    
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int x = countCombinations(numbers,numbers.length-1);
        System.out.println("x:"+x);
    }
    
}
