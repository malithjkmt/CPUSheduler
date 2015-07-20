package computer;


import Processes.Process;
/**
 *
 * @author Malith
 */
public class CPU {
      private Process runningProcess;

    public Process getRunningProcess() {
        return runningProcess;
    }

    public void dispatch(Process process) {
        this.runningProcess = process;
    }
    
    public void execute(long nextCPUtime, Process process){
        runningProcess.runProcess(nextCPUtime);
        //chankasClass.CPUgrid.stopColoringCurrentProcess(process.name);
        //chankasClass.CPUgrid.StartColoring(process.name);
    }
    public Process preempt(){
        return runningProcess;
    }
    public Process block(){
        return runningProcess;
    }
      
}
