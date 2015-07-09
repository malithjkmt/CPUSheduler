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
        Process a = new Process(0, 3, 1,"a");
        Process b = new Process(2, 6, 1,"b");
        Process c = new Process(4, 4, 1,"c");
        Process d = new Process(6, 5, 1,"d");
        Process e = new Process(8, 2, 1,"e");
       
        
        
        processList.add(a);
        processList.add(b);
        processList.add(c);
        processList.add(d);
        processList.add(e);
    
        
        
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
