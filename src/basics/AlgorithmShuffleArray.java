/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author marco
 */
public class AlgorithmShuffleArray {
    public static Integer[] shuffleArray(Integer[] original, Integer[] random, int randomIndex) {
        if(original.length == 0) {
            return random;
        }
        ArrayList<Integer> list = new ArrayList(Arrays.asList(original));
        Random r = new Random();
        int originalIndex = 0;
        if(original.length > 1) {
            originalIndex = r.nextInt(original.length-1);
        }
        random[randomIndex] = original[originalIndex];
        list.remove(original[originalIndex]);
        Integer[] newOriginal = new Integer[list.size()];
        list.toArray(newOriginal);
        return shuffleArray((Integer[])newOriginal, random, randomIndex+1);
    }
    
    public static void main(String[] args) {
        Integer[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Original Array: ");
        for (int i = 0; i < original.length; i++) {
            System.out.print(" "+original[i]);
        }
        System.out.println("");
        Integer[] shuffledArray = shuffleArray(original, new Integer[original.length], 0);
        System.out.println("Shuffled Array: ");
        for (int i = 0; i < shuffledArray.length; i++) {
            System.out.print(" "+shuffledArray[i]);
        }
        System.out.println("");
    }
}
