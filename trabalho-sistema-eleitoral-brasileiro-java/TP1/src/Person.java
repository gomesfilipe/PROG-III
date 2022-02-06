package TP1;

import java.util.Calendar;
import java.util.Formatter;
import java.time.*;  

public class Person {
    private String name;
    private char gender;
    private Calendar birth;

    public Person(String name, char gender, String date) {
        this.name = name;
        this.gender = gender;
        this.birth = Utils.convertDate(date);
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
    
    /**
	 * @brief Método que auxilia a impressão de uma pessoa.
	 * @return String que contém os campos de uma pessoa.
	 */
    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Name: %s\nGender: %c\nBirth: %02d/%02d/%04d\n", this.name, this.gender, this.birth.get(Calendar.DAY_OF_MONTH), this.birth.get(Calendar.MONTH), this.birth.get(Calendar.YEAR));
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }
    
    /**
     * @brief Imprime uma pessoa.
     */
    public void printPerson(){
        System.out.println(this.toString());
    }
    
    /**
	 * @brief Esse método calcula a idade de uma pessoa numa data específica.
	 * @return Retorna a idade da pessoa.
	 */
    public int age(Calendar date) {
        int day_election = date.get(Calendar.DAY_OF_MONTH); 
    	int month_election = date.get(Calendar.MONTH) + 1; 
        int year_election = date.get(Calendar.YEAR); 
        		
    	LocalDate date_election = LocalDate.of(year_election, month_election, day_election);
        int day = this.birth.get(Calendar.DAY_OF_MONTH);
        int month = this.birth.get(Calendar.MONTH) + 1;
        int year = this.birth.get(Calendar.YEAR);
        
        LocalDate birth = LocalDate.of(year, month, day); 
        
        Period age = Period.between(birth, date_election);
              
        return age.getYears();  
    }
}
