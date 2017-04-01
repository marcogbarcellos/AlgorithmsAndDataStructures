/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marco
 */

//Write your code here
class Arithmetic {
    public int power (int a, int b) throws Exception {
        if (a<0 || b<0) {
           throw new Exception("n and p should be non-negative");
        }
        return (int) Math.pow(a, b);
    }
}


class Add {
    void add (int... numbers) throws Exception {
        if (numbers.length <= 1) {
           return; 
        }
        String resultStr = "";
        int count = 0;
        for(int i = 0 ; i < numbers.length; i++) {
            count += numbers[i];
            if (i == 0 ) {
                resultStr += ""+numbers[i];                
            } else {
                resultStr += "+"+numbers[i];                
            }
            
            if (i == (numbers.length-1) ) {
                resultStr += "="+count;                
            }
            
        } 
        System.out.println(resultStr);
    }
    
}

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
    
}

public class JavaApplication1 {
    

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int arr[] = new int[n];
//        for(int arr_i=0; arr_i < n; arr_i++){
//            Random random = new Random();
//            arr[arr_i] = random.nextInt(50)+1;
//            System.out.print(arr[arr_i]+" ");
//        }
//        
//    }
    
    static String[] friendlyWords(String[] input) {
        
        for(String word : input) {
            for(String secondWord : input) {
                if(word.length() == secondWord.length()) {
                    char[] first = word.toCharArray();
                    char[] second = secondWord.toCharArray();
                    
                    int match = 0;
                    for(int i = 0 ; i < first.length ; i++) {
                        for(int j = 0 ; j < second.length ; j++) {
                            if (first[i] == second[j]) {
                                first[i] = Character.MIN_VALUE;
                                second[j] = Character.MIN_VALUE;
                                match++;
                                break;
                            }
                        }
                    }
                    if(match>=word.length()){
                        System.out.println(word+" "+secondWord);
                    }
                }
           }   
        }
        
        return new String[]{};
    }
    
    public static void main(String[] args) {
        
        String[] line = {"listen","silent","teaching","cheating","car","bear"};
        String[] result = friendlyWords(line);
        
        System.out.println(result);
    }
}
