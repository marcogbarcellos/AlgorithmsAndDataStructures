/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * go from 0,0 to m,n in a 2d matrix. 
 * find the maximum possible sum of your path. 
 * you can only move down or right.
 */
public class AlgorithmFindMaxSumPathInMatrix {
    
    public static void findMaxSumPathFromOrigin(int x, int y, int[][] matrix) {
        int maxSum = allPaths(0,0,x,y,matrix,0);
        System.out.println("max Sum:"+maxSum);
    }
    public static int allPaths(int currentX, int currentY, int destX, int destY, int[][] matrix, int sum) {
        if(currentX == destX && currentY == destY) {
            return sum+matrix[destX][destY];
        } 
        else if(currentX > destX || currentY > destY) {
            return 0;
        }
        else {
            if(allPaths(currentX+1, currentY, destX, destY, matrix, sum+matrix[currentX][currentY])
                    >=
               allPaths(currentX, currentY+1, destX, destY, matrix, sum+matrix[currentX][currentY])) {
               return  allPaths(currentX+1, currentY, destX, destY, matrix, sum+matrix[currentX][currentY]);
            } else {
               return  allPaths(currentX, currentY+1, destX, destY, matrix, sum+matrix[currentX][currentY]);
            }
        }
    }
    
    public static void main (String[] args) {
        int[][] matrix = new int[][]{
            { 1,    2,   3,  4, 5 },
            { 16,  17,  18, 19, 6 },
            { 15,  24,  25, 20, 7 },
            { 14,  23,  22, 21, 8 },
            { 13,  12,  11, 10, 9 },
        };
        findMaxSumPathFromOrigin(2,1,matrix);
    }    
}
