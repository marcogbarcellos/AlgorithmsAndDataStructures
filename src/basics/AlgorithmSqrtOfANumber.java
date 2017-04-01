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
public class AlgorithmSqrtOfANumber {
    public static int sqrt(int n){
        if (n == 0 || n == 1) {
           return n; 
        }
        int start = 1;
        int end = n;
        int ans = -1;
        while(start<=end) {
            int mid = (start+end)/2;
            
            if(mid*mid == n) {
                return mid;
            }
            if(mid*mid > n) {
                end = mid-1;
            } else {
                start = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 144;
        System.out.println("sqrt of "+n+" is "+sqrt(n));
    }
}
