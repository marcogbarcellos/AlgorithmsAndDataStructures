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
public class AlgorithmNumberIsPowerOfTwo {
    public static void isPowerOf2(int number) {
        int count = 0;
        double currentPower = Math.pow(2, count);
        boolean isPower = false;
        while(currentPower<=number) {
            if(currentPower == number) {
                isPower = true;
                break;
            } else{
                count++;
                currentPower = Math.pow(2, count);
            }
        }
        System.out.println(number+" is power of 2?"+isPower);
    }
    //Bitwise: example: 8(1000) then 7(0111), then the AND operator will make it 000
    public static boolean isPowerOf2OneLine(int number) {
        return (number&(number-1)) == 0;
    }
    public static void main(String[] args) {
        int number = 27;
        isPowerOf2(number);
        number = 64;
        isPowerOf2(number);
        
        number = 75;
        System.out.println(isPowerOf2OneLine(number));
        number = 128;
        System.out.println(isPowerOf2OneLine(number));
        number = 0;
        System.out.println(isPowerOf2OneLine(number));
        number = 77;
        System.out.println(isPowerOf2OneLine(number));
        
    }
}
