/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author marco
 */
class NodeGraph {
    private boolean visited;
    private int value;
    
    public NodeGraph(int value) {
        this.value = value;
        this.visited = false;
    }
    public int getValue(){
        return this.value;
    }
    public boolean isVisited(){
        return this.visited;
    }
    public void setVisited(boolean visited){
        this.visited = visited;
    }
    
    @Override
    public String toString(){
        return "Node "+this.value+", visited:"+this.visited;
    }
}
class Graph {
    private Map<NodeGraph,LinkedList<NodeGraph>> vertices;
    
    public Graph() {
        vertices = new HashMap();
    }
    // Function to add an edge into the graph
    public void addVertice(int v, LinkedList<Integer> links)
    {
        NodeGraph newVertice = new NodeGraph(v); 
        //Check whether the vertice already exists
        for (Map.Entry<NodeGraph,LinkedList<NodeGraph>> entry: vertices.entrySet()) {
            if(v == entry.getKey().getValue()) {
                newVertice = entry.getKey();
                break;
            }
        }
        //
        LinkedList<NodeGraph> actualLinks = new LinkedList();
        for(int nodeValue: links) {
            NodeGraph node = new NodeGraph(nodeValue);
            boolean nodeExists = false;
            for (Map.Entry<NodeGraph,LinkedList<NodeGraph>> entry: vertices.entrySet()) {
                if(node.getValue() == entry.getKey().getValue()) {
                    node = entry.getKey();
                    nodeExists = true;
                    break;
                }
            }
            if (!nodeExists) {
                vertices.put(node, new LinkedList<NodeGraph>());
            }
            actualLinks.add(node);
        }
        vertices.put(newVertice,actualLinks);        
    }
    public void runBfsAndDfs(){
        NodeGraph first= this.vertices.entrySet().iterator().next().getKey();
        System.out.println("BFS...");
        BFS(first);
        this.cleanVisitedNodes();
        System.out.println("DFS...");
        DFS(first);
        
    }
    public void DFS(NodeGraph start) {
        if(!start.isVisited()){
            System.out.println(start.getValue());
            start.setVisited(true);
        } 
        for(NodeGraph node: this.vertices.get(start)) {
            if(!node.isVisited()){
//                System.out.println("DFS:"+node);
                DFS(node);
            }
        }
    }
              
    public void BFS(NodeGraph start) {
        java.util.Queue<NodeGraph> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            NodeGraph node = queue.poll();
            if (!node.isVisited()) {
                System.out.println(node.getValue());
                node.setVisited(true);
            }
            for (NodeGraph child : this.vertices.get(node)) {
                if(!child.isVisited()){
                    queue.add(child);
                }
            }
        }
        
    }
    
    private void cleanVisitedNodes(){
        for(NodeGraph node: this.vertices.keySet()){
            node.setVisited(false);
        }
    }
}
public class DataStructureGraph {
    public static void main(String[] args) {
        Graph g = new Graph();
        
        LinkedList<Integer> links = new LinkedList();
        links.add(1);
        links.add(2);
        g.addVertice(0, links);
        links = new LinkedList();
        links.add(3);
        links.add(4);
        g.addVertice(1, links);
        links = new LinkedList();
        links.add(5);
        links.add(6);
        g.addVertice(2, links);
        
        g.runBfsAndDfs();
    }
}
