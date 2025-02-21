import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("largefile.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("copy.txt"));
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
        System.out.println("Time: " + (System.nanoTime() - start) + " ns");
    }
}
