/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author marco
 */

class LRU {
    int size;
    int count;
    int highestIndex;
    int lowestIndex;
    HashMap<Integer, Integer> values;
    HashMap<Integer, Integer> indexes;
    
    
    public LRU(int size) {
        this.size = size;
        this.count = 0;
        this.highestIndex = 0;
        this.lowestIndex = 0;
        values = new HashMap();
        indexes = new HashMap();
    }
    // y->x
    public void add(int item){
        Integer index = values.get(item);
        if (this.count < size) {
            
            if(index != null) {
                this.indexes.remove(index);
            }
            
            this.count++;
        } else {
            if(index != null) {
                this.indexes.remove(index);
            } else {
                Integer valueToRemove = this.indexes.get(this.lowestIndex);
                while(valueToRemove == null) {
                    this.lowestIndex++;
                    valueToRemove = this.indexes.get(this.lowestIndex);
                }
                this.values.remove(valueToRemove);
                this.indexes.remove(this.lowestIndex);
                this.lowestIndex++;
            }
            
        }
        this.values.put(item, this.highestIndex);
        this.indexes.put(this.highestIndex, item);
        this.highestIndex++;
        
    }
    public void print(){
        System.out.println("Printing LRU...");
        Iterator it = values.entrySet().iterator();
        while(it.hasNext()) {
            it.next();
        }
        for (int key : values.keySet()) {
            System.out.print(key);
            System.out.print(" ");
        }
        System.out.println("");
    }
}

// 1 -> 2 -> 3 -> 4 -> 5
public class ProblemLRUCache {
    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.print();
        lru.add(3);
        lru.print();
        lru.add(6);
        lru.print();
        lru.add(4);
        lru.print();
        lru.add(7);
        lru.print();
        lru.add(8);
        lru.print();
        lru.add(9);
        lru.print();
        lru.add(10);
        lru.print();
//        System.out.println("lru:"+lru.p);
    }
}
