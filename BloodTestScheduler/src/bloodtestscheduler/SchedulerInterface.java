/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler;

import java.util.PriorityQueue;

/**
 *
 * @author General
 */
public interface SchedulerInterface {
    
    void addPerson (Person person);
    Person getNextPerson();
    PriorityQueue<Person> getQueue();
    
}
