/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author marco
 */
public class AlgorithmReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream("/Users/marco/Documents/gmyrick.txt"));
        
        while(scan.hasNextInt()) {
            int currentLine = scan.nextInt();
            System.out.println(currentLine);
        }
    }
}
