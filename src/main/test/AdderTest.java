package main.test;

import main.java.Adder;
import main.java.IncorrectFormatException;
import main.java.NegativeNumberException;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @Test
    void addBlankString() {
        Adder addObj = new Adder();
        try {
            Integer result = addObj.add("");
            assertEquals(0, result);

            result = addObj.add("   ");
            assertEquals(0, result);

        } catch (NegativeNumberException | IncorrectFormatException e) {
            e.printStackTrace();
        }

    }

    @Test
    void addNormalString() {
        Adder addObj = new Adder();
        try {
            Integer result = addObj.add("1,2,3");
            assertEquals(6, result);

            result = addObj.add("0,0,0");
            assertEquals(0, result);

            result = addObj.add("1");
            assertEquals(1, result);

            result = addObj.add("1,2,3,4,5,6,7");
            assertEquals(28, result);

            result = addObj.add("1\r\n2,3");
            assertEquals(6, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addWithDelimiterString() {
        Adder addObj = new Adder();
        try {
            Integer result = addObj.add("//;\r\n1;2");
            assertEquals(3, result);
            result=addObj.add("///\r\n1/2/3");
            assertEquals(6,result);
        } catch (NegativeNumberException | IncorrectFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addExceptionString() {
        Adder addObj = new Adder();
        try {
            Integer result = addObj.add("-1,-2,3,4");
            result = addObj.add("1   2;3,4");
        } catch (NegativeNumberException e) {
            assertEquals("Negatives not allowed. The negative numbers are: -1,-2.", e.getMessage());
        } catch (IncorrectFormatException e) {
            assertEquals("Incorrect format provided.", e.getMessage());
        }
    }
}