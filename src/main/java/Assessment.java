package main.java;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Assessment {
    private static Logger logger=Logger.getLogger(Assessment.class);

    public static void main(String[] args) {
        Adder adder=new Adder();
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                StringBuilder input = new StringBuilder();

                while (true) {
                    String temp = scanner.nextLine();
                    if (temp.isEmpty()) break;
                    input.append(temp).append(System.lineSeparator());
                }
                System.out.println("The result is "+adder.add(input.toString()));
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
    }
}
