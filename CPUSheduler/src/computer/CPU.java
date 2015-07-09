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
    
    public void execute(){
        runningProcess.runProcess();
    }
    public Process preempt(){
        return runningProcess;
    }
      
}
