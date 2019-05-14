package javaIO;

import java.io.*;

/**
 * @program: QAproject
 * @description: IODemo java 读写文件
 * @author: bjweiman
 * @create: 2019-04-11 11:53
 **/
public class IODemo {
    public static void writeFile(String path) throws Exception{
        File file = new File(path);
        file.createNewFile();

        FileWriter writer = new FileWriter(file, true);
        writer.append("hello java io");

        writer.flush();

        writer.close();
    }

    public static void readFile(String path)throws Exception{
        File file = new File(path);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String content ="";
        String tmp = "";

        while(bufferedReader.readLine() != null){
            content += bufferedReader.readLine();
        }

        System.out.println(content);
        bufferedReader.close();
    }
    public static void writeToFile1(String path) throws IOException{
        File file = new File(path);

        file.createNewFile();

        FileWriter writer = new FileWriter(file,true);

        writer.append("yes");

        writer.flush();

        writer.close();

    }

    public static void readFromFile1(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String content ="";
        String tmp = "";

        while((tmp = reader.readLine()) != null){
            content += tmp;
        }

        System.out.println(content);

        reader.close();

    }

    public static void main(String[] args) throws Exception{
        String path =".\\test.txt";
//        writeToFile1(path);

        readFromFile1(path);
    }
}
