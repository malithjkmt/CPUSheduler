package Sheduler;

import Processes.Process;
import computer.CPU;
import computer.MainMemmory;
/**
 *
 * @author Malith
 */
public class Dispatcher {
    
    public void switchContex(Process newProcess, CPU cpu, MainMemmory mainMemmory){
        System.out.println("switch contex");
        
        mainMemmory.getReadyQueue().add(cpu.getRunningProcess());
        cpu.setRunningProcess(newProcess);
        
        
        
       
    }
}
