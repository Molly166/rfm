package rfm.fs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DirectoryNode {
    private final String name;
    private final Map<String,DirectoryNode> children =new HashMap<>();
    private final Map<String ,FileNode>files =new LinkedHashMap<>();
    private DirectoryNode parent;


    public DirectoryNode(String name){
        this.name=name;
    }

    public DirectoryNode getChild(String name){
        return children.get(name);
    }

    public void addChild(String name){
        if(!children.containsKey(name)){
            children.put(name,new DirectoryNode(name));
        }
    }

    public boolean hasChild(String name){
        return children.containsKey(name);
    }

    public Map<String,DirectoryNode> getChildren(){
        return children;
    }

    public String getName(){
        return name;
    }

    public Map<String ,FileNode>getFiles(){
        return files;
    }

    public void addFiles(FileNode file){
        files.put(file.getName(),file);
    }

    public boolean hasFile(String name){
        return files.containsKey(name);
    }
}

