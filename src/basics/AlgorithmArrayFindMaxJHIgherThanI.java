/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 */
public class AlgorithmArrayFindMaxJHIgherThanI {
    public static int findMax(int[]arr, int i, int j, int maxValue) {
        if(i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            if ( arr[j]-arr[i] > maxValue ) {
                maxValue = arr[j]-arr[i];
            }
            int first = findMax(arr, i, j+1, maxValue);
            int second = findMax(arr, i+1, j+1, maxValue);
            if(first > second) {
                System.out.println("first:"+first);
                return first;
            } else {
                return second;
            }
        } else {
            return maxValue;
        }
    }
    public static void findMaxNonRecursive(int[]arr) {
        int maxValue = Integer.MIN_VALUE;
        int first = 0;
        int second = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if (arr[j]-arr[i]>maxValue) {
                   maxValue = arr[j]-arr[i];
                   first = i;
                   second = j;
                }
            }
        }
        System.out.println("i:"+first+" j:"+second+", maxValue:"+maxValue);
    }
    public static void main(String[] args) {
	
	int[] array = new int[]{-11, 4, 3, 0, 4, 8, 32}; // solution i=3; j=4
	int maxval = findMax(array, 0, 1, Integer.MIN_VALUE);
	System.out.println("maxval="+ maxval);
        findMaxNonRecursive(array);
	
    }
}
