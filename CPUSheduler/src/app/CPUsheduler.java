/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import computer.CPU;
import Sheduler.STS;
import Processes.Process;
import Sheduler.LTS;
import com.google.common.base.Stopwatch;
import computer.MainMemmory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malith
 */
public class CPUsheduler {
       
    public CPUsheduler() {
        long stopwatch = 0;
        
        ArrayList<Process> processList =new ArrayList<>();
        Process a = new Process(0, 3, 1);
        Process b = new Process(2, 6, 1);
        
        processList.add(a);
        processList.add(b);
        
        CPU cpu= new CPU();
        MainMemmory mainMemmory = new MainMemmory();
        
        
        
        // start the Long Time Sheduler thread
        Thread lts = new Thread(new LTS(processList, mainMemmory, stopwatch));
        Thread sts = new Thread(new STS(processList, cpu, mainMemmory, stopwatch));
        lts.start();
        sts.start();
        
        
        
        
    }
    
    
    public static void main (String[] args){
        new CPUsheduler();
        
    }
}
