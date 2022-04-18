package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {

    public Integer add(String input) throws NegativeNumberException, IncorrectFormatException {
        String negNums;
        String delimiter=",";
        List<Integer> nums=new ArrayList<>();

        String[] lines = input.split(System.getProperty("line.separator"));
        if(StringUtils.isBlank(lines[0])){
            return 0;
        }
        Pattern pattern=Pattern.compile("//(.)");
        Matcher matcher= pattern.matcher(lines[0]);
        boolean changeDelimiter= matcher.find();
        if(changeDelimiter){
            delimiter=getDelimiterUsed(lines[0],pattern);
        }
        int indexOfLoop=0;
        for (String line:lines) {
            if(changeDelimiter&&indexOfLoop==0){
                indexOfLoop++;
                continue;
            }
            getListOfNums(nums,line,delimiter);
            indexOfLoop++;
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

    private String getDelimiterUsed(String delimeterInput,Pattern pattern){
        Matcher matcher=pattern.matcher(delimeterInput);
        return matcher.find() ? matcher.group(1) : null;
    }

    private void getListOfNums(List<Integer> nums,String stringOfNums,String delimiter){
        Arrays.asList(stringOfNums.split(delimiter)).stream().forEach(num->nums.add( Integer.valueOf(num)));
    }
}
