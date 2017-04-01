/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;
import java.util.*;
import java.util.LinkedList;

/**
 *
 * @author marco
 */
class NodeHeap<T> {
    private int priority;
    private T value;
    private NodeHeap left;
    private NodeHeap right;
    private NodeHeap parent;
    
    public NodeHeap(int priority, T value) {
        this.priority = priority;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public NodeHeap getLeft() {
        return left;
    }

    public void setLeft(NodeHeap left) {
        this.left = left;
    }

    public NodeHeap getRight() {
        return right;
    }

    public void setRight(NodeHeap right) {
        this.right = right;
    }
    
    public NodeHeap getParent() {
        return parent;
    }

    public void setParent(NodeHeap parent) {
        this.parent = parent;
    }

    public int getPriority() {
        return priority;
    }

    public T getValue() {
        return value;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
class Heap<T> {
    private NodeHeap root;
    
    public Heap(int priority, T value) {
        this.root = new NodeHeap(priority, value);
    }
    
    public void add(NodeHeap newNode) {
    
    }
    
    public void addLeaf(NodeHeap newNode) {
        LinkedList<NodeHeap> q = new LinkedList();
        q.add(this.root);
        
        //adding leaf without balancing(yet)
        while(!q.isEmpty()) {
            NodeHeap current = q.poll();
            if(current.getLeft() == null) {
                newNode.setParent(current);
                current.setLeft(newNode);
                break;
            } else {
                q.add(current.getLeft());
            }
            if(current.getRight() == null) {
                newNode.setParent(current);
                current.setRight(newNode);
                break;
            } else {
                q.add(current.getRight());
            }
        }
        balanceNewNode(newNode);
    }
    public void balanceNewNode(NodeHeap newNode) {
        if(newNode.getParent() != null && newNode.getPriority() > newNode.getParent().getPriority()) {
            
            int tempPriority = newNode.getPriority();
            Object tempValue = newNode.getValue();
            
            newNode.setPriority(newNode.getParent().getPriority());
            newNode.setValue(newNode.getParent().getValue());
            newNode.getParent().setPriority(tempPriority);
            newNode.getParent().setValue(tempValue);
            
            balanceNewNode(newNode.getParent());
            
            
        }
    }
    
}

public class DataStructureHeap {
    
    public static void main(String[] args) {
        // unbalanced
//              10  
//        45            15
//     5       99   38      27
//   13     
//        
//           Balanced
//              99  
//       45          38     
//    13    10    15    27   
//  5      
//        
        Heap h = new Heap(10, 1);
        h.addLeaf(new NodeHeap(45, 1));
        h.addLeaf(new NodeHeap(15, 1));
        h.addLeaf(new NodeHeap(5, 1));
        h.addLeaf(new NodeHeap(99, 1));
        h.addLeaf(new NodeHeap(38, 1));
        h.addLeaf(new NodeHeap(27, 1));
        h.addLeaf(new NodeHeap(13, 1));
        System.out.println("teste...");
    }
}
