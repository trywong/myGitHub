package com.wc.baseIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class MyFile {
    public static void main(String[] args) {
        try {
            unzipFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile() {
        File file = new File("E:/create.txt");
        try {
            file.createNewFile();
            System.out.println(file.getTotalSpace() / (1024 * 1024 * 1024) + "G");
            file.mkdir();
            System.out.println("文件名：" + file.getName());
            System.out.println("目录：" + file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void normalCopyFile() {
        long start = System.currentTimeMillis();
        String fileName = "E:/iotest/7.MyEclipse10+Maven构建项目过程说明文档.docx";
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(new File(fileName));
            out = new FileOutputStream(new File("E:/iotest/copyFile.docx"));
            int read = 0;
            while ((read = in.read()) != -1) {
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void bufferedCopyFile() {
        long start = System.currentTimeMillis();
        String fileName = "E:/iotest/7.MyEclipse10+Maven构建项目过程说明文档.docx";
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(new File(fileName)));
            out = new BufferedOutputStream(new FileOutputStream(new File("E:/iotest/copyFile.docx")));
            int read = 0;
            while ((read = in.read()) != -1) {
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 回退
     * @Description
     * @author wangchuan
     * @Date 2017年10月13日
     * @throws IOException
     */
    public static void pushbackStream() throws IOException {
        String str = "hello,rollenholt";
        PushbackInputStream push = null; // 声明回退流对象
        ByteArrayInputStream bat = null; // 声明字节数组流对象
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入
        int temp = 0;
        while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
            if (temp == ',') { // 判断读取的是否是逗号
                push.unread(temp); // 回到temp的位置
                temp = push.read(); // 接着读取字节
                System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
            } else {
                System.out.print((char) temp); // 否则输出字符
            }
        }
    }

    /**
     * 从任意位置读取
     * @Description
     * @author wangchuan
     * @Date 2017年10月13日
     * @throws IOException
     */
    public static void randomAccessFileRead() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile("E:/iotest/hahaha.txt", "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针开始读
        byte[] contents = new byte[1024];
        file.read(contents);
        long pointerEnd = file.getFilePointer();
        System.out.println("pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" + new String(contents));
        file.close();
    }

    /**
     * 文本任意位置插入
     * @Description
     * @author wangchuan
     * @Date 2017年10月13日
     * @throws IOException
     */
    public static void randomAccessFileWrite() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("E:/iotest/hahaha.txt", "rw");
        raf.seek(20);
        long start = raf.getFilePointer();
        raf.write("HELLO WORLD!".getBytes());
        long end = raf.getFilePointer();
        System.out.println("开始：" + start + "\n结束：" + end);
        raf.close();
    }

    /**
     * 缓冲流读取文件
     * @Description
     * @author wangchuan
     * @Date 2017年10月13日
     * @throws IOException
     */
    public static void bufferedInputStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("E:/iotest/hahaha.txt")));
        byte[] buffer;
        int bytesCount = 0;
        int i = 1;
        while ((bytesCount = bis.read(buffer = new byte[i])) != -1) {
            System.out.println(new String(buffer, 0, bytesCount));
            i++;
        }
        if (bis != null) {
            bis.close();
        }
    }

    public static void zipStream() throws IOException {
        File file = new File("E:/iotest/hahaha.txt");
        FileInputStream in = new FileInputStream(file);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(new File("E:/iotest/hahaha.zip")));
        out.putNextEntry(new ZipEntry(file.getName()));
        out.setComment("yoyoyo");
        int bytesCount = 0;
        while ((bytesCount = in.read()) != -1) {
            out.write(bytesCount);
        }
        out.close();
        in.close();
    }

    public static void unzipFile() throws IOException {
        ZipFile zipFile = new ZipFile("E:/iotest/hahaha.zip");
        InputStream in = zipFile.getInputStream(zipFile.getEntry("hahaha.txt"));
        FileOutputStream out = new FileOutputStream(new File("E:/iotest/hello.txt"));
        int bytesCount = 0;
        while ((bytesCount = in.read()) != -1) {
            out.write(bytesCount);
        }
        out.close();
        in.close();
    }
}
