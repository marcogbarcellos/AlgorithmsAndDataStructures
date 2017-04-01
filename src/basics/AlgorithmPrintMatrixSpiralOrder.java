/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basics;
import java.util.*;
/**
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * @author marco
 */
public class AlgorithmPrintMatrixSpiralOrder {
    
    public static void main (String[] args) {
        int[][] matrix = new int[][]{
            { 1,    2,   3,  4, 5 },
            { 16,  17,  18, 19, 6 },
            { 15,  24,  25, 20, 7 },
            { 14,  23,  22, 21, 8 },
            { 13,  12,  11, 10, 9 },
            
        };
        int[][] visited = new int[matrix.length][matrix.length];
        for(int i=0; i<visited.length;i++) {
            for(int j=0; j<visited.length;j++) {
                visited[i][j] = 0;
            }
        }
        
        // r0c0-r0c3 c3r1-c3r3; 
        // r3c2-r3c0 c0r2-c0r1; 
        // r1c1-r1c2 c2r2----;
        // r2c1----- --------;
        for(int i=0; i<=matrix.length;i++) {
            
            //row left to right then column top to bottom
            printAll(visited, matrix, i, matrix.length-1-i, true, true, i);
            printAll(visited, matrix, i+1, matrix.length-1-i, false, true, matrix.length-1-i);
            //row right to left then column bottom to top
            printAll(visited, matrix, matrix.length-1-i-1, i, true, false, matrix.length-1-i);
            printAll(visited, matrix, matrix.length-1-1, i+1, false, false, i);
            
        }
    }
    public static void printAll(int[][] visited, int[][] matrix, int start, int end, boolean isRow, boolean topOrLeft, int rowOrColumnHeight) {
        if(isRow) {
            if(!topOrLeft) {
                for(int i=start; i>=end;i--) {
                    if(visited[rowOrColumnHeight][i] == 0) {
                        System.out.println(matrix[rowOrColumnHeight][i]);
                        visited[rowOrColumnHeight][i] = 1;
                    }
                    
                }
            } else {
                for(int i=start; i<=end;i++) {
                    if(visited[rowOrColumnHeight][i] == 0) {
                        System.out.println(matrix[rowOrColumnHeight][i]);
                        visited[rowOrColumnHeight][i] = 1;
                    }
                }
            }
            
        } else {
            if(!topOrLeft) {
                for(int i=start; i>=end;i--) {
                    if(visited[i][rowOrColumnHeight] == 0) {
                        System.out.println(matrix[i][rowOrColumnHeight]);
                        visited[i][rowOrColumnHeight] = 1;
                    }
                }
            } else {
                for(int i=start; i<=end;i++) {
                    if(visited[i][rowOrColumnHeight] == 0) {
                        System.out.println(matrix[i][rowOrColumnHeight]);
                        visited[i][rowOrColumnHeight] = 1;
                    }
                }
            }
        }
    }    
}
