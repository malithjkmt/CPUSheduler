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
    int index;
    final double arrivalTime;
    final double serviceTime;
    final double initialTimeSlice;
    double timeSlice;
    double remainingServiceTime;
    
    double IORequestTime =10000; //  time after arrival which the process request an IO 
    double IOCostTime; // time duration that takes to get the IO request
    boolean IOhappens; // this will be tue if this process will blocked due to an IO request before timeout.
    double totalCPUburst = 0;
    boolean hasIOrequest;

   
    public Process(double arrivalTime, double serviceTime, double timeSlice, int index) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.initialTimeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
        this.index = index;
        hasIOrequest = false;
        IOhappens = false;
    }
    
    // If user inputs an IO bound process
    public Process(double arrivalTime, double serviceTime, double timeSlice, int index, double IORequestTime, double IOCompetionTime) {
        System.out.println("******************************");
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSlice = timeSlice;
        this.initialTimeSlice = timeSlice;
        this.remainingServiceTime = serviceTime;
        this.index = index;
        
        hasIOrequest = true;
        this.IORequestTime = IORequestTime;
        this.IOCostTime = IOCompetionTime;
        //IOhappens = IORequestTime < timeSlice || IORequestTime == timeSlice;
       IOhappens = true;
    }

    public synchronized void setIOhappens(boolean IOhappens) {
        this.IOhappens = IOhappens;
    }

    public double getIOCostTime() {
        return IOCostTime;
    }
    
    public synchronized double getRemainingServiceTime() {
        return remainingServiceTime;
    }
    
    public boolean isIOhappens() {
        return IOhappens;
    }
    
    
    public synchronized int getName() {
        return index;
    }

    public void setTimeSlice(double timeSlice) {
        this.timeSlice = timeSlice;
    }
    
    public synchronized double getTimeSlice() {
        return timeSlice;
    }

  

    public synchronized double getArrivalTime() {
        return arrivalTime;
    }
    public void runProcess(double nextCPUtime){
        remainingServiceTime -=nextCPUtime;  
        totalCPUburst+=nextCPUtime;
    }
    
    //get the time period that the process will be in the CPU next
   public synchronized double getNextCPUtime(double stopwatch){
        if(timeSlice != initialTimeSlice){
            setIOhappens(false);
            double temp = timeSlice;
            timeSlice = initialTimeSlice;
            return temp;
        }
        double timeSpent = stopwatch- arrivalTime; // (cpu burst + io burst)
        double DueTimeToIORequest = IORequestTime - totalCPUburst; // the remainig time before the IO request happens
        
        
        // if the process's service time is over in between the next timeslice
        if(remainingServiceTime<timeSlice){
            setIOhappens(false);//??? do I need this
            return remainingServiceTime;
        }
        // if the process will be blocked before being timeout
        if(hasIOrequest && IORequestTime > totalCPUburst && DueTimeToIORequest <= timeSlice){// watchout when using auxiliry queue 
            setIOhappens(true);
            timeSlice = DueTimeToIORequest;
            return DueTimeToIORequest;
        }
        else if(remainingServiceTime>0){
            setIOhappens(false);
            timeSlice = initialTimeSlice;
            return timeSlice;
        }
        return 0;
    }

    public boolean getHasIOrequest() {
        return hasIOrequest;
    }

    public double getIORequestTime() {
        return IORequestTime;
    }

    public void setHasIOrequest(boolean hasIOrequest) {
        this.hasIOrequest = hasIOrequest;
    }
  
   
}
