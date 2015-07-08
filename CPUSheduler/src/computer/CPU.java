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

    public void setRunningProcess(Process runningProcess) {
        this.runningProcess = runningProcess;
    }
    
    public void runProcess(){
        runningProcess.decrementServiceTime();
    }
      
}
