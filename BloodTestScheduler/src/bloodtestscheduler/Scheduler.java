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
           // Step 1: Define urgency mapping
            int urgency1 = getUrgencyValue(p1.getPriority());
            int urgency2 = getUrgencyValue(p2.getPriority());

            // Step 2: Compare urgency
            if (urgency1 != urgency2) {
                return Integer.compare(urgency1, urgency2); // Lower value = higher priority
            }

            // Step 3: Sort by hospital status
            if (p1.isFromHospital() && !p2.isFromHospital()) {
                return -1; // p1 gets higher priority
            } else if (!p1.isFromHospital() && p2.isFromHospital()) {
                return 1; // p2 gets higher priority
            }

            // Step 4: Sort by age priority
            boolean p1AgePriority = (p1.getAge() > 50 || p1.getAge() < 13);
            boolean p2AgePriority = (p2.getAge() > 50 || p2.getAge() < 13);

            if (p1AgePriority && !p2AgePriority) {
                return -1; // p1 gets higher priority
            } else if (!p1AgePriority && p2AgePriority) {
                return 1; // p2 gets higher priority
            }

            // Step 5: Sort by descending age (older patients get higher priority)
            return Integer.compare(p2.getAge(), p1.getAge());
        });
    }

    // Helper method to map urgency to priority values
    private int getUrgencyValue(String urgency) {
        switch (urgency.toLowerCase()) {
            case "urgent":
                return 1; // Highest priority
            case "medium":
                return 2;
            case "low":
                return 3; // Lowest priority
            default:
                return Integer.MAX_VALUE; // Handle unexpected values
        }
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
