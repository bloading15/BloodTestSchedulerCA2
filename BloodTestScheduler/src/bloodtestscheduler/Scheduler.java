package bloodtestscheduler;


import java.util.PriorityQueue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author General
 */
public class Scheduler {
   private PriorityQueue<Person> queue;

    public Scheduler() {
        queue = new PriorityQueue<>((p1, p2) -> {
            // Sort by priority: Urgent > Medium > Low
            int priorityComparison = p1.getPriority().compareTo(p2.getPriority());
            if (priorityComparison != 0) {
                return priorityComparison;
            }
            // Sort by hospital status: Hospital patients get higher priority
            if (p1.isFromHospital() && !p2.isFromHospital()) {
                return -1;
            } else if (!p1.isFromHospital() && p2.isFromHospital()) {
                return 1;
            }
            // Sort by age: Older patients get higher priority
            return Integer.compare(p2.getAge(), p1.getAge());
        });
    }

    public void addPerson(Person person) {
        queue.add(person);
    }

    public Person getNextPerson() {
        return queue.poll();
    }

    public PriorityQueue<Person> getQueue() {
        return queue;
    }
}
