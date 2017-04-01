/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Trie Data Structure
 * 1. Given a large number (can contain upto 10^5 digits), 
 *    find the number of substrings that are divisible by 8. 
 *     A substring cannot start with a 0 except if it is just 0.
 * This solution, by a mistake, is more complex because it doesn't look for substring
 * but actually for all the permutations of a string.
      ex : Input = 10888 , output = 9 {0, 8, 8, 8, 88, 88, 888, 1088, 10888}
   10,18,18,18,0,81,81
           *
    1    0    8   8    8 
   0888     1088 1088 1088
     
 * @author marco
 */
class NodeTrie {
    private char value;
    private int childrenSize;
    private HashMap<Integer,NodeTrie> children;
    public NodeTrie(char value){
        this.value = value;
        this.childrenSize = 0;
        this.children = new HashMap();
    }
    public void addChild(NodeTrie child) {
        children.put(childrenSize,child);
        childrenSize++;
    }
    public int getChildrenSize() {
        return childrenSize;
    }
    public char getValue() {
        return value;
    }
    public HashMap<Integer,NodeTrie> getChildren() {
        return children;
    }
}
class Trie {
    private NodeTrie root;
    public Trie(String word) {
        Character ch = Character.MIN_VALUE;
        this.root = new NodeTrie(ch);
        buildTrie(this.root, word);
    }
    
    private void buildTrie(NodeTrie current,String word) {
        for(int i=0;i<word.length();i++){
            NodeTrie child = new NodeTrie(word.charAt(i));
            StringBuilder otherChars = new StringBuilder(word);
            otherChars.deleteCharAt(i);
            buildTrie(child,otherChars.toString());
            current.addChild(child);
        }        
    }
    public Set<Integer> getQuantityOfNumbersDivisibleByNumber(int n) {
        return divisibleByGivenNumber(this.root,"",new HashSet<Integer>(), n);
    }
    private Set<Integer> divisibleByGivenNumber(NodeTrie current,String word, Set<Integer> numbers, int n) {
        System.out.println("calling");
        HashMap<Integer,NodeTrie> children = current.getChildren();
        for(HashMap.Entry<Integer,NodeTrie> child: children.entrySet()){
            String newWord = word+Character.toString(child.getValue().getValue());
            System.out.print("number:"+newWord);
            if(Integer.parseInt(newWord)%n == 0){
                System.out.print(" divisible by"+n);
                numbers.add(Integer.parseInt(newWord));
            }
            System.out.println("");
            if(child.getValue().getValue() != "0".charAt(0)){
                numbers.addAll(divisibleByGivenNumber(child.getValue(),newWord,numbers,n));
            } 
        }
        return numbers;   
    }
}
public class DataStructureTrie {

//          o
//     5    4    3
//    4 3  5 3  5 4
//    3 4  3 5  4 5   
    public static void main(String[] args) {
        Trie possibleNumbers = new Trie("10888");
        Set<Integer> numbers = possibleNumbers.getQuantityOfNumbersDivisibleByNumber(8);
        System.out.println("numbers:"+numbers);
        System.out.println("Quantity:"+numbers.size());
//        System.out.println("You have "+count+" numbers divisible by 8 from 0 to"+numberChosen);
    }
}
