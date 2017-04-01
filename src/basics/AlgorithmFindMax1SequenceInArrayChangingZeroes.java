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
public class AlgorithmFindMax1SequenceInArrayChangingZeroes {
    //arr -> array of values
    // m -> number of zeroes allowed to swap to one.
    public static int findMaxZero(int[] arr, int m) {
        int countM = m;
        int maxOfOnes = 0;
        int countOnes = 0;
        boolean foundFirstZero = false;
        for (int i=0;i<arr.length;i++) {
            if(arr[i] == 0){
                if (!foundFirstZero) {
                   foundFirstZero = true; 
                }
                if(countM>0) {
                    countOnes++;
                    countM--;
                }
                
                for (int j=i+1;j<arr.length;j++) {
                    if(arr[j] == 0){
                       if(countM>0) {
                           countOnes++;
                           countM--;
                       } else if (maxOfOnes<countOnes) {
                            maxOfOnes = countOnes;
                            countOnes = 0;
                        } else {
                           countOnes = 0;
                       }
                    } else {
                        countOnes++;
                    }
                }
            } else {
                countOnes++;
            }
            if (foundFirstZero) {
                countM = m;
                if (maxOfOnes<countOnes) {
                    maxOfOnes = countOnes;
                }
                countOnes = 0;
               foundFirstZero = false; 
            }
            
        }
        return maxOfOnes;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1};
        int m = 2;
        
        int maxOfOnes = findMaxZero(arr, m);
        
        
        System.out.println("maxOfOnes:"+maxOfOnes);
    }
 
}
