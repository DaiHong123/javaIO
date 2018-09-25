package stream;

import org.junit.Test;

import java.io.*;

/**
 * @Description: 输入流测试:mark是标记一个地方,reset是回到标记的地方,如果我们在读取完之后在调用reset时，会从新读取文件
 * .0.1.2.3.4.5.6.7.8.5.6.7.8.5.6.7.8.9.10.11.12.13.14.15.16.17.18.19
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class InputStreamTest {
    public static void main(StringIOTest[] args){
        writeToFile();
        readFromFile();
    }
   @Test
    public void test1() throws IOException {
      BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream("Hello World".getBytes()));
      int bytes = 1;
      bis.mark(1);
      while ((bytes=bis.read())!=-1){
          System.out.print(bytes+",");
      }
       System.out.println();
      bis.reset();
      while ((bytes=bis.read())!=-1){
          System.out.print(bytes+",");
      }
    }
    private static void readFromFile(){
        InputStream inputStream = null;
        try{
            inputStream = new BufferedInputStream(new FileInputStream(new File("test.txt")));
            if(!inputStream.markSupported()){
                System.out.println("mark/reset not supported!");
                return;
            }
            int ch;
            int count = 0;
            boolean marked = false;
            while ((ch=inputStream.read())!=-1){
                System.out.print("."+ch);
                if(ch==4&&!marked){
                    inputStream.mark(10);
                    marked = true;
                }
                if(ch==8 && count<2){
                    inputStream.reset();
                    count++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static void writeToFile(){
        OutputStream outputStream = null;
        try{
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("test1.txt")));
            byte[] b = new byte[20];
            for(int i=0;i<20;i++) {
                b[i] = (byte) i;
            }
            outputStream.write(b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
