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
public class AlgorithmFloorAndCeilingSortedArray {
    public static int findFloorNumber(int n, int[] sortedArray, int start, int end) {
        if(end-start == 1) {
            return sortedArray[start];
        }
        int middle = ((end-start)/2)+start;
        if(n >= sortedArray[middle]) {
            return findFloorNumber(n, sortedArray,middle,end);
        } else {
            return findFloorNumber(n, sortedArray,start,middle);
        }
    }
    public static int findCeilingNumber(int n, int[] sortedArray, int start, int end) {
        if(end-start == 1) {
            return sortedArray[end];
        }
        int middle = ((end-start)/2)+start;
        if(n >= sortedArray[middle]) {
            return findCeilingNumber(n, sortedArray,middle,end);
        } else {
            return findCeilingNumber(n, sortedArray,start,middle);
        }
    }
    public static void main(String[] args) {
        int[] sortedArray = {3,7,9,11,17,29,48,69,88};
        int floorNumber = findFloorNumber(32, sortedArray, 0, sortedArray.length-1);
        System.out.println("floor Number:"+floorNumber);
        int ceilingNumber = findCeilingNumber(32, sortedArray, 0, sortedArray.length-1);
        System.out.println("ceilingNumber:"+ceilingNumber);
    }
}
