/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * Given an n x n matrix, where every row and column is sorted 
 * in increasing order. 
 * Given a number x, how to decide whether this x is in the matrix. 
 * The designed algorithm should have linear time complexity.
 */
public class AlgorithmFindNumberInSortedColRowMatrix {
    
    public static void findNumberInMatrix(boolean[][] visited,int[][] matrix, 
                                          int number, int i, int j){
        if(i<matrix.length && j<matrix.length && i>=0 && j>=0 && !visited[i][j]) {
            visited[i][j] = true;
            if (matrix[i][j] == number) {
                System.out.println("got");
                System.out.println("found,i:"+i+", j:"+j);
            }
            else {
                if (number > matrix[i][j] ) {
                    findNumberInMatrix(visited, matrix, number, i+1, j);
                    findNumberInMatrix(visited, matrix, number, i, j+1);
                } else {
                    findNumberInMatrix(visited, matrix, number, i-1, j);
                    findNumberInMatrix(visited, matrix, number, i, j-1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50},
                         };
        int number = 39;
        int pivot = matrix.length/2;
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        findNumberInMatrix(visited, matrix, number, pivot, pivot);
    }
}
