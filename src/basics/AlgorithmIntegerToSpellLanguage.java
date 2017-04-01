/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;
import java.util.Stack;
import java.util.LinkedList;

/**
 *
 * @author marco
 * 112345 Could be: ()
 * One hundred twelve thousand three hundred forty five.
 */
public class AlgorithmIntegerToSpellLanguage {
   final static String[] numbers = {"one","two","three","four","five","six","seven","eight",
                             "nine","ten","eleven","twelve","thirteen","fourteen",
                             "fifteen","sixteen","seventeen","nineteen"};
   final static String[] dozens = {"twenty","thirty","forty","fifty","sixty","seventy",
                            "eighty","ninety"};
   
   final static String hundred = "hundred";
   
   final static String[] moreThanHundred = {"thousand", "million", "billion", "trillion"};
   
   
   public static void printSpelledNumber(int number) {
        char[] numberArray = String.valueOf(number).toCharArray();
        Stack<Integer> stack = new Stack();
        for(int i=0; i < numberArray.length; i++) {
            stack.push(Integer.parseInt(String.valueOf(numberArray[i])));
        }
        Stack<String> stackString = new Stack();
        int count = 0;
        int level = 0;
        while(!stack.isEmpty()) {
            if(count > 0 && count%3 == 0) {
               stackString.push(moreThanHundred[level]);
               level++;
            }
            if (count%3 == 0) {
                stackString.push(numbers[stack.pop()-1]);
            } else if (count%3 == 1) {
                
                stackString.push(dozens[stack.pop()-1]);
            } else {
                stackString.push(hundred);
                stackString.push(numbers[stack.pop()-1]);
            }
           
            count++;
        }
        while(!stackString.isEmpty()) {
            System.out.print(" "+stackString.pop());
        }
   }
   public static void main(String[] args) {
       int number = 1665;
       printSpelledNumber(number);
   }
   
}
