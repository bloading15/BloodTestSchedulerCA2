/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.io.*;
import java.util.*;

/**
 *
 * @author General
 */
public class FileHandler {
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String NOSHOWS_FILE = "noshows.txt";

    /**
     * Save the current queue of patients to a file.
     * @param queue The priority queue containing patient information.
     */
    public static void savePatientsToFile(PriorityQueue<Person> queue) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            for (Person person : queue) {
                String line = String.join(",",
                        person.getName(),
                        person.getPriority(),
                        person.getGPDetails(),
                        String.valueOf(person.getAge()),
                        String.valueOf(person.isFromHospital()));
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving patients to file: " + e.getMessage());
        }
    }

    /**
     * Load patients from a file into a priority queue.
     * @return A priority queue containing patient information.
     */
    public static PriorityQueue<Person> loadPatientsFromFile() {
        PriorityQueue<Person> queue = new PriorityQueue<>((p1, p2) -> {
            int urgency1 = getUrgencyValue(p1.getPriority());
            int urgency2 = getUrgencyValue(p2.getPriority());

            // Compare by urgency
            if (urgency1 != urgency2) {
                return Integer.compare(urgency1, urgency2);
            }

            // Compare by hospital status
            if (p1.isFromHospital() && !p2.isFromHospital()) {
                return -1;
            } else if (!p1.isFromHospital() && p2.isFromHospital()) {
                return 1;
            }

            // Compare by age priority
            boolean p1AgePriority = (p1.getAge() > 50 || p1.getAge() < 13);
            boolean p2AgePriority = (p2.getAge() > 50 || p2.getAge() < 13);

            if (p1AgePriority && !p2AgePriority) {
                return -1;
            } else if (!p1AgePriority && p2AgePriority) {
                return 1;
            }

            // Compare by descending age
            return Integer.compare(p2.getAge(), p1.getAge());
        });

        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String priority = parts[1];
                String gpDetails = parts[2];
                int age = Integer.parseInt(parts[3]);
                boolean fromHospital = Boolean.parseBoolean(parts[4]);

                queue.add(new Person(name, priority, gpDetails, age, fromHospital));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing patient data file found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading patients from file: " + e.getMessage());
        }
        return queue;
    }

    /**
     * Save a no-show patient to a file.
     * @param person The patient marked as a no-show.
     */
    public static void saveNoShowToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOSHOWS_FILE, true))) {
            String line = String.join(",",
                    person.getName(),
                    person.getPriority(),
                    person.getGPDetails(),
                    String.valueOf(person.getAge()),
                    String.valueOf(person.isFromHospital()));
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving no-show patient: " + e.getMessage());
        }
    }

    /**
     * Load all no-show patients from a file.
     * @return A list containing all no-show patients.
     */
    public static List<Person> loadNoShowFromFile() {
        List<Person> noShows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOSHOWS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String priority = parts[1];
                String gpDetails = parts[2];
                int age = Integer.parseInt(parts[3]);
                boolean fromHospital = Boolean.parseBoolean(parts[4]);

                noShows.add(new Person(name, priority, gpDetails, age, fromHospital));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing no-show data file found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading no-show patients: " + e.getMessage());
        }
        return noShows;
    }

    /**
     * Helper method to map urgency to priority values.
     * @param urgency The urgency string (e.g., "Urgent", "Medium", "Low").
     * @return An integer representing the urgency priority.
     */
    private static int getUrgencyValue(String urgency) {
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
}
