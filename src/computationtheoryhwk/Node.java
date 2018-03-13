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
    
    //Holds all instances of Nodes in program
    static public ArrayList<Node> NODES = new ArrayList<>();
    
    //Denotes if Node is an accepting state
    private boolean acceptingState;
    
    //the Nodes state
    private int state;
    
    //what node to transition to when 1 is input
    private Node inputOne;
    
    //what node to transition to when 0 is input
    private Node inputZero;
 
    /*
    -nodes can only be constructed within this class
    -every time a node is created it is added to the static NODES list
    */
    private Node(int state){
        this.state = state;
        this.acceptingState = false;
        Node.NODES.add(this);
    }
    
    /*
    Prints all nodes that are in the accepting state
    */
    public static void printAcceptingStates(){
        for(Node node: Node.NODES){
            if(node.isAcceptingState()){
                System.out.println(node.state + " is Accepting");
            }
        }
    }
    
    /*
    gets the first input node, where the DFA starts
    */
    public static Node getFirstInputNode(){
        return Node.NODES.get(0);
    }
    
    /*
    gets the node with the specified state, if that node does not exist it is
    created
    */
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
    
    /*
    Sets the nodes transition when the input is 1
    */
    public void setOneInput(int state){
       this.inputOne = Node.getNode(state);
    }
    
        /*
    Sets the nodes transition when the input is 0
    */
    public void setZeroInput(int state){
        this.inputZero = Node.getNode(state);
    }
    
    /*
    returns if the state is accepting or not
    */
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
    /*
    sets the node to accepting or non-accepting
    */
    public void setAcceptingState(boolean accept){
        this.acceptingState = accept;
    }
    
    @Override
    public String toString(){
        return (this.acceptingState) ? String.valueOf(this.state) + "[ACCEPTING]" : (String.valueOf(this.state) + "[NON-ACCEPTING]"); 
    }
}

