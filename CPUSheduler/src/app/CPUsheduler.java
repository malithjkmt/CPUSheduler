/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import computer.CPU;
import Sheduler.STS;
import Processes.Process;
import Sheduler.IOhandler;
import Sheduler.LTS;

import computer.MainMemmory;
import java.util.ArrayList;


/**
 *
 * @author Malith
 */
public class CPUsheduler {
       public double stopwatch = 0;
    public CPUsheduler() {
        stopwatch = 0;
       
        ArrayList<Process> processList =new ArrayList<>();
        int timeSlice = 4;
        Process a = new Process(0, 3, timeSlice,0);
        Process b = new Process(2, 6, timeSlice,1);
        Process c = new Process(4, 4, timeSlice,2);
        Process d = new Process(6, 5, timeSlice,3);
        Process e = new Process(8, 2, timeSlice,4);
        
        
        
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
        Thread ioHandler = new Thread(new IOhandler(mainMemmory, stopwatch));
        
        lts.start();
        sts.start();
        ioHandler.start();
       
        
        
        
    }
    
    
    public static void main (String[] args){
        new CPUsheduler();
        
    }

    public synchronized double getStopwatch() {
        return stopwatch;
    }

    public synchronized void setStopwatch(double stopwatch) {
        this.stopwatch = stopwatch;
    }
    
}
