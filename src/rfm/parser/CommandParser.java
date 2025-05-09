package rfm.parser;

import rfm.fs.DirectoryContext;
import rfm.command.*;

public class CommandParser {
    private static final DirectoryContext context=new DirectoryContext();

    public static Command parser(String input){
        input=input.trim();

        if(input.startsWith("echo")){
            String message=input.substring(5);
            return new EchoCommand(message);
        }else if(input.startsWith("cd")){
          String dir=input.substring(3).trim();
          return new CdCommand(dir,context);
        } else if(input.equals("exit")){
            return new ExitCommand();
        }else if(input.startsWith("mkdir")){
            String name=input.substring(6).trim();
            return new MkdirCommand(name,context);
        }else{
            return new UnknowCommand(input);
        }
    }
}
