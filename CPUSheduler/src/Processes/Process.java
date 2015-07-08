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
    final int arrivalTime;
    final int serviceTime;
    float timeSlice;
    float remainingServiceTime;

    public Process(int arrivalTime, int serviceTime, float timeSlice) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
    }

    public float getTimeSlice() {
        return timeSlice;
    }

    public void setTimeSlice(float timeSlice) {
        this.timeSlice = timeSlice;
    }

    public void setRemainingServiceTime(float remainingServiceTime) {
        this.remainingServiceTime = remainingServiceTime;
    }
    
    public void decrementServiceTime(){
        remainingServiceTime -=timeSlice;
    }
}
