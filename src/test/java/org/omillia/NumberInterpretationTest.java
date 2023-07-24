package org.omillia;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class NumberInterpretationTest {

    @Mock
    NumberInterpretation numberInterpretation;



    @Test
    void testShouldTrueMessageWhenGivenWrongNumberInput() {

        String userInput = "no characters allowed";
        boolean result = true;
        Assertions.assertEquals(result, InputValidations.isPhoneNumberValid(userInput));
    }

    @Test
    void testShouldReturnListOfInterpretationsWhenGetAllCombinationInvokedGivenValidInput() {
        List<String> expectedInterpretationList = new ArrayList<>();
        expectedInterpretationList.add("2106930664");
        expectedInterpretationList.add("210693664");
        expectedInterpretationList.add("2106093664");
        expectedInterpretationList.add("21060930664");
        List<String> userInputList = new ArrayList<>(Collections.singleton("2 10 69 30 6 6 4"));


        doReturn(expectedInterpretationList).when(numberInterpretation).getAllCombination(any());

        List<String> actualResult = numberInterpretation.getAllCombination(userInputList);

        assertEquals(expectedInterpretationList, actualResult);

    }


}