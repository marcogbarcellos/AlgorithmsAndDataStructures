/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author marco
 * Given an input string and a dictionary of words,
 * segment the input string into a space-separated
 * sequence of dictionary words if possible. 
 * For example: 
 * if the input string is "applepie" and
 * dictionary contains a standard set of English words,
 * then we would return the string "apple pie" as output.
 */
public class AlgorithmWordBreakProblem {
    
    public static void printWords(String word, Set dictionary) {
        for(int i=0;i<word.length();i++) {
            for(int j=i+1;j<word.length();j++) {
                if(dictionary.contains(word.substring(i, j+1))) {
                    System.out.print(word.substring(i, j+1)+" ");
                }
            }
             
        }
        System.out.println("");
    }
    
    public static void printWordsRecursive(String word, Set dictionary, int start, int end, Map storedWords) {
        if(start<end && !storedWords.containsKey(word.substring(start, end))) {
            storedWords.put(word.substring(start, end), 0);
            if(dictionary.contains(word.substring(start, end))) {
                System.out.print(word.substring(start, end)+" ");
            }
            
            printWordsRecursive(word, dictionary, start+1, end, storedWords);
            printWordsRecursive(word, dictionary, start, end-1, storedWords);
        }
        
    }
    
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet();
        dictionary.add("mother");
        dictionary.add("father");
        dictionary.add("parent");
        dictionary.add("parents");
        dictionary.add("applebee");
        dictionary.add("apple");
        dictionary.add("forever");
        dictionary.add("pie");
        dictionary.add("dance");
        dictionary.add("dancing");
        dictionary.add("crazy");
        dictionary.add("craze");
        
        String word = "ertreparentswieurwecrazyendsndsdkcrazysdjreparentsdancindancecrazeappleapplepie";
        long startTime = System.currentTimeMillis();
        printWords(word, dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("estimated time Brute Force:"+estimatedTime);
        startTime = System.currentTimeMillis();
        Map<String,Integer> memo = new HashMap();
        
        printWordsRecursive(word, dictionary, 0, word.length(), memo );
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("estimated time Recursive:"+estimatedTime);
    }
}
