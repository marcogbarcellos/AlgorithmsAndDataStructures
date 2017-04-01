package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * Rearrange characters in a string so that no character repeats twice. 
    Input: aaabc 
    Output: abaca 

    Input: aa 
    Output: No valid output 
    
    * 
    * 
    *   a
    *   a
    * a a 
    Input: aaaabc 
    Output: No valid output
 * @author marco
 */
public class AlgorithmStringSequence {
    
    public static String notTwiceString(String word) {
        Stack<Character> wordStack = new Stack<Character>();
        Stack<Character> repeatedLetters = new Stack<Character>();
        wordStack.push(word.charAt(0));
        StringBuilder wordM = new StringBuilder(word);
        wordM.deleteCharAt(0);
        while(wordM.length()>0){
            if( repeatedLetters.size() > 0 && !repeatedLetters.peek().equals(wordStack.peek()) ){
                wordStack.push(repeatedLetters.pop());
            }
            if(wordStack.peek().equals(wordM.charAt(0))){
                repeatedLetters.push(wordM.charAt(0));
            } else {
                wordStack.push(wordM.charAt(0));
            }
            wordM.deleteCharAt(0);
            if(wordM.length()<=0 &&
               repeatedLetters.size() > 0 &&
               !repeatedLetters.peek().equals(wordStack.peek())) {
                wordStack.push(repeatedLetters.pop());
            }
        }
        if (repeatedLetters.size()>0) {
           throw new java.lang.Error("Input not valid");
        }
        String x = wordStack.toString();
        return x;
    }
    
    public static void main(String[] args) {
       String word = notTwiceString("adadafferwda");
       
       System.out.println("new string:"+word);
   } 
}
