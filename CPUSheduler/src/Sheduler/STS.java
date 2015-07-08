/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheduler;

import Processes.Process;
import computer.CPU;
import computer.MainMemmory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//  STS = Short Time Sheduler
/**
 *
 * @author Malith
 */
public class STS {
    
    ArrayList<Process> processList;
    CPU cpu;
    MainMemmory mainMemmory;
    
    Dispatcher dispatcher= new Dispatcher();

    public STS(ArrayList<Process> processList, CPU cpu, MainMemmory mainMemmory) {
        this.processList = processList;
        this.cpu = cpu;
        this.mainMemmory = mainMemmory;
    }
    
 
    public void shedule(){
        for (Process process : processList) {
            dispatcher.switchContex(process,cpu, mainMemmory);
            cpu.runProcess();
                   
            try {
                Thread.sleep((long) process.getTimeSlice()*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(STS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
