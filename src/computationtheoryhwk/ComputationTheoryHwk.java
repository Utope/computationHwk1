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

        while(true){
         
            System.out.println("Enter state symbol state ex. 10 1 14)");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            
            if(line.equals("done")){
                break;
            }
            
            String[] splitString = line.split("\\s");
            int from = Integer.valueOf(splitString[0]);
            int symbol = Integer.valueOf(splitString[1]);
            int to = Integer.valueOf(splitString[2]);
            
            Node fromNode = Node.getNode(from);
            
            if(symbol == 0){
                fromNode.setZeroInput(to);
            }else if(symbol == 1){
                fromNode.setOneInput(to);
            }
            System.out.println(fromNode.getState() + "->" + symbol + "->" + to);
            System.out.println();
        }
        
        while(true){
            System.out.println("Enter an Accepting state or 0 to be done");
            Scanner scanner = new Scanner(System.in);
            int state = Integer.valueOf(scanner.nextLine());
            
            if(state == 0){
                break;
            }
            
            Node node = Node.getNode(state);
            node.setAcceptingState(true);
        }
        
        System.out.println("Enter a input string of 1s and 0s");
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        
        
        Node currentNode = Node.getFirstInputNode();
        
        for(int i = 0; i < charArray.length; i++){
            int currentInput = Integer.valueOf(charArray[i]);
            
            switch(currentInput){
                case 0: currentNode = currentNode.getZeroInput();
                break;
                case 1: currentNode = currentNode.getOneInput();
                break;       
            }
        }
        
        if(currentNode.isAcceptingState()){
            System.out.println("ACCEPTING");
        }else{
            System.out.println("NON-ACCEPTING");
        }
        
    }
        
}
