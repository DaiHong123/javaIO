package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 把一个以字节为向导的stream转换成一个以字符为向导的stream。
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class InputStreamReaderTest {
    public static void main(String[] args){
        String s = null;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try {
            s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
