package rfm;

import rfm.command.Command;
import rfm.parser.CommandParser;

import java.util.Scanner;

public class Rfm {
    public static void main(String[] args){
        System.out.println("Hello");
        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println(">");
            String input=scanner.nextLine();

            Command command=CommandParser.parser(input);
            command.execute();
        }
    }
}
