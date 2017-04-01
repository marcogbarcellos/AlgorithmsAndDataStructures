/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author marco
 */
public class AlgorithmFindNextSmallestSameStringSet {
    public static String findNextSmallestSameStringSet(int number) {
        char[] numberArray = String.valueOf(number).toCharArray();
        int i;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(i=numberArray.length-1;i>0;i--) {
            pq.add(Character.getNumericValue(numberArray[i]));
            if(Character.getNumericValue(numberArray[i]) > 
               Character.getNumericValue(numberArray[i-1])){
                break; 
            }
        }
        if(i == 0) {
            return "NUMBER DOES NOT EXIST";
        }
        int temp = Character.getNumericValue(numberArray[i-1]);
        numberArray[i-1] = pq.poll().toString().charAt(0);
        pq.add(temp);
        for(int j=i;j<numberArray.length;j++) {
            numberArray[j] = pq.poll().toString().charAt(0);
        }
        return new String(numberArray);
    }
    
    public static void main(String[] args) {
        int number = 218765;
        System.out.print("the next smallest with same string set of the number "+number+" is: ");
        String nextSmallest = findNextSmallestSameStringSet(number);
        System.out.println(nextSmallest);
    }
}
