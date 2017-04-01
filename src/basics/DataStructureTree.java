/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author marco
 */
class NodeTree{
    private int value;
    private NodeTree left;
    private NodeTree right;
    
    public NodeTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }
    
}

class BinarySearchTree {
    
    private NodeTree root;
    
    public BinarySearchTree(int value) {
        this.root = new NodeTree(value);
    }
    public BinarySearchTree(NodeTree root) {
        this.root = root;
    }

    public NodeTree getRoot() {
        return root;
    }
    public void add(int value) {
        addRec(this.root, value);
    }
    private void addRec(NodeTree current, int value) {
        if(value >= current.getValue()){
            if(current.getRight() != null) {
                addRec(current.getRight(), value);
            } else {
                current.setRight(new NodeTree(value));
            }
        } 
        else if(value < current.getValue()) {
            if(current.getLeft() != null) {
                addRec(current.getLeft(), value);
            } else {
                current.setLeft(new NodeTree(value));
            }
        }
    }
    
    public void printDFS(){
        showDFS(this.root);
    }
    public void showDFS(NodeTree current){
        if(current != null) {
            System.out.println(current.getValue());
            showDFS(current.getLeft());
            showDFS(current.getRight());
        }
    }
    public void printBFS(){
        LinkedList<NodeTree> queue = new LinkedList<NodeTree>();
        queue.add(this.getRoot());
        while(!queue.isEmpty()){
            NodeTree current = queue.poll();
            System.out.println(current.getValue());
            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if(current.getRight() != null) {
                queue.add(current.getRight());
            }
            
        }
    }
    public boolean isBinarySearchTree() {
        return isBST(Integer.MAX_VALUE, Integer.MIN_VALUE, this.root);
    }
    private boolean isBST(int maxValue, int minValue, NodeTree current) {
        if(current == null) {
            return true;
        }
        if(maxValue < current.getValue() || minValue > current.getValue()) {
            return false;
        }
        return isBST(current.getValue(), minValue,current.getLeft()) &&
               isBST(maxValue, current.getValue(), current.getRight());
   }
   
//  Given a tree, print all the nodes in spiral order:
//    
// 2^0                       50
// 2^1 2^1+1           25            75
// 2^2 2^2+1       12    38     62     80 
//               5   20 29 47  59 71  77 120
//    
// The output for the above tree would be: 50 75 25 12 38 62 80 120 77 71 59 47 29 20 5
    public void printAllNodesInSpiralOrder() {
        LinkedList<NodeTree> queue = new LinkedList();
        LinkedList<Integer> queueToprint = new LinkedList();
        Stack<Integer> auxStack = new Stack();
        queue.add(root);
        int count = 1;
        int level = 0;
        while(!queue.isEmpty()) {
            NodeTree current = queue.poll();
            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
            if (level%2 == 0) {
                queueToprint.add(current.getValue());
            } else {
                auxStack.push(current.getValue());
            }
            count++;
            double nextPower = Math.pow(2, level+1);
            if(count>=nextPower){
                if(!auxStack.isEmpty()) {
                    while(!auxStack.isEmpty()) {
                        queueToprint.add(auxStack.pop());
                    }
                    
                }
                level++;
            }
        }
        while (!queueToprint.isEmpty()) {
            int current = queueToprint.poll();
            
            System.out.print(current+" ");
        }
    }
    
    public void printLevelWithMoreNodes() {
        LinkedList<NodeTree> queue = new LinkedList();
        queue.add(root);
        int count = 1;
        int levelWithMoreNodes = 0;
        int countNodesInLevelWithMoreNodes = 0;
        int level = 0;
        int countNodesInCurrentLevel = 0;
        while(!queue.isEmpty()) {
            NodeTree current = queue.poll();
            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if(current.getRight() != null) {
                queue.add(current.getRight());
            }
            
            count++;
            countNodesInCurrentLevel++;
            double nextPower = Math.pow(2, level+1);
            
            if(count>=nextPower){
                if(countNodesInLevelWithMoreNodes < countNodesInCurrentLevel) {
                    levelWithMoreNodes = level;
                    countNodesInLevelWithMoreNodes = countNodesInCurrentLevel;
                }
                level++;
                countNodesInCurrentLevel = 0;
            }
            if(queue.isEmpty()) {
                if(countNodesInLevelWithMoreNodes < countNodesInCurrentLevel) {
                    levelWithMoreNodes = level;
                    countNodesInLevelWithMoreNodes = countNodesInCurrentLevel;
                }
            }
        }
        System.out.println("level with more Nodes: "+levelWithMoreNodes);
        System.out.println("Number of Nodes: "+countNodesInLevelWithMoreNodes);
    }
    
    //Given a binary tree, a target node in the binary tree, and an integer value k, 
    //PRINT ALL NODES that are at distance k from the given target node. 
    //No parent pointers are available.
    public void printAllNodesDistantFromGivenValue(int value,int k){
       findDistantNodes(value, 0, k, false, this.root);
    }
    private void findDistantNodes(int value, int count, int k, 
                                     boolean found, NodeTree node){
       if(node != null) {
            if(found && count == k) {
                System.out.println(node.getValue());
            } 
            else {
                if(found && count < k) {
                    count++;
                }
                else if(!found && node.getValue() == value) {
                    count++;
                    found = true;
                    
                }
                findDistantNodes(value, count, k, found, node.getLeft());
                findDistantNodes(value, count, k, found, node.getRight());
            }
        }    
       
    }
    
    public void findmaxSumLevel() {
        LinkedList<NodeTree> queue = new LinkedList();
        queue.add(root);
        
        int count = 1;
        int level = 0;
        int maxSumLevel = 0;
        int maxSumLevelResult = 0;
        int currentSumLevel = 0;
        
        while(!queue.isEmpty()) {
            
            NodeTree current = queue.poll();
            if (current.getLeft() != null) {
               queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
               queue.add(current.getRight());
            }
            currentSumLevel+=current.getValue();
            
            count++;
            if(count >= Math.pow(2, level+1)) {
                System.out.println("count:"+count);
                System.out.println("current level:"+level);
                if (currentSumLevel>maxSumLevelResult) {
                    System.out.println("currentSumLevel:"+currentSumLevel);
                    System.out.println("level:"+level);
                   maxSumLevelResult = currentSumLevel;
                   maxSumLevel = level;
                }
                currentSumLevel = 0;
                level++;
                System.out.println("new level:"+level);
                System.out.println("new sum level:"+currentSumLevel);
            }
            
        }
        
        //falls here if tree didn't reach next level(incomplete level)
        if(currentSumLevel>maxSumLevelResult){
            maxSumLevelResult = currentSumLevel;
            maxSumLevel++;
        }
        System.out.println("Level with max Sum:"+maxSumLevel);
        System.out.println("And the MAX Sum Result:"+maxSumLevelResult);
    }
    public void findLongestPath() {
        int longPath = findNodeWithLongestPath(root, 0);
        System.out.println("longest Path:"+longPath);
    }
    private int findNodeWithLongestPath(NodeTree current, int height) {
        if (current == null) {
           return height;
        } else {
            int left = findNodeWithLongestPath(current.getLeft(), height+1);
            int right = findNodeWithLongestPath(current.getRight(), height+1);
            if(left>right) {
                return left;
            } else {
                return right;
            }
        }
    }
    public BinarySearchTree mirror() {
        NodeTree newRoot = addNewMirror(root);
        return new BinarySearchTree(newRoot);
    }
    private NodeTree addNewMirror(NodeTree current) {
        NodeTree newNode = new NodeTree(current.getValue());
        if (current.getRight() != null) {
            newNode.setLeft(addNewMirror(current.getRight()));
        }
        if (current.getLeft() != null) {
            newNode.setRight(addNewMirror(current.getLeft()));
        }
        return newNode;
    }
//       1
//    /     \
//   2       3
//  /  \    / \
// 4    5  6   7
//Top view of the above binary tree is
//4 2 1 3 7
//
//        1
//      /   \
//    2       3
//      \   
//        4  
//          \
//            5
//             \
//               6
//Top view of the above binary tree is
//2 1 3 6
    public void printTopView(){
        int lvLeft = printTopLeft(root.getLeft(),1);
        int lvRight = printTopRight(root,0);
        printOverBorderNodes(root,lvLeft,lvRight);
    }
    private int printTopLeft(NodeTree current, int level){
        if(current == null) {
            System.out.println("here,level:"+level);
            return level;
        }
        int leftLv = printTopLeft(current.getLeft(),level+1);
        System.out.print(current.getValue()+" ");
        return leftLv;
    }
    private int printTopRight(NodeTree current, int level){
        if(current == null) {
            return level;
        }
        System.out.print(current.getValue()+" ");
        return printTopRight(current.getRight(),level+1);
    }
    private void printOverBorderNodes(NodeTree current, int levelLeft, int levelRight){
        if(current != null) {
            if(levelLeft < 0 || levelRight<0) {
                System.out.print(current.getValue()+" ");
            }
            printOverBorderNodes(current.getLeft(), levelLeft--, levelRight++);
            printOverBorderNodes(current.getRight(), levelLeft++, levelRight--);
        }
    }
    
}

public class DataStructureTree {
    public static void main(String[] args) {
//                                   50
//                        25                       75
//                 12           38           62           80 
//               5    20     29     47    59    71     77    120
//             3  7 14  23  27 34 44 48 57 61 65 73  76 79 110 129
        BinarySearchTree bst = new BinarySearchTree(50);
        bst.add(25);
        bst.add(75);
        bst.add(38);
        bst.add(62);
        bst.add(12);
        bst.add(80);
//        bst.add(5);
//        bst.add(20);
//        bst.add(29);
//        bst.add(47);
//        bst.add(59);
//        bst.add(71);
//        bst.add(77);
//        bst.add(120);
//        bst.add(3);
//        bst.add(7);
//        bst.add(14);
//        bst.add(23);
//        bst.add(27);
//        bst.add(34);
//        bst.add(44);
//        bst.add(48);
//        bst.add(57);
//        bst.add(61);
//        bst.add(65);
//        bst.add(73);
//        bst.add(76);
//        bst.add(79);
//        bst.add(110);
//        bst.add(129);
//        bst.add(135);
//        bst.add(157);
        System.out.println("BFS");
        bst.printBFS();
        System.out.println("DFS");
        bst.printDFS();
        System.out.println("bst:"+bst);
        boolean isBst = bst.isBinarySearchTree();
        System.out.println("Is binary search Tree??"+isBst);
        System.out.println("Printing nodes from certain level");
        bst.printAllNodesDistantFromGivenValue(25,2);
        System.out.println("Printing nodes in spiral order...");
        bst.printAllNodesInSpiralOrder();
        System.out.println("Printing level with more nodes...");
        bst.printLevelWithMoreNodes();
        System.out.println("Printing level with Max Sum...");
        bst.findmaxSumLevel();
        System.out.println("Longest Path...");
        bst.findLongestPath();
        System.out.println("mirror");
        BinarySearchTree mirror = bst.mirror();
        
        //                                   50
//                        25                       75
//                 12           38           62           80 
//                                                 70
//                                                        71
//                                                            72
        bst = new BinarySearchTree(50);
        bst.add(25);
        bst.add(75);
        bst.add(38);
        bst.add(62);
        bst.add(12);
        bst.add(80);
        bst.add(70);
        bst.add(71);
        bst.add(72);
        bst.add(73);
        bst.add(74);
        bst.add(75);
        System.out.println("Printing TOP VIEW...");
        bst.printTopView();
    }
}
