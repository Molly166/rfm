package rfm.command;

public class UnknowCommand implements Command{
    private final String command;

    public UnknowCommand(String command){
        this.command=command;
    }

    @Override
    public void execute(){
        System.out.println("Unrecognized command:"+command);
    }
}
