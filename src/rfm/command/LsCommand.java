package rfm.command;

import rfm.fs.DirectoryContext;
import rfm.fs.DirectoryNode;

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

        if(children.isEmpty()){
            System.out.println("(empty)");
        }else{
            for(String name:children.keySet()){
                System.out.println(name);
            }
        }
    }
}
