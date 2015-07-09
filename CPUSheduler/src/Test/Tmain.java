/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.PriorityQueue;
import Processes.Process;
import computer.ProcessQueue;
/**
 *
 * @author Malith
 */
public class Tmain {

   
    public static void main(String[] args){
        
        ProcessQueue t = new ProcessQueue();
       
        boolean dt = t.isEmpty();
        t.dequeue();
        t.dequeue();
        
        System.out.println("done");
    }
   
    
    
    
}
