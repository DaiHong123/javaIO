package stream;

import java.io.*;

/**
 * @Description: 序列输入流
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class SequenceInputStreamTest {
    public static void main(StringIOTest[] args) throws IOException {
        InputStream in1 = new FileInputStream(new File("test.txt"));
        InputStream in2 = new FileInputStream(new File("test1.txt"));
        OutputStream ou = new FileOutputStream(new File("test2.txt"));
        SequenceInputStream si = new SequenceInputStream(in1, in2);
        int c = 0;
        while ((c = si.read()) != -1) {
            System.out.print(c);
            ou.write(c);
        }
        si.close();
        ou.close();
        in2.close();
        in1.close();
    }
}
