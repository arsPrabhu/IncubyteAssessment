package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adder {

    public Integer add(String input) throws NegativeNumberException, IncorrectFormatException {
        String negNums;
        Character delimiter;
        List<Integer> nums=new ArrayList<>();

        String[] lines = input.split("\n"); /*System.getProperty("line.separator")*/
        if(StringUtils.isBlank(lines[0])){
            return 0;
        }
        for (String line:lines) {
            getListOfNums(nums,line,',');
        }
        Integer sum= nums.stream().reduce(0,(a,b)->a+b);
        if(false){
            throw new NegativeNumberException(AdderConstants.NEGATIVE_ERROR+ negNums);
        }
        if(false){
            throw new IncorrectFormatException(AdderConstants.INCORRECT_FORMAT_ERROR);
        }
        return sum;
    }

    private Character getDelimiterUsed(String delimeterInput){
        return 0;
    }

    private void getListOfNums(List<Integer> nums,String stringOfNums,Character delimiter){
        Arrays.asList(stringOfNums.split(String.valueOf(delimiter))).stream().forEach(num->nums.add( Integer.valueOf(num)));
    }
}
