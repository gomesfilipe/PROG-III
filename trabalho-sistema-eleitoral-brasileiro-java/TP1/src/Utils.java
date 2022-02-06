package TP1;

import java.util.Calendar;

public class Utils {
    public static double percent(double value, double total) {
        if(total == 0) return -1; //Retorna -1 em caso de indeterminação da divisão
        return value / total * 100.0;
    }
    
    public static Calendar convertDate(String dateString) {
    	String[] parts = dateString.split("/"); 
        int day = Integer.parseInt(parts[0]);     
        int month = Integer.parseInt(parts[1]) - 1; // Months: 0 to 11
        int year = Integer.parseInt(parts[2]);
             
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.YEAR, year);
        return date;
    }
}
