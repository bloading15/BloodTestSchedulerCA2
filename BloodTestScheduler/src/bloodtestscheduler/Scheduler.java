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
            
            //  Sort by age priority People Over the age of 50 and under the age of 13 get priorty 
            boolean p1AgePriority = (p1.getAge() > 50 || p1.getAge() < 13);
            boolean p2AgePriority = (p2.getAge() > 50 || p2.getAge() < 13);

            if (p1AgePriority && !p2AgePriority) {
                return -1; // p1 gets higher priority
            } else if (!p1AgePriority && p2AgePriority) {
                return 1; // p2 gets higher priority
            }

            // Step 4: Sort by age (natural order, older first)
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
