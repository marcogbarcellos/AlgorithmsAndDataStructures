/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author marco
 */
class LinkedNode {
    int value;
    LinkedNode next;
    LinkedNode random;
    public LinkedNode(int value) {
        this.value = value;
        next = null;
        random = null;
    }
}
class SingleLinkedList {
    LinkedNode head;
    int size = 0;
    public SingleLinkedList(LinkedNode head) {
        this.head = head;
        size = 1;
    }
    
    public void add(LinkedNode node) {
        LinkedNode current = head;
        while(current.next !=null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }
    public void remove (int value) {
        LinkedNode parent = head;
        LinkedNode current = head.next;
        while(current != null) {
            if(current.value == value) {
                parent.next = current.next;
                size--;
                break;
            }
            current = current.next;
            parent = parent.next;
        }
    }
    
    public void setRandomPointers() {
        LinkedNode current = head;
        while(current.next != null) {
            Random r = new Random();
            int randomNumber = r.nextInt(size-1);
            LinkedNode currentRandom = head;
            int count = 0;
            while(currentRandom.next != null) {
                if (count == randomNumber) {
                   current.random = currentRandom;
                   break;
                }
                currentRandom = currentRandom.next;
                count++;
            }
            current = current.next;
        }
    }
    
    public SingleLinkedList clone() {
        HashMap<LinkedNode,LinkedNode> map = new HashMap();
        LinkedNode current = head;
        while(current != null) {
            map.put(current, new LinkedNode(current.value));
            current = current.next;
        }
        current = head;
        while(current != null) {
            LinkedNode clone = map.get(current);
            clone.next = map.get(current.next);
            clone.random = map.get(current.random);
            current = current.next;
        }
        SingleLinkedList clone = new SingleLinkedList(map.get(head));
        clone.size = size;
        return clone;
    }
    
}
public class DataStructureLinkedList {
    public static void main(String[] args){
        SingleLinkedList ll = new SingleLinkedList(new LinkedNode(5));
        ll.add(new LinkedNode(7));
        ll.add(new LinkedNode(78));
        ll.add(new LinkedNode(45));
        ll.add(new LinkedNode(5));
        ll.add(new LinkedNode(11));
        ll.add(new LinkedNode(9));
        ll.remove(7);
        ll.setRandomPointers();
        ll.add(new LinkedNode(3));
        ll.add(new LinkedNode(2));
        SingleLinkedList clone = ll.clone();
        System.out.println("cloned...");
    }
}
