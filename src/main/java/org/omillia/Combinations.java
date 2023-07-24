package org.omillia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Combinations {
    public List<String> getPossibleCombinations(String element) {



        return setPossibleAmbiguities(element);
    }
    private List<String> setPossibleAmbiguities(String element){
        List<String> possibleCombinationList = new ArrayList<>();
        possibleCombinationList.add(element);
        String newStr = element;
        if (element.contains("0")) {
            possibleCombinationList.add(newStr.replaceAll("0", ""));
        }
        else {
            newStr = element.charAt(0) + "0".repeat(Math.max(0, element.length() - 1)) + element.substring(1) ;
            possibleCombinationList.add(newStr);
        }
        return possibleCombinationList;
    }
    public List<String> generateParsedCombinations(List<List<String>> allCombinationsLists) {
        List<String> parsedCombinations = new ArrayList<>();

        for (List<String> combinationList : allCombinationsLists) {
            StringBuilder holder = new StringBuilder();
            for (String num : combinationList) {
                holder.append(num);
            }
            if (!parsedCombinations.contains(holder.toString())) {
                parsedCombinations.add(holder.toString());
            }
        }
        return parsedCombinations;
    }
     public void generateAllPossibleCombinations(Map<Integer, List<String>> interpretationMap, List<List<String>> allCombinations, List<String> baseNumbers) {
        int[] indexArr = new int[interpretationMap.size()];

        while (true) {

            allCombinations.add(new ArrayList<>(baseNumbers));

            int counter = indexArr.length - 1;
            for (; counter >= 0; counter--) {
                indexArr[counter] += 1;
                if (indexArr[counter] < interpretationMap.get(counter).size()) {
                    baseNumbers.set(counter, interpretationMap.get(counter).get(indexArr[counter]));
                    break;
                }
                indexArr[counter] = 0;
                baseNumbers.set(counter, interpretationMap.get(counter).get(indexArr[counter]));
            }
            if (counter < 0)
                break;
        }
    }


}
