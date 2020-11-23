package com.h2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Getting applicant's name and greeting
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

        // Getting loan terms in year
        System.out.println("Enter the loan terms (in years)");
        int loanTermsInYear = scanner.nextInt();

        // Processing the best rate for input loan terms
        float bestRate = getRates(loanTermsInYear);
        System.out.println(bestRate==0.0f ? ("No available rates for term: " + loanTermsInYear +
                "years"):("Best Available Rates: " + bestRate + "%"));

        scanner.close();
    }

    // Mapping best rates
    public static final Map<Integer, Float> bestRates = new HashMap<>(Map.of(1,5.50f,2,3.45f,3,2.67f));

    // Getting rates according to their terms and returning 0.0f as default
    public static float getRates(int loanTermInYears){
        return (bestRates.containsKey(loanTermInYears)?bestRates.get(loanTermInYears):0.0f);
        // Easier to use following line instead.
//        return (bestRates.getOrDefault(loanTermInYears, 0.0f));
    }
}
