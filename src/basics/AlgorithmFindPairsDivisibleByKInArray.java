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
public class AlgorithmFindPairsDivisibleByKInArray {
    public static void main(String[] args) {
        int k = 4;
        int[] array = {1,2,4,7,18,5};
        boolean[] visited = new boolean[array.length];
        int count = 0;
        for(int i=0;i<array.length;i++) {
            if(visited[i]){
                continue;
            }
            boolean found = false;
            for(int j=i+1;j<array.length;j++) {
                if(visited[j]){
                    continue;
                }
                if( ((array[i]+array[j]) % k) == 0) {
                    found = true;
                    visited[i] = true;
                    visited[j] = true;
                    System.out.println("pair: "+array[i]+" and "+array[j]);
                    count++;
                    break;
                }
            }
            if(!found) {
                break;
            }
        }
        if(count == array.length/2 ) {
            System.out.println("yeaaaaaah");
        } else {
            System.out.println("only "+count+" pairs were found :(");
        }
    }
}
