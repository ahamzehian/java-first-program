package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        float[] credits = new float[creditsAsString.length];
        float[] debits = new float[debitsAsString.length];

        for(int i=0;i< creditsAsString.length;i++){
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }
        for(int i=0;i< debitsAsString.length;i++){
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = "
            + calculator.remainingDaysInMonth(LocalDate.now()));
    }

    public SavingsCalculator(float[] credits, float[] debits){
        this.credits = credits;
        this.debits = debits;
    }

    // Return sum of all credits in the credits array
    private float sumOfCredits(){
        float sum = 0.0f;
        for(float f:credits){
            sum += f;
        }
        return sum;
    }

    // Return sum of all credits in the debits array
    private float sumOfDebits(){
        float sum = 0.0f;
        for(float f:debits){
            sum += f;
        }
        return sum;
    }

    // Return how many days remain in current month from the date has been entered
    private int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(),date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;

        // better to just return the remaining function like next line
//        return totalDaysInMonth - date.getDayOfMonth();
    }

    // Return the difference between sum of credits and sum of debits
    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }

}
