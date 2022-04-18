package main.java;

import org.apache.log4j.Logger;

public class Assessment {
    public static void main(String[] args) {
        final Logger logger=Logger.getLogger(Assessment.class);
        Adder adder=new Adder();
        try{
            System.out.println("The result is "+adder.add("//;\r\n1;2"));
        }catch (Exception e){
//            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }
}
