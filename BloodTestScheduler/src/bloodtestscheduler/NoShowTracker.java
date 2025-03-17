/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author General
 */
public class NoShowTracker {
     private Queue<Person> noShowQueue;
    
    public NoShowTracker(){
        noShowQueue = new LinkedList<>();
    }
    
    public void addNoShow(Person person){
        if (noShowQueue.size() >= 5) {
            noShowQueue.poll();
        }
        noShowQueue.add(person);
    }
    
    public Queue<Person> getNoShows(){
        return new LinkedList<>(noShowQueue);
    }



}
