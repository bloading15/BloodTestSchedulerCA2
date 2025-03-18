/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 *
 * @author General
 */
public class FileHandler {
    private static final String FILE_NAME = "Patients.txt";

    // Save patient data to file
    public static void savePatientsToFile(PriorityQueue<Person> queue) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
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

    // Load patient data from file
    public static PriorityQueue<Person> loadPatientsFromFile() {
        PriorityQueue<Person> queue = new PriorityQueue<>((p1, p2) -> {
            int priorityComparison = p1.getPriority().compareTo(p2.getPriority());
            if (priorityComparison != 0) {
                return priorityComparison;
            }
            if (p1.isFromHospital() && !p2.isFromHospital()) {
                return -1;
            } else if (!p1.isFromHospital() && p2.isFromHospital()) {
                return 1;
            }
            return Integer.compare(p2.getAge(), p1.getAge());
        });

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
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
            System.out.println("No existing data file found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading patients from file: " + e.getMessage());
        }

        return queue;
    }
}
