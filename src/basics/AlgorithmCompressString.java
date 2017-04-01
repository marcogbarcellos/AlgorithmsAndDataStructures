/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * Given a string like AAABBBCDEFGHIJKLLLLLLLLLLLLLLL – 
 * you have to compress it to a string like A3B3C1D1E1F1G1H1K1L15.
 */
public class AlgorithmCompressString {
    public static String compressString(String str) {
        String result = ""+str.charAt(0);
        int countLetter = 1;
        for (int i=1; i<str.length();i++) {
            if(str.charAt(i) == result.charAt(result.length()-1)){
                countLetter++;
            } else {
                if(countLetter>0) {
                    result+= countLetter;
                    result+= str.charAt(i);
                    countLetter = 1;
                } else{
                    countLetter++;
                }
            }
        }
        if(countLetter>0){
            result+= countLetter;
        }
        return result;
    }
    public static String compressStringNonRecursive(String str, String comp, int count) {
        if(str.length()<=0) {
            return comp+count;
        } else {
            if (comp.length()>0 && str.charAt(0) == comp.charAt(comp.length()-1)) {
                count++;
                return compressStringNonRecursive(str.substring(1), comp, count);
            } else {
                if(comp.length()>0) {
                    return compressStringNonRecursive(str.substring(1), comp+count+str.charAt(0), 1);
                } else {
                    return compressStringNonRecursive(str.substring(1), comp+str.charAt(0), 1);
                }
                
            }
        }
    }
    public static void main(String[] args) {
        String str = "AAABBBCCDDDEEFFFGGGGGGGGHHIIIJJJKKKKLLLLLLLLLLLLLLL";
        System.out.println("String NON-Compressed:"+str);
        String strCompressed = compressString(str);
        System.out.println("String compressed:"+strCompressed);
        String strCompressedRec = compressStringNonRecursive(str,"",1);
        System.out.println("String compressed using recursion:"+strCompressedRec);
    }
}
