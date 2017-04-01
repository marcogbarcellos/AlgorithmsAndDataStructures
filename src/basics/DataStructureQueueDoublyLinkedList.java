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
class Node {
    int value;
    Node next;
    Node previous;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}
class Queue {
    int size;
    int count;
    Node start;
    Node end;
    
    public Queue(int size) {
        this.size = size;
        this.count = 0;
    }
    // y->x
    public void add(int item){
        if (start == null) {
            start = new Node(item);
            end = start;
            end.previous = start;
            this.count++;
        } else if (this.count < size) {
            Node newStart = new Node(item);
            newStart.next = start;
            start.previous = newStart;
            start = newStart;
            this.count++;
        } 
    }
    public Node remove() {
        if (this.end == null) {
            return null;
        } else {
            Node popped = this.end;
            if (this.count == 1) {
                this.end = null;
                this.start = null;
                this.count--;
                return popped;
            } else {
                this.end = this.end.previous;
            this.end.next = null;
            this.count--;
            return popped;
            }
            
        }
    }
}

public class DataStructureQueueDoublyLinkedList {
    public static void main(String[] args) {
        int[] ok = new int[5];
        
        Queue q = new Queue(5);
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);
        System.out.println("queue: "+q);
        Node removed = q.remove();
        System.out.println("Got to be 5: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 4: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 3: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 2: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 1: "+removed.value);
        
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("queue: "+q);
        removed = q.remove();
        System.out.println("Got to be 1: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 2: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 3: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 4: "+removed.value);
        removed = q.remove();
        System.out.println("Got to be 5: "+removed.value);
    }
}
