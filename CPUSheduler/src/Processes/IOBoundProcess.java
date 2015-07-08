
package Processes;

/**
 *
 * @author Malith
 */
public class IOBoundProcess extends Process{
    final int IORequestTime;
    float availableTimeSlice;

    public IOBoundProcess(int IORequestTime, float availableTimeSlice, int arrivalTime, int serviceTime, float timeSlice) {
        super(arrivalTime, serviceTime, timeSlice);
        this.IORequestTime = IORequestTime;
        this.availableTimeSlice = availableTimeSlice;
    }

    
    
}
