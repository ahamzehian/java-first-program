import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Finance {

    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public static void main(String[] args) {

        String command = args[0]; // Extract the command from user and check if it is valid
        if(!commandsToUsage.containsKey(command)){
            System.out.println(command + ": command not found");
            return;
        }

        // Check if the correct argument entered for correct command
        boolean isValidCommand = validateCommandArguments(args);
        if(!isValidCommand){
            System.out.println(commandsToUsage.get(command));;
            return;
        }

        // If everything is okay, then it is going to execute according to the input
        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }

    // A map of what each command does
    public final static Map<String, String> commandsToUsage = new HashMap<>(Map.of(
            BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>"
    ));

    // A method to check if there are enough input from user for a specific command
    private static boolean validateCommandArguments(String[] args){

        switch (args[0]){
            case BEST_LOAN_RATES:
                return args.length == 1;
            case SAVINGS_CALCULATOR:
                return args.length == 3;
            case MORTGAGE_CALCULATOR:
                return args.length == 4;
        }
        return false;
    }

    // The method implement the correct command according to what has been asked as command and arguments
    private static void executeCommand(String command, String[] arguments){
        switch (command){
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
                return;
        }
    }

}
