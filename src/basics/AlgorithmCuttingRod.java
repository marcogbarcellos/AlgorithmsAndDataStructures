/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * Given a rod of length n inches and an array of prices that contains prices 
 * of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the 
 * rod and selling the pieces. For example, if length of the rod is 8 
 * and the values of different pieces are given as following, 
 * then the maximum obtainable value is 22 
 * (by cutting in two pieces of lengths 2 and 6) :
 * length   | 1   2   3   4   5   6   7   8  
 *          --------------------------------------------
 *  price    | 1   5   8   9  10  17  17  20
 * 
 * And if the prices are as following, then the maximum obtainable value is 24 
 * (by cutting in eight pieces of length 1)
 * length   | 1   2   3   4   5   6   7   8  
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
*/
public class AlgorithmCuttingRod {
    public static int calcMax(int prices[]) {
        int resultValue = Integer.MIN_VALUE;
        for (int i = 0; i<prices.length; i++) {
            int count = calcRecursive(prices, prices.length-1, prices[prices.length-1], i, prices[i]);
            if(count>resultValue) {
                resultValue = count;
            }
        }
        if(resultValue<prices[prices.length-1]){
            return Integer.MIN_VALUE;
        } else {
            return resultValue;
        }
    }
    public static int calcRecursive(int prices[], int totalLength, int totalValue, 
                                    int currentLength, int currentValue) {
        int resultValue = Integer.MIN_VALUE;
        totalLength = totalLength-currentLength;
        if(totalLength == 0) {
            if(prices.length>0 &&totalValue < currentValue+prices[0] ) {
                return currentValue+prices[0];
            } else {
                return currentValue;
            }
        }
        if(prices.length<= 0) {
            return Integer.MIN_VALUE;
        } else {
            for (int i = 0; i<prices.length; i++) {
                int [] newArr = new int[prices.length-1];
                int countNewArr = 0;
                for (int j = 0; j<prices.length; j++) {
                    if(j != i) {
                        newArr[countNewArr] = prices[j];
                        countNewArr++;
                    }
                    
                }
                int count = calcRecursive(newArr, totalLength, totalValue, 
                              currentLength-i, currentValue+prices[i]);
                if(count > resultValue) {
                    resultValue = count;
                }
            }
        }
        return resultValue;
    }
    
    //Example: in an array length 8 would print:
    // arr[0] 8 times, arr[1] 8 times, arr[2] 8 times ... arr[7] 8 times Then
    // arr[0], arr[1]
    public static void printAllArrayCombination(int[] array, int n){
        if (n <= 0) {
            return;
        }
            
                    
        int max_val = Integer.MIN_VALUE;
        
        // Recursively cut the rod in different pieces and
        // compare different configurations
        System.out.println("");
        for (int i = 0; i<n; i++) {
            System.out.print("i:"+i+", array[i]:"+array[i]);
            printAllArrayCombination(array,n-i-1);
        }
    }
    public static void main(String[] args) {
        int prices[] = new int[] {1, 15, 8, 9, 10, 16, 17, 20};
        int maxVal = calcMax(prices);
        System.out.println("maxVal:"+maxVal);
        printAllArrayCombination(prices, prices.length);
    }
}
