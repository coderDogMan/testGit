package test;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        String fileName="D:\\output.txt";

        FileWriter fw=null;
        PrintWriter toFile=null;

        try{
            fw=new FileWriter(fileName,true);  //本代码中增加FileWriter      //可以抛出IOException异常
            toFile=new PrintWriter(fw);         //将数据流outStream连接到名为f.txt的文件  //可以抛出FileNotFoundException异常

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("PrintWriter error opening the file:"+fileName);
            System.exit(0);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("FileWriter error opening the file:"+fileName);
            System.exit(0);
        }
        System.out.println("Please input four additional lines of text:");         //本例中控制输入4行
        Scanner keyboard=new Scanner(System.in);         //使用Scanner获得输入

        for(int count=1;count<=4;count++){
            String line=keyboard.nextLine();         //获取一行内容
            toFile.println("Translation "+count+": "+line);         //PrintWriter的println写文件方法与System.out.println写屏幕方法类似
        }

        System.out.println("Four lines were written to "+fileName);
        toFile.close();      //显示关闭数据流，避免数据丢失
    }

}
