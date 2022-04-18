package main.test;

import main.java.Adder;
import main.java.IncorrectFormatException;
import main.java.NegativeNumberException;
import org.junit.jupiter.api.Test;
import org.junit.*;


import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @Test
    void add() {
        Adder addObj=new Adder();
        try{
            Integer result= addObj.add("1,2,3");
            assertEquals(6,result);
            result= addObj.add("0,0,0");
            assertEquals(0,result);
            result= addObj.add("1");
            assertEquals(1,result);

            result= addObj.add("");
            assertEquals(0,result);
            result= addObj.add("   ");
            assertEquals(0,result);

            result=addObj.add("1,2,3,4,5,6,7");
            assertEquals(28,result);

            result= addObj.add("1\n2,3");
            assertEquals(6,result);

            result= addObj.add("//;\n1;2");
            assertEquals(5,result);

            result=addObj.add("-1,-2,3,4");

            result= addObj.add("1   2;3,4");
        } catch (NegativeNumberException e){
            assertEquals("Negatives not allowed. The negative numbers are: -1,-2.",e.getMessage());
        } catch (IncorrectFormatException e){
            assertEquals("Incorrect format provided.",e.getMessage());
        }

    }

}