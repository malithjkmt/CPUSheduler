package Sheduler;

import Processes.Process;
import computer.MainMemmory;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.common.base.Stopwatch;
import computer.ProcessQueue;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Malith
 */
public class LTS implements Runnable {
    ArrayList<Processes.Process> processList;
    ProcessQueue readyQueue;
    MainMemmory mainMemmory;
    double interval = 0;
    double stopwatch;   
    public LTS(ArrayList<Process> processList, MainMemmory mainMemmory, double stopwatch) {
        this.processList = processList;
        this.readyQueue = mainMemmory.getReadyQueue();
        this.mainMemmory = mainMemmory;
        this.stopwatch = stopwatch;
    }
    
   

    @Override
    public void run() {
        
        
        for (Process process : processList) {
            
            interval = process.getArrivalTime() - stopwatch; //get the time that the LTS must wait before releasing a new process to the ready queue
            
            // wait before releasing the new process
            try {
                Thread.sleep((long) (interval*1000)); // 1000 because of sleep() takes milliseconds.   
                stopwatch+=interval;
                //release the new process to the ready queue
                readyQueue.enqueue(process);
                
                System.out.println("a new process "+process.getName()+" is added to the ready Queue at "+stopwatch+"s");
            
            } catch (InterruptedException ex) {
                System.out.println("interrupted"); //continue sending new processes to the ready queue
            }   
        }
        
    }   
}
