package stream;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @Description: 获取一个目录下的所有子文件
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\");
       // listDemos(file);

        //listFileDemos(file);

       // listFileDemos2(file);

        //listFileDemos3(file);

        listRootsDemo();
    }

    /**
     * 返回所有子文件的名称
     */
    public static void listDemos(File file) {
        String[] fileNames = file.list();
        if (fileNames != null) {
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }
    }

    /**
     * 返回规定的子文件名称
     */
    public static void listFileDemos(File file) {
       String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir,String name) {
                return name.endsWith(".txt");
            }
        });
        if (files != null) {
            for (String file1 : files) {
                System.out.println(file1);
            }
        }
    }

    /**
     * 列出指定目录下所有文件，返回File[]
     */
    public static void listFileDemos2(File file){
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println("pathname------"+pathname);
                return pathname.toString().endsWith("txt");
            }
        });
        if(files!=null){
            for (File file1:files){
                System.out.println(file1);
            }
        }
    }

    /**
     * 列出指定目录下的所有文件
     */
    public static void listFileDemos3(File file){
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("name---------"+name);
                return false;
            }
        });
        if(files!=null){
            for(File file1:files){
                System.out.println(file1);
            }
        }
    }

    /**
     * 返回当前系统所有有用的盘符
     */
    public static void listRootsDemo(){
        File[] files = File.listRoots();
        for (File file:files){
            System.out.println(file);
        }
    }
}
