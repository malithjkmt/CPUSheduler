
package computer;
import Processes.Process;
import java.util.LinkedList;



/**
 *
 * @author Malith
 */
public class ProcessQueue{
    LinkedList<Process> queue;

    public ProcessQueue() {
        this.queue = new LinkedList<>();
    }
    
  
    public void enqueue(Process process){
        queue.add(process);
    }
    public Process dequeue(){
        return queue.remove();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
