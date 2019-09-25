package io.kanonair.file;

import org.junit.Test;

import java.io.File;

public class FileDemo {

    @Test
    public void example01() {
        File file = new File("jdbc.properties");
        System.out.println(file.getAbsolutePath());
    }

}
