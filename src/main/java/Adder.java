package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adder {

    public Integer add(String input) throws NegativeNumberException, IncorrectFormatException {
        String negNums;
        Character delimeter;

        String[] lines = input.split(System.getProperty("line.separator"));
        if(StringUtils.isBlank(lines[0])){
            return 0;
        }
        if(false){
            throw new NegativeNumberException(AdderConstants.NEGATIVE_ERROR+ negNums);
        }
        if(false){
            throw new IncorrectFormatException(AdderConstants.INCORRECT_FORMAT_ERROR);
        }
        return 0;
    }

    private Character getDelimiterUsed(String delimeterInput){
        return 0;
    }

    private List<Integer> getListOfNums(String stringOfNums,Character delimeter){
        return Arrays.asList(0);
    }
}
