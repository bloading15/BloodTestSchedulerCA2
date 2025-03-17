
import bloodtestscheduler.Person;
import bloodtestscheduler.SchedulerInterface;
import java.util.PriorityQueue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author General
 */
public class Scheduler implements SchedulerInterface {
    private PriorityQueue<Person> queue;
    
    public Scheduler(){
        queue = new PriorityQueue<>();
    }
    

@Override
    public void addPerson(Person person) {
        queue.add(person);
    }
 
@Override 
    public Person getNextPerson(){
        return queue.poll();
    }
    
@Override 
    public PriorityQueue<Person> getQueue(){
        return queue;
    }
}
