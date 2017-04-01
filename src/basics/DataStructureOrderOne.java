/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author marco
 */
class HashMarco<T> {
    private int index;
    private ArrayList<T> list;
    private HashMap<T,Integer> map;
    
    public HashMarco() {
        map = new HashMap();
        list = new ArrayList();
        index = 0;
    }
    public void add(T item) {
        if(map.get(item) == null) {
            list.add(item);
            map.put(item, index);
            index++;
        }
    }
    public void delete(T item) {
        if(map.get(item) != null) {
            list.remove(item);
            map.remove(item);
            
        } 
    }
    public T search(T item) {
        return (T)map.get(item);
    }
    public T getRandom() {
        Random r = new Random();
        int randomIndex = r.nextInt(list.size());
        return list.get(randomIndex);
    }
}

public class DataStructureOrderOne {
    public static void main(String[] args) {
        HashMarco<Integer> ds = new HashMarco();
        ds.add(1);
        ds.add(5);
        ds.add(7);
        ds.add(8);
        ds.add(9);
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        ds.delete(9);
        ds.delete(9);
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        ds.add(13);
        ds.add(17);
        ds.add(19);
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
        System.out.println("random: "+ds.getRandom());
    }
    
}
