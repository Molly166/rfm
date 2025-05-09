package rfm.fs;

import java.util.LinkedList;

public class DirectoryContext {
    private final LinkedList<String> path=new LinkedList<>();
    private final DirectoryNode root;
    private DirectoryNode current;

    public DirectoryContext(){
        path.add("root");//初始目录
        root=new DirectoryNode("root");
        current=root;
    }

    public void changeDirectory(String dir){
        if(dir.equals("/")){
            current=root;
            path.clear();
            path.add("root");
        }else if(dir.equals("..")){
            if(path.size()>1){
                path.removeLast();
                current=getNodeByPath(path);
            }
        }else{
            if(current.hasChild(dir)){
                current=current.getChild(dir);
                path.add(dir);
            }else{
                System.out.println("Directory not found: "+dir);
            }
        }
    }

    public boolean makeDirectory(String name){
        if(current.hasChild(name)){
            return false;
        }else {
            current.addChild(name);
            return true;
        }
    }

    private DirectoryNode getNodeByPath(LinkedList<String> pathList){
        DirectoryNode node=root;
        for(int i=1;i<pathList.size();++i){
            node=node.getChild(pathList.get(i));
        }
        return node;
    }

    public String getCurrentPath(){
        return "/"+String.join("/",path);
    }

    public DirectoryNode getCurrentDirectoryNode(){
        return current;
    }
}
