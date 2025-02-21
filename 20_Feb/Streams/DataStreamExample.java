import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("student.dat"));
        out.writeInt(101);
        out.writeUTF("Alice");
        out.writeDouble(9.1);
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("student.dat"));
        System.out.println("Roll: " + in.readInt());
        System.out.println("Name: " + in.readUTF());
        System.out.println("GPA: " + in.readDouble());
        in.close();
    }
}
