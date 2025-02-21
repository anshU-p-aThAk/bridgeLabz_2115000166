import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        new Thread(() -> {
            try {
                pos.write("Hello, World!".getBytes());
                pos.close();
            } catch (IOException e) {
            }
        }).start();

        new Thread(() -> {
            try {
                int c;
                while ((c = pis.read()) != -1) {
                    System.out.print((char) c);
                }
                pis.close();
            } catch (IOException e) {
            }
        }).start();
    }
}
