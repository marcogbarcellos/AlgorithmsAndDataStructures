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
public class AlgorithmSpiralMatrix {
    public static void print(boolean[][] visited, int[][] matrix, boolean isRow, 
                             boolean isLeftOrTop, int x, int y) {
        if(x>=0 && y>=0 && x<matrix.length && y<matrix.length && !visited[x][y]) {
            System.out.print(matrix[x][y]+" ");
            visited[x][y] = true;
            
            if (isRow) {
                if (isLeftOrTop) {
                    print(visited, matrix, isRow, isLeftOrTop, x, y+1);
                } else {
                    print(visited, matrix, isRow, isLeftOrTop, x, y-1);
                }
            } else {
                if (isLeftOrTop) {
                    print(visited, matrix, isRow, isLeftOrTop, x+1, y);
                } else {
                    print(visited, matrix, isRow, isLeftOrTop, x-1, y);
                }
            }
        
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            { 1,    2,   3,  4, 5 },
            { 16,  17,  18, 19, 6 },
            { 15,  24,  25, 20, 7 },
            { 14,  23,  22, 21, 8 },
            { 13,  12,  11, 10, 9 },
            
        };
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        for (int i=0; i<matrix.length;i++) {
                print(visited, matrix, true, true, i, i);
                print(visited, matrix, false, true, i+1, matrix.length-1-i);
            
                print(visited, matrix, true, false, matrix.length-1-i, matrix.length-1-i-1);
                print(visited, matrix, false, false, matrix.length-1-i-1, i);
        }
    }
}
