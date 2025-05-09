package rfm.command;

import rfm.fs.DirectoryContext;

public class MkdirCommand implements Command{
    private final String dirName;
    private final DirectoryContext context;

    public MkdirCommand(String dirName,DirectoryContext context){
        this.dirName=dirName;
        this.context=context;
    }

    @Override
    public void execute(){
        if(dirName.isEmpty()){
            System.out.println("mkdir:missing directory name");
            return;
        }
        if(context.makeDirectory(dirName)){
            System.out.println("Directory create: "+dirName);
        }else{
            System.out.println("mkdir: create directory "+dirName+" :File exists");
        }
    }
}
