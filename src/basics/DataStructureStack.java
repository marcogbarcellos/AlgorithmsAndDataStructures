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
class Stack {
    private int maxSize;
    private String[] stackArray;
    private int top;
    
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new String[maxSize];
        top = -1;
    }
    public void push(String value) {
        System.out.println("pushing: "+value);
        top++;
        stackArray[top] = value;
         
        
    }
    public String peek() {
        if (top>=0) {
            return stackArray[top];
        } else {
            return null;
        }
        
    }
    public String pop() {
        if (top>=0) {
            String toPopItem = stackArray[top];
            top--;
            return toPopItem;
        } else {
            return null;
        }
    }
}

public class DataStructureStack {
    public static void main(String[] args) {
      Stack theStack = new Stack(5); 
      theStack.push("marco");
      theStack.push("heloisa");
      theStack.push("terezinha");
      theStack.push("gilberto");
      theStack.push("lucas");
      
      while (theStack.peek() != null) {
         String value = theStack.pop();
         System.out.println("popping: "+value);
      }
      System.out.println("");
      
      theStack.push("marco2");
      theStack.push("heloisa2");
      theStack.push("terezinha2");
      theStack.push("gilberto2");
      theStack.push("lucas2");
      
      while (theStack.peek() != null) {
         String value = theStack.pop();
         System.out.println("popping: "+value);
      }
      System.out.println("");
    }
}
