/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Malith
 */
public class T implements Runnable{

    @Override
    public void run() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println("Run method called");
        try {
            Thread.sleep(2400);
           
        } catch (InterruptedException ex) {
            
            System.out.println("interupted!!!");
        }
         System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
    }
    
}
