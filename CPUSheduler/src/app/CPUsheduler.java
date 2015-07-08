/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import computer.CPU;
import Sheduler.STS;
import Processes.Process;
import computer.MainMemmory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malith
 */
public class CPUsheduler {
       
    public CPUsheduler() {
        
        
        ArrayList<Process> processList =new ArrayList<>();
        Process a = new Process(0, 3, 1);
        Process b = new Process(2, 6, 1);
        
        processList.add(a);
        processList.add(b);
        
        CPU cpu= new CPU();
        MainMemmory mainMemmory = new MainMemmory();
        
        STS sts = new STS(processList, cpu, mainMemmory); 
        sts.shedule();
    }
    
    
    public static void main (String[] args){
        new CPUsheduler();
        
    }
}
