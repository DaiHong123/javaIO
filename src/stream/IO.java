package stream;

import java.io.*;

/**
 * @Description: 管道的输入输出流
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class IO {
    public static void main(StringIOTest[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        try {
            PipedInputStream pis = new PipedInputStream(pos);
            new Thread(new InputStreamRunnable(pis)).start();
            new Thread(new OutputStreamRunnable(pos)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class InputStreamRunnable implements Runnable {
        private PipedInputStream pis = null;

        InputStreamRunnable(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            BufferedReader sr = new BufferedReader(new InputStreamReader(pis));
            try {
                System.out.println("读取到的内容是：" + sr.readLine());
//                int c = 0;
//                while ((c=pis.read())!=-1){
//                    System.out.print((char)c);
//                }
//                sr.close();
//                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class OutputStreamRunnable implements Runnable {
        private PipedOutputStream pos = null;

        OutputStreamRunnable(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                pos.write("Hello World!".getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
