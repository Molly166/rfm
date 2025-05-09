package rfm.command;

import rfm.fs.DirectoryContext;
import rfm.fs.DirectoryNode;

public class RmCommand implements Command{
    private final DirectoryContext context;
    private final String fileName;

    public RmCommand(DirectoryContext context,String fileName){
        this.context=context;
        this.fileName=fileName;
    }

    @Override
    public void execute(){
        DirectoryNode current=context.getCurrentDirectoryNode();

        if(current.getChildren().containsKey(fileName)){
            System.out.println("Cannot remove: "+fileName+" is a directory.");
            return;
        }

        if(!current.hasFile(fileName)){
            System.out.println("No such file: "+fileName);
            return;
        }

        current.removeFile(fileName);
        System.out.println("File removed: "+fileName);
    }
}
