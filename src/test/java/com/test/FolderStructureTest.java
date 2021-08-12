package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FolderStructureTest {

    @Test
    public void testCreatePath(){
        FolderStructure folderStructure=new FolderStructure();
        try {
            folderStructure.createPath("/", "a");
            folderStructure.createPath("/", "b");
            folderStructure.createPath("/", "c");
            folderStructure.createPath("/a", "d");
            folderStructure.createPath("/c", "e");
            folderStructure.createPath("/a/d", "g");
        }catch (Exception e){
            Assertions.fail("No exception should be thrown");
        }
    }

    @Test
    public void testSetPath(){
        FolderStructure folderStructure=new FolderStructure();
        try {
            folderStructure.createPath("/", "a");
            folderStructure.createPath("/", "b");
            folderStructure.createPath("/", "c");
            folderStructure.createPath("/a", "d");
            folderStructure.createPath("/c", "e");
            folderStructure.createPath("/a/d", "g");
            folderStructure.setPath("/c/e", "f");
        }catch (Exception e){
            Assertions.fail("No exception should be thrown");
        }
    }
}
