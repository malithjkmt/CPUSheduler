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
    
    long stopwatch;

    Process runningProcess = null;
    
    Process chosenProcess = null;
     Process preemptedProcess;
   
    
    public STS(ArrayList<Process> processList, CPU cpu, MainMemmory mainMemmory, long stopwatch) {
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
        while(true){
            
            if(readyQueue.isEmpty()){
                
            }
            else{
                chosenProcess = readyQueue.dequeue();
                cpu.dispatch(chosenProcess);
                System.out.println("the chosen process "+chosenProcess.getName()+" is dispatched to the CPU at "+stopwatch);
                cpu.execute();


                // wait before preempting the running process
                try {
                    Thread.sleep((long) chosenProcess.getTimeSlice()*1000); // 1000 because of sleep() takes milliseconds.   
                    stopwatch+=chosenProcess.getTimeSlice();
                    //preempt the running process 
                    preemptedProcess = cpu.preempt();
                    System.out.println("the running process "+preemptedProcess.getName()+" is preempted at "+stopwatch+"s");
                    
                    // add the preempted process in to the ready queue if there is remainig service time to do, else relese the process
                    if(preemptedProcess.getRemainingServiceTime() > 0){
                        readyQueue.enqueue(preemptedProcess);
                        System.out.println("the preempted process "+preemptedProcess.getName()+" is enqueed backck to the ready Queue at "+stopwatch+"s");
                    }
                    else{
                        System.out.println("the preempted process "+preemptedProcess.getName()+" is relesed  at "+stopwatch+"s");
                    }
                    

                } catch (InterruptedException ex) {
                    System.out.println("interrupted"); //continue sending new processes to the ready queue
                }         

            }
        }
    }
    
    
    

    
    
 
    
}
