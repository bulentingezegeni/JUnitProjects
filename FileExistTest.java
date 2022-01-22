package com.myfirstproject.practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistTest {

    @Test
    public void isExist(){
        String homeDirectory =System.getProperty("user.home");
        System.out.println(homeDirectory);

        String pathOfImage=homeDirectory+"/Desktop/col.png";
        System.out.println(pathOfImage);

        boolean isExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);
    }


}
