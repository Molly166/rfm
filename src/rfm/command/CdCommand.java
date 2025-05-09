package rfm.command;

import rfm.fs.DirectoryContext;

public class CdCommand implements Command{
    private final String targetDir;
    private final DirectoryContext context;

    public CdCommand(String targetDir,DirectoryContext context){
        this.context=context;
        this.targetDir=targetDir;
    }

    @Override
    public void execute(){
        context.changeDirectory(targetDir);
        System.out.println("Changed directory to:"+context.getCurrentPath());
    }
}
