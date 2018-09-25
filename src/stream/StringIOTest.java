package stream;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Description: StringReader和StringWriter
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class StringIOTest {
    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader("just a test~");
        StringWriter stringWriter = new StringWriter();
        int c = 0;
        while ((c=stringReader.read())!=-1){
            stringWriter.write(c);
            System.out.print((char)c);
        }
        System.out.println();
        stringWriter.close();
        System.out.println(stringWriter.getBuffer().toString());
        stringReader.close();
    }
}
