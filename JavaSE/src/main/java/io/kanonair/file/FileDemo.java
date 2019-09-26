package io.kanonair.file;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class FileDemo {

    /**
     * 文件使用
     */
    @Test
    public void example01() {
        // 创建
        File file =
                new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/jdbc.properties");
        System.out.println(file.getAbsolutePath());
        file =
                new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources",
                        "jdbc.properties");
        System.out.println(file.getAbsoluteFile());
        file =
                new File(new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources"),
                        "jdbc.properties");
        // 路径
        System.out.println(file.getAbsoluteFile());
        // 名称
        System.out.println(file.getName());
        // 大小
        System.out.println(file.length());
        // 时间
        System.out.println(new Date(file.lastModified()));
        // 文件列表
        file =
                new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main");
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
    }

}
