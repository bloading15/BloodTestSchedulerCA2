/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author General
 */
public class Person implements PersonInterface, Comparable<Person> {
    
    private String name;
    private String priority;
    private String gpDetails;
    private int age;
    private boolean fromHospital;

    public Person(String name, String priority, String gpDetails, int age, boolean fromHospital) {
        this.name = name;
        this.priority = priority;
        this.gpDetails = gpDetails;
        this.age = age;
        this.fromHospital = fromHospital;
    }
@Override
        public String getName(){
            return name;
        }

@Override
        public String getPriority(){
            return priority;
        }
        
@Override
        public String getGPDetails(){
            return gpDetails;
        }
        
@Override
        public int getAge(){
            return age;
        }
        
@Override
        public boolean isFromHospital(){
            return fromHospital;
        }
        
@Override
        public int compareTo(Person other){
            if (this.priority.equals(other.priority)){
                return Integer.compare(other.age, this.age);
            }
            return this.priority.compareTo(other.priority);
        }
        
}
