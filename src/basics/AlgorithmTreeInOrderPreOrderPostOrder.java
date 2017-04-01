/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;
import java.util.LinkedList;
/**
 *
 * @author marco
 * 
 * Given inorder and postorder traversal of a tree 
 * FIND the preorder traversal without creating the tree.
 * Example:
 *           1
 *         2    3
 *       4  5
 *      6 7
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 6 7 5 3
 * (c) Postorder (Left, Right, Root) : 6 7 4 5 2 3 1
 */
public class AlgorithmTreeInOrderPreOrderPostOrder {
    
    public static void printPostOrderGivenPreOrder(int[] preOrder) {
        LinkedList<Integer> stack = new LinkedList();
        
        for(int i=0;i<=preOrder.length/2;i++) {
            stack.push(preOrder[i]);
            if(i<preOrder.length/2){
                stack.push(preOrder[preOrder.length-1-i]);
            }
        }
        
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("");
    }
    
    public static void printInOrderGivenPreOrder(int[] preOrder) {
        LinkedList<Integer> queue = new LinkedList();
        
        for(int i=0;i<=preOrder.length/2;i++) {
            
            if(i>0 && (preOrder.length/2)-i >= 0) {
                queue.add(preOrder[(preOrder.length/2)-i]);
            }
            if((preOrder.length/2)+i <preOrder.length) {
                queue.add(preOrder[(preOrder.length/2)+i]);
            }
            
        }
//        * (a) Inorder (Left, Root, Right) : 6 4 7 2 5 1 3
//        * (b) Preorder (Root, Left, Right) : 1 2 4 6 7 5 3
//        * (c) Postorder (Left, Right, Root) : 6 7 4 5 2 3 1
        while(!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
        System.out.println("");
    }
    
    public static void printPreOrderGivenPostOrder(int[] postOrder) {
        LinkedList<Integer> queue = new LinkedList();
        for(int i=postOrder.length-1;i>=0;i--) {
            if(i%2 == 0){
                queue.add(postOrder[i]);
            }
        }
        for(int i=0;i<postOrder.length;i++) {
            if(i%2 == 1){
                queue.add(postOrder[i]);
            }
        }
        while(!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        //            1
        //*         2    3
        //*       4  5  
        //*      6 7
//        * (a) Inorder (Left, Root, Right) : 6, 4, 7, 2, 5, 1, 3
//        * (b) Preorder (Root, Left, Right) : 1, 2, 4, 6, 7, 5, 3
//        * (c) Postorder (Left, Right, Root) : 6, 7, 4, 5, 2, 3, 1
//
//                    1
        //*         2    3
        //*       4  5  6 7
        //*      8 9
//        * (a) Inorder (Left, Root, Right) : 8, 4, 9, 2, 5, 1, 6, 3, 7 
//        * (b) Preorder (Root, Left, Right) : 1, 2, 4, 8, 9, 5, 3, 6, 7
//        * (c) Postorder (Left, Right, Root) : 8, 9, 4, 5, 2, 6, 7, 3, 1
        int[] inOrder = {8, 4, 9, 2, 5, 1, 6, 3, 7};
        int[] preOrder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] postOrder = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        
        System.out.println("print InOrder:");
        printInOrderGivenPreOrder(preOrder);
        System.out.println("print preOrder:");
        printPreOrderGivenPostOrder(postOrder);
        System.out.println("print postOrder:");
        printPostOrderGivenPreOrder(preOrder);
        
        
        
    }
}
