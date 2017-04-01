/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
    Given the below pattern, write a recursive code for all values of n.
    N = 3

    - - -

    -

    - -

    -

    - - - 


    N = 4

    - - - - 4

    -

    - -

    -

    - - - 3

    -

    - -

    -

    - - - - 4


    N = 5

    - - - - - 5

    -

    - -

    -

    - - - 3

    -

    - -

    -

    - - - - 4

    -

    - -

    -

    - - - 3

    -

    - -

    -

    - - - - - 5


    N = 6

    - - - - - - 6
 
    - 

    - - 

    - 

    - - - 3

    -

    - -

    -

    - - - - 4

    -

    - -

    -

    - - - - - 5

    -

    - -

    -

    - - - - 4

    -

    - -

    -

    - - - 3

    -

   - -

    -

   - - - - - - 6
 */
public class AlgorithmPrintPathDashesRecursive {
    public static void printMiddle(int n, int limit) {
        if(n == limit) {
            for (int i = 0; i<n;i++) {
                System.out.print("-");
            }
        }
        else {
            for (int i = 0; i<n;i++) {
                System.out.print("-");
            }
            printPattern();
            if(n<limit) {
                printMiddle(n+1,limit);
            }
            printPattern();
            for (int i = 0; i<n;i++) {
                System.out.print("-");
            }
        }
        
    }
    public static void printPattern() {
        System.out.println("");
        System.out.println("-");
        System.out.println("--");
        System.out.println("-");
    }
    public static void printNumber(int n) {
        for (int i = 0; i<n;i++) {
            System.out.print("-");
        }
        printPattern();
        if(n>3) {
            printMiddle(3,n-1);
            printPattern();
        }
        for (int i = 0; i<n;i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        printNumber(5);
    }
}
