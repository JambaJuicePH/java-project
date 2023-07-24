package org.omillia;


import java.text.NumberFormat;
import java.util.Scanner;

import static org.omillia.InputValidations.isPhoneNumberValid;
import static org.omillia.constants.NaturalNumbersMessageConstants.MESSAGE_PROMPT_PHONE_NUMBER;


public class Main {

    public static void main(String[] args) {
        System.out.print(MESSAGE_PROMPT_PHONE_NUMBER);
        Scanner scanner = new Scanner(System.in);
        NumberInterpretation numberInterpretation = new NumberInterpretation();
        String userInput;
        do {
            userInput = scanner.nextLine();
        } while (isPhoneNumberValid(userInput));
        scanner.close();
        numberInterpretation.getPossibleInterpretations(userInput);


    }
}