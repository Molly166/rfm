package rfm.command;

import rfm.fs.DirectoryContext;
import rfm.fs.DirectoryNode;
import rfm.fs.FileNode;

import java.util.Map;

public class LsCommand implements Command{
    private final DirectoryContext context;

    public LsCommand(DirectoryContext context){
        this.context=context;
    }

    @Override
    public void execute(){
        DirectoryNode current=context.getCurrentDirectoryNode();
        Map<String,DirectoryNode> children =current.getChildren();
        Map<String , FileNode>files=current.getFiles();

        if(children.isEmpty()&&files.isEmpty()){
            System.out.println("(empty)");
            return;
        }

        for(String dirName:children.keySet()){
            System.out.println(dirName+"/");
        }

        for(String fileName:files.keySet()){
            System.out.println(fileName);
        }
    }
}
