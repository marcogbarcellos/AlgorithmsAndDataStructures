/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author marco
 */
class Product implements Comparable<Product>{
    String name;
    int quantity;
    
    public Product(String name, int qtt) {
        this.name = name;
        this.quantity = qtt;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Overriding the compare method to sort the age 
   public int compare(Product p1, Product p2) {
      return p1.quantity - p2.quantity;
   }

    @Override
    public int compareTo(Product p) {
        return this.quantity-p.quantity;
    }
}
public class AlgorithmTopKProducts {
    public static void main(String[] args) {
        PriorityQueue<Product> pq = new PriorityQueue<Product>();
        Product prod1 = new Product("p1",15);
        pq.add(prod1);
        Product prod2 = new Product("p2",55);
        pq.add(prod2);
        Product prod3 = new Product("p3",65);
        pq.add(prod3);
        Product prod4 = new Product("p4",75);
        pq.add(prod4);
        prod1.setQuantity(100);
        prod4.setQuantity(1);
        System.out.println("pq");
    }
}
