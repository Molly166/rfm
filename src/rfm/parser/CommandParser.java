package rfm.parser;

import rfm.command.*;

public class CommandParser {
    public static Command parser(String input){
        input=input.trim();

        if(input.startsWith("echo")){
            String message=input.substring(5);
            return new EchoCommand(message);
        }else if(input.equals("exit")){
            return new ExitCommand();
        }else{
            return new UnknowCommand(input);
        }
    }
}
