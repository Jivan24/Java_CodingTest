package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FolderStructure {

    private Node parent;

    public FolderStructure(){
        this.parent=new Node("/");
    }

    public static void main(String[] args) {
        FolderStructure folderStructure=new FolderStructure();
        try {
            folderStructure.createPath("/", "a");
            folderStructure.createPath("/", "b");
            folderStructure.createPath("/", "c");
            folderStructure.createPath("/a", "d");
            folderStructure.createPath("/c", "e");
            folderStructure.createPath("/a/d", "g");
            folderStructure.setPath("/c/e","f");
        } catch (Exception e) {
            e.printStackTrace();
        }
        folderStructure.print(folderStructure.parent);
    }

    public void print(Node current) {
        printSubFolders(current,"");
    }

    public void printSubFolders(Node current,String indentation){
        if (current != null) {
            System.out.println("|-"+indentation+current.value);
            for (int i = 0; i < current.getNext().size(); i++) {
                printSubFolders(current.getNext().get(i),indentation+"--");
            }
        }
    }

    private boolean valid(String value){
        return value!=null && !value.isEmpty();
    }

    public void createPath(String path, String value) throws Exception {
        if(!valid(path) || !valid(value)){
            throw new Exception("Path or value is not correct");
        }
        if(this.parent.getValue().equals(path)){
            this.parent.next.add(new Node(value));
            return;
        }
        String[] folders = path.substring(1).split("/");
        Node current = getNode(path, folders);
        current.next.add(new Node(value));
    }

    public void setPath(String path, String value) throws Exception {
        if(!valid(path) || !valid(value)){
            throw new Exception("Path or value is not correct");
        }
        String[] folders = path.substring(1).split("/");
        Node current = getNode(path, folders);
        current.value=value;
    }

    private Node getNode(String path, String[] folders) throws Exception {
        Node current = parent;
        for (String folder : folders) {
            List<Node> next = current.getNext();
            Optional<Node> optionalNode = next.stream().filter(node -> node.getValue().equals(folder)).findFirst();
            if (optionalNode.isPresent()) {
                current = optionalNode.get();
            } else {
                throw new Exception("Path "+ path +" not available");
            }
        }
        return current;
    }
}


