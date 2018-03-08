/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationtheoryhwk;

import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class Node {
    
    static public ArrayList<Node> NODES = new ArrayList<Node>();
    
    private boolean acceptingState;
    private int state;
    private Node inputOne;
    private Node inputZero;
    
    private Node(int state){
        this.state = state;
        this.acceptingState = false;
        Node.NODES.add(this);
    }
    
    public static Node getFirstInputNode(){
        return Node.NODES.get(0);
    }
    
    public static Node getNode(int state){
             
        Node node = null;
        for(int i=0; i < Node.NODES.size(); i++){
            if(Node.NODES.get(i).state == state){
                node = Node.NODES.get(i);
            }
        }
        
        if(node == null){
            node = new Node(state);
        }
        return node;
    }
    
    public void setOneInput(int state){
       this.inputOne = Node.getNode(state);
    }
    
    public void setZeroInput(int state){
        this.inputZero = Node.getNode(state);
    }
    
    public boolean isAcceptingState(){
        return this.acceptingState;
    }
    
    public int getState(){
        return this.state;
    }
    
    public Node getZeroInput(){
        return this.inputZero;
    }
    
    public Node getOneInput(){
        return this.inputOne;
    }
    
    public void setAcceptingState(boolean accept){
        this.acceptingState = accept;
    }
    
}

