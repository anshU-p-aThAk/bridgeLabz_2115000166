import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("image.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int c;
        while ((c = in.read()) != -1) {
            baos.write(c);
        }
        byte[] byteArray = baos.toByteArray();
        FileOutputStream out = new FileOutputStream("newimage.jpg");
        out.write(byteArray);
        in.close();
        out.close();
    }
}
