package computer;


import Processes.Process;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malith
 */
public class MainMemmory {
    
    private  ProcessQueue readyQueue = null;
    private ProcessQueue Auxiliary = null;
    private  ProcessQueue IoWaiting = null;

    public MainMemmory() {
        this.readyQueue = new ProcessQueue();
        this.Auxiliary  = new ProcessQueue();
        this.IoWaiting  = new ProcessQueue();
    }

  /*  public synchronized void EnqueueToReadyQueue(Process process){
        readyQueue.enqueue(process);
    }
    public synchronized void EnqueueToIOwaitingQueue(Process process){
        IoWaiting.enqueue(process);
    }*/
    
    public synchronized ProcessQueue getReadyQueue() {
        return readyQueue;
    }
    
    public ProcessQueue getAuxiliary() {
        return Auxiliary;
    }

    public synchronized ProcessQueue getIoWaiting() {
        return IoWaiting;
    }  

    public void setReadyQueue(ProcessQueue readyQueue) {
        this.readyQueue = readyQueue;
    }
    
    
}
