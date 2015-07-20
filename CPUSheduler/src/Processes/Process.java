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
    String name;
    final long arrivalTime;
    final long serviceTime;
    long timeSlice;
    long remainingServiceTime;
    
    long IORequestTime =10000; //  time after arrival which the process request an IO 
    long IOCostTime; // time duration that takes to get the IO request
    boolean IOhappens; // this will be tue if this process will blocked due to an IO request before timeout.
    long totalCPUburst = 0;
    boolean hasIOrequest;

   
    public Process(long arrivalTime, long serviceTime, long timeSlice, String name) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
        this.name = name;
        hasIOrequest = false;
        IOhappens = false;
    }
    
    // If user inputs an IO bound process
    public Process(long arrivalTime, long serviceTime, long timeSlice, String name, long IORequestTime, long IOCompetionTime) {
        System.out.println("******************************");
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
        this.name = name;
        
        hasIOrequest = true;
        this.IORequestTime = IORequestTime;
        this.IOCostTime = IOCompetionTime;
        //IOhappens = IORequestTime < timeSlice || IORequestTime == timeSlice;
       IOhappens = true;
    }

    public synchronized void setIOhappens(boolean IOhappens) {
        this.IOhappens = IOhappens;
    }

    public long getIOCostTime() {
        return IOCostTime;
    }
    
    public synchronized long getRemainingServiceTime() {
        return remainingServiceTime;
    }
    
    public boolean isIOhappens() {
        return IOhappens;
    }
    
    
    public synchronized String getName() {
        return name;
    }
    
    public synchronized long getTimeSlice() {
        return timeSlice;
    }

  

    public synchronized long getArrivalTime() {
        return arrivalTime;
    }
    public void runProcess(long nextCPUtime){
        remainingServiceTime -=nextCPUtime;  
        totalCPUburst+=nextCPUtime;
    }
   public synchronized long getNextCPUtime(long stopwatch){
       
        long timeSpent = stopwatch- arrivalTime; // (cpu burst + io burst)
        long DueTimeToIORequest = IORequestTime - totalCPUburst; // the remainig time before the IO request happens
       
        // if the process will be blocked before being timeout
        if(hasIOrequest && ((IORequestTime + arrivalTime-stopwatch)>=0)){// watchout when using auxiliry queue 
            setIOhappens(true);
            return DueTimeToIORequest;
        }
        else if(remainingServiceTime>0){
            setIOhappens(false);
            return timeSlice;
        }
        return 0;
    }

    public boolean getHasIOrequest() {
        return hasIOrequest;
    }

    public long getIORequestTime() {
        return IORequestTime;
    }

    public void setHasIOrequest(boolean hasIOrequest) {
        this.hasIOrequest = hasIOrequest;
    }
  
   
}
