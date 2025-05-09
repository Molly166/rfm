package rfm.fs;

import java.util.LinkedList;

public class DirectoryContext {
    private final LinkedList<String> path=new LinkedList<>();

    public DirectoryContext(){
        path.add("root");//初始目录
    }

    public void changeDirectory(String dir){
        switch (dir){
            case "..":
                if(path.size()>1)path.removeLast();
                break;
            case "/":
                path.clear();
                path.add("root");
                break;
            default:
                if(!dir.isEmpty())path.add(dir);
        }
    }

    public String getCurrentPath(){
        return "/"+String.join("/",path);
    }
}
