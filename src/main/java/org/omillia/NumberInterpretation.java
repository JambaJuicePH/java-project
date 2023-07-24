package org.omillia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberInterpretation {
    InputValidations inputValidations = new InputValidations();
    Combinations combinations = new Combinations();

    public void getPossibleInterpretations(String userInput) {
        inputValidations.convertPhoneNumberToList(userInput);
        List<String> finalInterpretationList = getAllCombination(inputValidations.getPhoneNumber());
        generateNumberInterpretation(finalInterpretationList);

    }

    public List<String> getAllCombination(List<String> numberInputList) {
        Map<Integer, List<String>> interpretationMap = convertInputToMap(numberInputList);
        List<String> baseNumbers = new ArrayList<>();
        List<List<String>> allCombinationsLists = new ArrayList<>();

        interpretationMap.forEach((key,value) -> baseNumbers.add(value.get(0)));

        combinations.generateAllPossibleCombinations(interpretationMap,allCombinationsLists,baseNumbers);


        return combinations.generateParsedCombinations(allCombinationsLists);
    }



    private Map<Integer, List<String>> convertInputToMap(List<String> numberInputList) {
        Map<Integer, List<String>> interpretationMap = new HashMap<>();
        int index = 0;
        for (String input : numberInputList) {
            if (inputValidations.isAmbiguous(input, numberInputList, index)) {
                interpretationMap.put(index, combinations.getPossibleCombinations(input));
            } else {
                List<String> interpretationList = new ArrayList<>();
                interpretationList.add(input);
                interpretationMap.put(index, interpretationList);
            }
            index++;
        }
        return interpretationMap;

    }


    private void generateNumberInterpretation(List<String> finalInterpretationList) {
        finalInterpretationList.forEach(number -> inputValidations.validatePhoneNumber(number));
    }
}
