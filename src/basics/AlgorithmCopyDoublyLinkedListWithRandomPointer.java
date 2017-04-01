/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marco
 */
class NodeDoublyLinkedList{
    private int value;
    private NodeDoublyLinkedList next;
    private NodeDoublyLinkedList previous;
    private NodeDoublyLinkedList random;
    
    public NodeDoublyLinkedList(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
        this.random = null;
    }
    public int getValue() {
        return value;
    }

    public NodeDoublyLinkedList getNext() {
        return next;
    }

    public void setNext(NodeDoublyLinkedList next) {
        this.next = next;
    }

    public NodeDoublyLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDoublyLinkedList previous) {
        this.previous = previous;
    }

    public NodeDoublyLinkedList getRandom() {
        return random;
    }

    public void setRandom(NodeDoublyLinkedList random) {
        this.random = random;
    }
}
class DoublyLinkedList {
    private NodeDoublyLinkedList start;
    
    public DoublyLinkedList(int value) {
        this.start = new NodeDoublyLinkedList(value);
    }

    public NodeDoublyLinkedList getStart() {
        return start;
    }

    public void setStart(NodeDoublyLinkedList start) {
        this.start = start;
    }
    public void add(int value) {
        NodeDoublyLinkedList node = new NodeDoublyLinkedList(value);
        NodeDoublyLinkedList current = this.start;
        while(current != null) {
            if(current.getNext() == null) {
                node.setPrevious(current);
                current.setNext(node);
                break;
            }
            current = current.getNext();
        }
    }
    public void setRandomPointer(int nodeValue1, int nodeValue2) {
        NodeDoublyLinkedList current = this.start;
        NodeDoublyLinkedList node1  = this.start;
        NodeDoublyLinkedList node2  = this.start;
                
        while(current != null) {
            if(current.getValue() == nodeValue1) {
                node1 = current;
                break;
            }
            current = current.getNext();
        }
        current = this.start;
        while(current != null) {
            if(current.getValue() == nodeValue2) {
                node2 = current;
                node1.setRandom(node2);
                break;
            }
            current = current.getNext();
        }
    }
    public DoublyLinkedList copy() {
        DoublyLinkedList copy = new DoublyLinkedList(this.start.getValue());
        copy.getStart().setNext(this.start.getNext());
        copy.getStart().setPrevious(this.start.getPrevious());
        Map<Integer, NodeDoublyLinkedList> randoms = new HashMap();
        if(copy.getStart().getValue() == this.start.getRandom().getValue()) {
            copy.getStart().setRandom(copy.getStart());
        } else {
            NodeDoublyLinkedList randomNode = new NodeDoublyLinkedList(this.start.getRandom().getValue());
            randoms.put(this.start.getRandom().getValue(),randomNode);
            copy.getStart().setRandom(randomNode);
        }
        NodeDoublyLinkedList current = this.start.getNext();
        NodeDoublyLinkedList currentCopy = copy.getStart();
        while(current != null) {
            NodeDoublyLinkedList next;
            if(randoms.get(current.getValue()) != null) {
                next = randoms.get(current.getValue());
                next.setPrevious(currentCopy);
                if(current.getRandom() != null) {
                    if(randoms.get(current.getRandom().getValue()) != null) {
                        next.setRandom(randoms.get(current.getRandom().getValue()));
                    } else {
                        NodeDoublyLinkedList randomNode = new NodeDoublyLinkedList(current.getRandom().getValue());
                        randoms.put(current.getRandom().getValue(),randomNode);
                        next.setRandom(randomNode);
                    }
                }
                currentCopy.setNext(next);
            } else {
                next = new NodeDoublyLinkedList(current.getValue());
                next.setPrevious(currentCopy);
                if(current.getRandom() != null) {
                    if(randoms.get(current.getRandom().getValue()) != null) {
                        next.setRandom(randoms.get(current.getRandom().getValue()));
                    } else {
                        NodeDoublyLinkedList randomNode = new NodeDoublyLinkedList(current.getRandom().getValue());
                        randoms.put(current.getRandom().getValue(),randomNode);
                        next.setRandom(randomNode);
                    }
                }
                
                currentCopy.setNext(next);
            }
            current = current.getNext();
            currentCopy = currentCopy.getNext();
        }
        return copy;
    }
    
}
public class AlgorithmCopyDoublyLinkedListWithRandomPointer {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        dll.add(40);
        dll.add(30);
        dll.add(50);
        dll.add(60);
        dll.add(80);
        dll.setRandomPointer(10, 80);
        dll.setRandomPointer(30, 50);
        dll.setRandomPointer(60, 40);
        dll.setRandomPointer(80, 40);
        DoublyLinkedList copy = dll.copy();
        System.out.println("copy");
    }
}
