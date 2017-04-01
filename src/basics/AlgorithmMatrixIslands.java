/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * 
 * Find the number of islands in a matrix
 * INPUT:
 *  {1, 1, 0, 0, 0},
    {0, 1, 0, 0, 1},
    {1, 0, 0, 1, 1},
    {0, 0, 0, 0, 0},
    {1, 0, 1, 0, 1}
 * >=2^0 <2^1 ->            1
 * >=2^1 <2^2 ->      2            3
 * >=2^2 <2^3 ->   4    5       6     7
 * >=2^3 <2^4 ->  8 9 10 11   12 13 14 15
 * OUTPUT:
 *    - 5 ISLANDS....
 */
public class AlgorithmMatrixIslands {
    public static void DFS (boolean[][] visited, int[][] matrix, int x, int y) {
        int[] rowAdjs = {-1,-1,-1,0,1,1, 1, 0};
        int[] colAdjs = {-1, 0, 1,1,1,0,-1,-1};
        visited[x][y] = true;
        for (int i=0; i<rowAdjs.length; i++) {

            if( (x+rowAdjs[i])>=0 && (y+colAdjs[i])>=0 &&
                (x+rowAdjs[i])<matrix.length && (y+colAdjs[i])<matrix.length &&
                !visited[x+rowAdjs[i]][y+colAdjs[i]] && 
                matrix[x+rowAdjs[i]][y+colAdjs[i]] == 1) {
                
                DFS(visited, matrix, x+rowAdjs[i], y+colAdjs[i]);
            }
            
        }
    }
    public static int countIslands(boolean[][] visited, int[][] matrix, int x, int y) {
        int count = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    DFS(visited, matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
        
        boolean visited[][]=  new boolean[M.length][M.length];
        
        int number = countIslands(visited, M, 0, 0);
        System.out.println("number of islands:"+number);
    }
}
