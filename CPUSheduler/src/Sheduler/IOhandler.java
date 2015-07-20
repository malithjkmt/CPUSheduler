/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheduler;

import computer.ProcessQueue;
import Processes.Process;
import computer.MainMemmory;
/**
 *
 * @author Malith
 */
public class IOhandler implements Runnable{
    ProcessQueue readyQueue;
    ProcessQueue IoWaiting;
    long stopwatch;
    Process chosenProcess;
    long blockingPeriod;
    

    public IOhandler(MainMemmory mainMemmory, long stopwatch) {
        this.readyQueue = mainMemmory.getReadyQueue();
        this.IoWaiting = mainMemmory.getIoWaiting();
        this.stopwatch = stopwatch;
        
    }
    
    
    
    @Override
    public void run() {
        while(true){
            
            if(!IoWaiting.isEmpty()){
                 chosenProcess = IoWaiting.dequeue();
                blockingPeriod = chosenProcess.getIOCostTime();
                
                 // wait until IOrequest complete
                try {
                    Thread.sleep((long) blockingPeriod*1000); // 1000 because of sleep() takes milliseconds.              

                } catch (InterruptedException ex) {
                    System.out.println("interrupted"); //continue sending new processes to the ready queue
                } 
               
                // transfer the IO request gained process to the ready queue
                readyQueue.enqueue(chosenProcess);
               
                System.out.println("the blocked process "+chosenProcess.getName()+" is sent to the rrrready queue at "+stopwatch+"s");
            }
            else{}
            
        }
    }
    
}
