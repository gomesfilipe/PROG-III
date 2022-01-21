package TP1;

import java.util.Calendar;
import java.util.Formatter;
import java.time.*;  


public class Person {
    String name;
    char gender;
    Calendar birth;

    public Person(String name, char gender, String date) {
        this.name = name;
        this.gender = gender;
        
        String[] parts = date.split("/"); 
        int day = Integer.parseInt(parts[0]);     
        int month = Integer.parseInt(parts[1]) - 1; // Months: 0 to 11
        int year = Integer.parseInt(parts[2]);
        
        this.birth = Calendar.getInstance();
        birth.set(Calendar.DAY_OF_MONTH, day);
        birth.set(Calendar.MONTH, month);
        birth.set(Calendar.YEAR, year);
    }

    String getName() {
        return this.name;
    }

    char getGender(){
        return this.gender;
    }

    Calendar getBirth() {
        return this.birth;
    }

    // public int compareTo(Person person) {
    //     return this.birth.compareTo(person.birth);
    // }

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Name: %s\nGender: %c\nBirth: %02d/%02d/%04d\n", this.name, this.gender, this.birth.get(Calendar.DAY_OF_MONTH), this.birth.get(Calendar.MONTH), this.birth.get(Calendar.YEAR));
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    public int age() {
        LocalDate date_election = LocalDate.of(2020, 11, 15);
        int day = this.birth.get(Calendar.DAY_OF_MONTH);
        int month = this.birth.get(Calendar.MONTH) + 1;
        int year = this.birth.get(Calendar.YEAR);
        
        //LocalDate birth = LocalDate.of(this.birth.get(Calendar.YEAR), this.birth.get(Calendar.MONTH) + 1, this.birth.get(Calendar.DAY_OF_MONTH)); 
        LocalDate birth = LocalDate.of(year, month, day); 
        
        Period age = Period.between(birth, date_election);
        
        //System.out.println(age.getDays());
        //System.out.println(age.getMonths());
        //System.out.printf("%d \n", age.getYears());
        
        return age.getYears();  
    }

	// public int compareTo(Candidate candidate) {
	// 	// TODO Auto-generated method stub
	// 	return 0;
	// }
}

/*

import java.time.*;  
import java.util.*;  
public class CalculateAgeExample2  
{    
public static void main(String args[])  
{  
//obtains an instance of LocalDate from a year, month and date  
LocalDate dob = LocalDate.of(1988, 12, 13);  
//obtains the current date from the system clock  
LocalDate curDate = LocalDate.now();  
//calculates the difference betwween two dates  
Period period = Period.between(dob, curDate);  
//prints the differnce in years, months, and days  
System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(), period.getDays());  
}  
}  
*/
