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
        Process a = new Process(0, 3, 1);
        Process b = new Process(2, 6, 1);
        ProcessQueue t = new ProcessQueue();
        t.enqueue(a);
        t.enqueue(b);
        boolean dt = t.isEmpty();
        t.dequeue();
        t.dequeue();
        
        System.out.println("done");
    }
   
    
    
    
}
