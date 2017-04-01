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
public class AlgorithmLargestPalindromeSubstring {
    public static boolean isPalindrome(String m) {
        if(m.length() <=1) {
            return true;
        } else {
            if(m.charAt(0) == m.charAt(m.length()-1)) {
                return isPalindrome(m.substring(1,m.length()-1));
            } else {
                return false;
            }
        }
    }
    public static String findLargestPalindrome(String original) {
        String largestSubstringPalindrome = "";
        for(int i=0;i<original.length();i++) {
           for(int j=i+1;j<original.length();j++) {
               String sub = original.substring(i,j);
               if(isPalindrome(sub) && 
                  sub.length()>largestSubstringPalindrome.length()) {
                  largestSubstringPalindrome = sub; 
               }
           }
        }
        return largestSubstringPalindrome;
    }
    public static void main(String[] args) {
        String str = "100012294anaaaaaaaaaaana321988888891001";
        System.out.println("is \""+str+"\" palindrome? "+isPalindrome(str));
        String largestSubstringPalindrome = findLargestPalindrome(str);
        System.out.println("largest pal:"+largestSubstringPalindrome);
    }
}
