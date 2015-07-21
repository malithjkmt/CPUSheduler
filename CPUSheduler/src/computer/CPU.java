package computer;


import Processes.Process;
import app.OSGUI;
/**
 *
 * @author Malith
 */
public class CPU {
      private Process runningProcess;
      OSGUI gui;
      
    public CPU(OSGUI gui) {
       this.gui = gui;
    }

    public CPU() {
    }

    public Process getRunningProcess() {
        return runningProcess;
    }

    public void dispatch(Process process) {
        this.runningProcess = process;
    }
    
    public void execute(double nextCPUtime, Process process){
        runningProcess.runProcess(nextCPUtime);
        
        
        
        gui.Display(process.getName(), (int) nextCPUtime);
        System.out.println(process.getName() + "*************************"+ (int)nextCPUtime);
        //chankasClass.CPUgrid.StartColoring(process.name);
    }
    public Process preempt(){
        return runningProcess;
    }
    public Process block(){
        return runningProcess;
    }
      
}
