/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author marco
 */
public class AlgorithmHotelBookings {
    public static boolean areThereRoomsAvailable(int[] arrivals, int[] departure, int rooms) {
        PriorityQueue<Integer> pqArr = new PriorityQueue();
        PriorityQueue<Integer> pqDep = new PriorityQueue();
        for(int i = 0;i<arrivals.length;i++){
            pqArr.add(arrivals[i]);
            pqDep.add(departure[i]);
        }
        int lastDeparture = pqDep.peek();
        int busyRooms = 0;
        int count = 0;
        while(count<=lastDeparture) {
            if (!pqArr.isEmpty() && count == pqArr.peek()) {
                busyRooms++;
                pqArr.poll();
            }
            if (!pqDep.isEmpty() && count == pqDep.peek()) {
                busyRooms--;
                lastDeparture = pqDep.poll();
            }
            if(rooms-busyRooms < 0){
                return false;
            }
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        //       1           6
        //      7 3        15 8 
        int[] arrival = {7,3,1};
        int[] departure = {15,7,8};
        int rooms = 2;
        
        System.out.println("Are there rooms available:"+areThereRoomsAvailable(arrival, departure, rooms));
    }
}
