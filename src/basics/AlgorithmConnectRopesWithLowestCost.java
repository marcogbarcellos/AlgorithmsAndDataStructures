/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author marco
 * There are given n ropes of different lengths, we need to connect 
 * these ropes into one rope. The cost to connect two ropes is equal 
 * to sum of their lengths. We need to connect the ropes with minimum cost.
 * For example if we are given 4 ropes of lengths 4, 3, 2 and 6. 
 * We can connect the ropes in following ways.
    1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
    2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
    3) Finally connect the two ropes and all ropes have connected.

*Total cost for connecting all ropes is 5 + 9 + 15 = 29. 
* This is the optimized cost for connecting ropes. 
* Other ways of connecting ropes would always have same or more cost. 
* For example, if we connect 4 and 6 first 
* (we get three strings of 3, 2 and 10), 
* then connect 10 and 3 (we get two strings of 13 and 2). 
* Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.

 */
public class AlgorithmConnectRopesWithLowestCost {
    
    public static int lowestCostRopes(int[] arr, int sum) {
        if(arr.length <= 0) {
            return sum;
        }
        if(arr.length==1){
            return sum;
        }
        int minCost = Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                ArrayList<Integer> list = new ArrayList();
                list.add(arr[i]+arr[j]);
                for (int k=0;k<arr.length;k++) {
                    if(k!=i && k!=j) {
                      list.add(arr[k]);
                    } 
                }
                int[] ret = new int[list.size()];
                for(int v = 0;v < ret.length;v++)
                  ret[v] = list.get(v);
                int price = lowestCostRopes(ret,sum+ret[0]);
                if(minCost>price)
                    minCost = price;
            }
        }
        return minCost;
    }
    public static int lowestRopePriorityQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue(arr.length);
        for (int i =0; i<arr.length;i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        int cost = 0;
        boolean first = true;
        while (!pq.isEmpty()) {
            sum += pq.poll();
            if(first){
                first = false;
            } else {
                cost += sum;
            }
        }
        return cost;
    }
    public static void main (String[] args) {
        int arr[] = {4, 3, 2, 6};
        int minCost = lowestCostRopes(arr,0);
        System.out.println("minCost:"+minCost);
        int minCostPQ = lowestRopePriorityQueue(arr);
        System.out.println("minCost:"+minCostPQ);
    }
}
