package rfm.command;

import rfm.fs.DirectoryContext;
import rfm.fs.DirectoryNode;
import rfm.fs.FileNode;

public class TouchCommand implements Command{
    private final DirectoryContext context;
    private final String fileName;

    public TouchCommand(DirectoryContext context,String fileName){
        this.context=context;
        this.fileName=fileName;
    }

    @Override
    public void execute(){
        DirectoryNode current =context.getCurrentDirectoryNode();

        if(current.getChildren().containsKey(fileName)){
            System.out.println("A directory with the same name already exists");
            return;
        }

        if(current.hasFile(fileName)){
            System.out.println("File already exists: "+fileName);
            return;
        }

        current.addFiles(new FileNode(fileName));
        System.out.println("File created: "+fileName);
    }
}
