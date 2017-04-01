/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;

/**
 *
 * @author marco
 * Given a 2 D array with 
 * m Entry points (which are on the edges) 
 * and n exit points which are on the edges 
 * give the total number of paths that are possible .
 */
abstract class EntryOrExit {
    int x;
    int y;

    public EntryOrExit(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
class Entry extends EntryOrExit {
    
    public Entry(int x, int y) {
        super(x, y);
    }
    
}
class Exit extends EntryOrExit {
    
    public Exit(int x, int y) {
        super(x, y);
    }
    
}
public class AlgorithmPrintPathEntrancesExitInMatrix {
    
    public static boolean isSafe(int x, int y, int[][] matrix) {
        return (x > 0 && y > 0 && x < matrix.length && y < matrix.length);
    }
    
    public static int findPath(int[][] matrix, boolean[][] visited, int startX, int startY, int endX, int endY, int sum) {
        visited[startX][startY] = true;
        System.out.println("x:"+startX);
        System.out.println("y:"+startY);
        System.out.println("exit x:"+endX);
        System.out.println("exit y:"+endY);
        if (startX == endX && startY == endY) {
            System.out.println("got here?");
            return sum+1;
        }
        int[] rowAdjs = {-1,-1,-1,0,1,1, 1, 0};
        int[] colAdjs = {-1, 0, 1,1,1,0,-1,-1};
        
        for (int i=0;i<rowAdjs.length;i++) {
            if(isSafe(startX+rowAdjs[i], startY+colAdjs[i], matrix) && 
               !visited[startX+rowAdjs[i]][startY+colAdjs[i]]) {
                System.out.println("AND HERE?");
               sum = sum + findPath(matrix, visited, startX+rowAdjs[i], startY+colAdjs[i], endX, endY, sum);
            }
        }
        return sum;
        
    }
    
    public static void main(String[] args) {
        // 1 is entrance, 2 is exit
        int M[][]=  new int[][] {{0, 2, 1, 0, 0},
                                 {1, 0, 0, 0, 1},
                                 {2, 0, 0, 0, 1},
                                 {0, 0, 0, 0, 0},
                                 {2, 0, 1, 0, 1}
                                };
        
        ArrayList<Entry> entries = new ArrayList();
        ArrayList<Exit> exits = new ArrayList();
        for (int i=0; i<M.length;i++) {
            for (int j=0; j<M.length;j++) {
                if(M[i][j] == 1) {
                    entries.add(new Entry(i,j));
                }
            }
            for (int k=0; k<M.length;k++) {
                if(M[i][k] == 2) {
                    exits.add(new Exit(i,k));
                }
            }
        }
        
        for(Entry entry : entries) {
            for (Exit exit : exits) {
                boolean visited[][]=  new boolean[M.length][M.length];
                int x = findPath(M, visited, entry.x, entry.y, exit.x, exit.y, 0);
                System.out.println("entry x="+entry.x+" and y="+entry.y);
                System.out.println("exit x="+exit.x+" and y="+exit.y);
                System.out.println("Possible paths:"+x);
            }
        }
        
        
//        int number = countIslands(visited, M, 0, 0);
//        System.out.println("number of islands:"+number);
    }
}
