package computer;


import Processes.Process;
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
    private Queue<Processes.Process> readyQueue;
    private Queue<Processes.Process> Auxiliary;
    private Queue<Processes.Process> IoWaiting;

    public Queue<Process> getReadyQueue() {
        return readyQueue;
    }

    public Queue<Process> getAuxiliary() {
        return Auxiliary;
    }

    public Queue<Process> getIoWaiting() {
        return IoWaiting;
    }

    public void setReadyQueue(Queue<Process> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public void setAuxiliary(Queue<Process> Auxiliary) {
        this.Auxiliary = Auxiliary;
    }

    public void setIoWaiting(Queue<Process> IoWaiting) {
        this.IoWaiting = IoWaiting;
    }
    
    
}
