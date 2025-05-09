package rfm.command;

import rfm.fs.DirectoryContext;
import rfm.fs.DirectoryNode;

import java.util.LinkedList;

public class PwdCommand implements Command{
    private final DirectoryContext context;

    public PwdCommand(DirectoryContext context){
        this.context=context;
    }

    @Override
    public void execute(){
        DirectoryNode current=context.getCurrentDirectoryNode();
        LinkedList<String >path=new LinkedList<>();

        while (current!=null){
            path.addFirst(current.getName());
            current=current.getParent();
        }

        String fullpath=String.join("/",path);
        if(!fullpath.startsWith("/")){
            fullpath="/"+fullpath;
        }

        System.out.println(fullpath);
    }
}
