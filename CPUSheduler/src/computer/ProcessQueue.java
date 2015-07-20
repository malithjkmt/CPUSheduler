
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
    
  
    public synchronized void enqueue(Process process){
        queue.add(process);
        //can get the name of the queue (r, I, A) and call Chanaka's class's method
    }
    public synchronized Process dequeue(){
        return queue.remove();
    }
    public synchronized boolean isEmpty(){
        return queue.size()==0;
    }
}
