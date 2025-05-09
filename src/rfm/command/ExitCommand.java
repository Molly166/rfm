package rfm.command;

public class ExitCommand implements Command{
    @Override
    public void execute(){
        System.out.println("exiting..");
        System.exit(0);
    }
}
