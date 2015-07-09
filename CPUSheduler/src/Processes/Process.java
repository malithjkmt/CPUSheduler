/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processes;

/**
 *
 * @author Malith
 */
public  class Process {
    final long arrivalTime;
    final long serviceTime;
    long timeSlice;
    long remainingServiceTime;
    

    public Process(long arrivalTime, long serviceTime, long timeSlice) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
    }

    public long getTimeSlice() {
        return timeSlice;
    }

    public long getRemainingServiceTime() {
        return remainingServiceTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
    public void runProcess(){
        remainingServiceTime -=timeSlice;
        
    }
}
