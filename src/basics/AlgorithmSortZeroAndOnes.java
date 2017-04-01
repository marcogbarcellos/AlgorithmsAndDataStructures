/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 * Given a link list of 0’s and 1’s sort it so that all the 0’s are at beginning 
 * and 1’s at the end. It had to be in-place.
 * You cannot swap values only pointers.Order of 0’s and 1’s to be maintained . 
 * I had to write production level code with all boundary conditions checked
 * @author marco
 */
class NodeLinkedList<K> {
    private K value;
    private NodeLinkedList<K> next;
    
    public K getValue() {
        return value;
    }
    
    public NodeLinkedList<K> getNext() {
        return next;
    }

    public void setNext(NodeLinkedList<K> next) {
        this.next = next;
    }
    public NodeLinkedList(K value) {
        this.value = value;
        this.next = null;
    }
}
class LinkedList<K> {
    private NodeLinkedList<K> start;
    
    public LinkedList() {
        this.start = null;
    }
    public LinkedList(K start) {
        this.start = new NodeLinkedList(start);
    }
    
    public NodeLinkedList<K> getStart() {
        return start;
    }
    
    public void setStart(NodeLinkedList<K> start) {
        this.start = start;
    }
    
    public void add(K value) {
        addNode(this.start, value);
    }
    private void addNode(NodeLinkedList current, K value) {
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new NodeLinkedList(value));
    }
    
    public void reorderLinkedList() {
        LinkedList zeros = new LinkedList();   
        LinkedList ones = new LinkedList(); 
        
        while(this.start != null) {
            if(this.start.getValue().equals(new Integer(1)) ) {
                if(ones.getStart() != null) {
                    NodeLinkedList currentOne = ones.getStart();
                    while(currentOne.getNext() != null) {
                        currentOne = currentOne.getNext();
                        System.out.println("one getting next");
                    }
                    currentOne.setNext(this.start);
                    currentOne = currentOne.getNext();
                    this.start = this.start.getNext();
                    currentOne.setNext(null);
                } else {
                    ones.setStart(this.start);
                    this.start = this.start.getNext();
                    ones.getStart().setNext(null);
                }
                
            } else {
                if(zeros.getStart() != null) {
                    NodeLinkedList currentZero = zeros.getStart();
                    while(currentZero.getNext() != null) {
                        System.out.println("zero getting next,currentZero.getValue():"+currentZero.getValue());
                        currentZero = currentZero.getNext();
                    }
                    currentZero.setNext(this.start);
                    currentZero = currentZero.getNext();
                    this.start = this.start.getNext();
                    currentZero.setNext(null);
                } else {
                    zeros.setStart(this.start);
                    this.start = this.start.getNext();
                    zeros.getStart().setNext(null);
                }
            }
            System.out.println("out getting next");
        }
        NodeLinkedList currentZero = zeros.getStart();
        while(currentZero!= null && currentZero.getNext() != null) {
            currentZero = currentZero.getNext();
        }
        if (currentZero != null) {
            currentZero.setNext(ones.getStart());
            this.setStart(zeros.getStart());
        }
    }

}
public class AlgorithmSortZeroAndOnes {
    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(1);
        System.out.println("ll");
        ll.reorderLinkedList();
        System.out.println("ll");
        
    }
}
