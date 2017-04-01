/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;
import java.util.LinkedList;
/**
 *
 * @author marco
 */
public class AlgorithmNumberExpressionParenthesis {
    public static void allExpressions(String original) {
        StringBuilder sb = new StringBuilder(original);
        sb.insert(2, "test");
        System.out.println("original:"+original);
        System.out.println("new string:"+sb.toString());
        int numbers = 0;
        for (int i = 0; i < original.length(); i++) {
            if(Character.isDigit(original.charAt(i))){
                numbers++;
            }
        }
        int left = 0;
        int right = original.length()-1;
        int countParenthesis = 0;
        while (left<right) {
            
        }
        
    }
    public static int ah(String str, int index) {
        if(index<0 || index>=str.length()) {
            return 0;
        }
        
        if (String.valueOf(str.charAt(index)).equals("*")) {
            return ah(str.substring(0, index),str.substring(0, index).length()-1) *
                   ah(str.substring(index+1,str.length()),str.substring(index+1,str.length()).length()-1);
        }
        else if (String.valueOf(str.charAt(index)).equals("+")) {
            return ah(str.substring(0, index),str.substring(0, index).length()-1) +
                   ah(str.substring(index+1,str.length()),str.substring(index+1,str.length()).length()-1);
        }
        else if (String.valueOf(str.charAt(index)).equals("-")) {
            return ah(str.substring(0, index),str.substring(0, index).length()-1) -
                   ah(str.substring(index+1,str.length()),str.substring(index+1,str.length()).length()-1);
        }
        else {
            if(Character.isDigit(str.charAt(index))) {
                return Integer.parseInt(String.valueOf(str.charAt(index)));
            } else {
                return ah(str.substring(0,index), str.substring(0,index).length()-1) +
                       ah(str.substring(index+1,str.length()),str.substring(index+1,str.length()).length()-1); 
            }
        }
        
    }
    public static void vai(String str){
        for (int i=0;i<str.length();i++) {
            System.out.println("result"+i+":"+ah(str, i));
        }
    }
    public static void main(String[] args){
        String expression = "5*4-3*2"; // ((1+2)*(3+4)) ; ((1+(2*3))+4); (((1+2)*3)+4)
        vai(expression);
    }
}
