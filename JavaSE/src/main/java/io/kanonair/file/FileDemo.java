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
        int len;
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
        String filePath1 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file1.txt";
        String filePath2 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file3.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath1);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
        byte[] b = new byte[1024];
        int len;
        while ((len = fileInputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 缓冲流
     */
    @Test
    public void example04() throws Exception {
        String filePath1 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file1.txt";
        String filePath2 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file4.txt";
        InputStream inputStream = new FileInputStream(filePath1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        OutputStream outputStream = new FileOutputStream(filePath2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] b = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    /**
     * 缓冲流
     */
    @Test
    public void example05() throws Exception {
        String filePath1 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file1.txt";
        String filePath2 = "C:/Users/Administrator/Desktop/JavaEE/JavaSE/src/main/resources/file5.txt";
        Reader reader = new FileReader(filePath1);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Writer writer = new FileWriter(filePath2);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        char[] c = new char[1024];
        int len;
        while ((len = bufferedReader.read(c)) != -1) {
            bufferedWriter.write(c, 0, len);
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

}
