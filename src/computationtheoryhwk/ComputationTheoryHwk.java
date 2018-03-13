/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationtheoryhwk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author robert
 */
public class ComputationTheoryHwk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Lazy way to handle bad input and inccorect DFAs
        try{
            // while the user has not input 0 continue to ask them for state transitions
            while(true){

                System.out.println("Enter state symbol state (ex. 10 1 14)");
                System.out.println("Enter 0 to be done");
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();

                if(line.equals("0")){
                    break;
                }else{
                    
                    //Takes the input and slits it up
                    String[] splitString = line.split("\\s");
                    int from = Integer.valueOf(splitString[0]);
                    int symbol = Integer.valueOf(splitString[1]);
                    int to = Integer.valueOf(splitString[2]);
                    
                    //Gets the node that the transition is coming from
                    Node fromNode = Node.getNode(from);
                    
                    //This sets the 0 or 1 input node based on input
                    if(symbol == 0){
                        fromNode.setZeroInput(to);
                    }else if(symbol == 1){
                        fromNode.setOneInput(to);
                    }
                    
                    //Visual representation of what the transition is
                    System.out.println(fromNode.getState() + "->" + symbol + "->" + to);
                    System.out.println();
                }
            }
        

            System.out.println("Enter All Accepting states with spaces (ex. 1 3 5 where states 1,3,5 are accpeting states)");
            System.out.println("Enter 0 to be done");
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            
            //Splits the string based on spaces
            String[] acceptingStates = input.split("\\s");

            
            //Sets all accepting states based on input
            for(int i = 0; i < acceptingStates.length; i++){
                String state = acceptingStates[i];
                int numState = Integer.valueOf(state);

                Node node = Node.getNode(numState);

                if(node != null){
                    node.setAcceptingState(true);
                }
            }
            
            //Prints out the accepting states
            Node.printAcceptingStates();

            System.out.println("Enter a input string of 1s and 0s");
            Scanner sc = new Scanner(System.in);
            String inputArray = sc.nextLine();

            //Sets the first Node to the currentNode
            Node currentNode = Node.getFirstInputNode();
            
            //Walks through each input and swaps the currentNode based on the input
            for(int i = 0; i < inputArray.length(); i++){
                char currentChar = inputArray.charAt(i);

                switch(currentChar){
                    case '0': 
                        //System.out.println("going from " + currentNode.toString() + " to " + currentNode.getZeroInput());
                        currentNode = currentNode.getZeroInput();
                    break;
                    case '1':
                         //System.out.println("going from " + currentNode.toString() + " to " + currentNode.getOneInput());
                        currentNode = currentNode.getOneInput();
                    break;       
                }
            }
            
            //Prints what state the input ends at and if its accepting or not
            System.out.println("Ending at State " + currentNode.toString());
        }catch(Exception e){
            System.out.println("An error has occured. Your input is either bad or you left an empty transition on Your DFA. please try again.");
        }
        
        
        
    }
    
}
