package org.omillia;


import java.util.Arrays;
import java.util.List;

import static org.omillia.constants.NaturalNumbersMessageConstants.*;

public class InputValidations {
    private List<String> phoneNumber;

    public InputValidations() {
    }


    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    void convertPhoneNumberToList(String input) {
        this.phoneNumber = Arrays.asList(input.trim().split("\\s+"));
    }


    static boolean isPhoneNumberValid(String userInput) {
        if (!userInput.matches(NATURAL_NUMBER_INTERPRETATION_REGEX)) {
            System.out.println(PHONE_NUMBER_MESSAGE_INVALID + "Please try again");
            System.out.println(MESSAGE_PROMPT_PHONE_NUMBER);
            return true;
        }
        return false;


    }

    public boolean isAmbiguous(String element, List<String> userInput, int index) {
        int current = Integer.parseInt(element);

        if (current % 10 == 0 && userInput.get(index).length() == 2 && userInput.get(index + 1).length() == 2) {
            return false;
        }
        return current > 20;
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (((phoneNumber.startsWith("2") || phoneNumber.startsWith("69")) && phoneNumber.length() == PHONE_NUMBER_TEN_DIGITS) ||
                ((phoneNumber.startsWith("00302") || phoneNumber.startsWith("003069")) && phoneNumber.length() == PHONE_NUMBER_FOURTEEN_DIGITS)) {
            System.out.println(phoneNumber + PHONE_NUMBER_MESSAGE_VALID);
            return;
        }
        System.out.println(phoneNumber + PHONE_NUMBER_MESSAGE_INVALID);

    }


}
