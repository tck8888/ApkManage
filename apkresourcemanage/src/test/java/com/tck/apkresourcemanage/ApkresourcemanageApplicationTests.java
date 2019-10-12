package com.tck.apkresourcemanage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApkresourcemanageApplicationTests {

    @Test
    public void contextLoads()  {

    }

    @Test
    public void testFilePath()throws FileNotFoundException{
        File parent  = new File(ResourceUtils.getURL("classpath:").getPath());
        System.err.println(parent.getParentFile().getParent());

        File file = new File(parent.getParentFile().getParent() + File.separator + "apk", "apkkkkkk.txt");

        System.err.println(file.getAbsolutePath());
    }

}
