/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheduler;

import Processes.Process;
import com.google.common.base.Stopwatch;
import computer.CPU;
import computer.MainMemmory;
import computer.ProcessQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


//  STS = Short Time Sheduler
/**
 *
 * @author Malith
 */
public class STS implements Runnable{
    
    ArrayList<Process> processList;
    CPU cpu;
     
    ProcessQueue readyQueue;
    ProcessQueue Auxiliary;
    ProcessQueue IoWaiting;
    
    double stopwatch;

    Process runningProcess = null;
    
    Process chosenProcess = null;
     Process preemptedProcess;
     Process blockedProcess;
     double nextCPUtime;
   
    
    public STS(ArrayList<Process> processList, CPU cpu, MainMemmory mainMemmory, double stopwatch) {
        this.processList = processList;
        this.cpu = cpu;
        this.readyQueue = mainMemmory.getReadyQueue();
        this.IoWaiting = mainMemmory.getIoWaiting();
        this.Auxiliary = mainMemmory.getAuxiliary();
        this.runningProcess = cpu.getRunningProcess();
        this.stopwatch = stopwatch;
       
    }

    @Override
    public void run(){
        while(readyQueue.isEmpty()){
           
        }
        while(true){
           
            if(readyQueue.isEmpty() && Auxiliary.isEmpty()){
                try {
                    
                    Thread.sleep(1000); // 1000 is the time slice
                    stopwatch++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(STS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                
                System.out.println("");
                if(!Auxiliary.isEmpty()){chosenProcess = Auxiliary.dequeue();}
                else{ chosenProcess = readyQueue.dequeue();}
                
                cpu.dispatch(chosenProcess);
                System.out.println("the chosen process "+chosenProcess.getName()+" is dispatched to the CPU at "+stopwatch);
                

                nextCPUtime = chosenProcess.getNextCPUtime(stopwatch); // get the time, the proces will be in the CPU (always less than or equal to time slice)
                System.out.println(nextCPUtime+"*******************");
                
                cpu.execute(nextCPUtime, chosenProcess);
                
                
                // if this chosen process will get blocked due to an IO request after dispatching
                if(chosenProcess.isIOhappens()){
                     // wait before blocking the running process (no more than a timeslice)
                    try {
                        Thread.sleep((long) (nextCPUtime*1000)); // 1000 because of sleep() takes milliseconds.   
                        stopwatch+=nextCPUtime;                 

                    } catch (InterruptedException ex) {
                        System.out.println("interrupted"); //continue sending new processes to the ready queue
                    } 
                     //block the running process 
                    blockedProcess = cpu.block();
                    System.out.println("the running process "+blockedProcess.getName()+" is blocked at "+stopwatch+"s");
                    
                     // add the blocked process in to the IO queue 
                    IoWaiting.enqueue(blockedProcess);
                    System.out.println("the blocked process "+blockedProcess.getName()+" is enqueed to the IO Queue at "+stopwatch+"s");
                    

                }
                
                // if this chosen process will get preempted, without being blocked dueto an IO request after dispatching
                else{
                    
                    // wait before preempting the running process
                    try {
                        Thread.sleep((long) (nextCPUtime*1000)); // 1000 because of sleep() takes milliseconds.   
                        stopwatch+=nextCPUtime;                 

                    } catch (InterruptedException ex) {
                        System.out.println("interrupted"); //continue sending new processes to the ready queue
                    } 
                    //preempt the running process 
                    preemptedProcess = cpu.preempt();
                    System.out.println("the running process "+preemptedProcess.getName()+" is preempted at "+stopwatch+"s");

                    // add the preempted process in to the ready queue if there is remainig service time to do, else relese the process
                    if(preemptedProcess.getNextCPUtime(stopwatch)> 0){
                      
                        readyQueue.enqueue(preemptedProcess);
                        System.out.println("the preempted process "+preemptedProcess.getName()+" is enqueed backck to the ready Queue at "+stopwatch+"s");
                    }
                    else{
                        System.out.println("the preempted process "+preemptedProcess.getName()+" is released at "+stopwatch+"s");
                    }
                    
                }
                
                
                
                
                
               

            }
        }
    }
    
    
    

    
    
 
    
}
