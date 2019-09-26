package io.kanonair.file;

import org.junit.Test;

import java.io.*;
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
        // 创建文件
        file = new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/a");
        if (!file.exists()) {
            try {
                boolean b = file.createNewFile();
                if (b) {
                    System.out.println("ok");
                } else {
                    System.out.println("er");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 创建文件
        file = new File("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/aa");
        if (!file.exists()) {
            boolean b = file.mkdir();
            if (b) {
                System.out.println("ok");
            } else {
                System.out.println("er");
            }
        }
    }

    /**
     * 字符流：Reader Writer
     */
    @Test
    public void example02() throws Exception {
        String filePath1 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file1.txt";
        String filePath2 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file2.txt";
        FileReader fileReader = new FileReader(filePath1);
        FileWriter fileWriter = new FileWriter(filePath2);
        char[] c = new char[1024];
        int len = -1;
        while ((len = fileReader.read(c)) != -1) {
            fileWriter.write(c, 0, len);
        }
        fileWriter.close();
        fileReader.close();
    }

    /**
     * 字节流：InputStream OutputStream
     */
    @Test
    public void example03() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file3.txt");
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = fileInputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

}
