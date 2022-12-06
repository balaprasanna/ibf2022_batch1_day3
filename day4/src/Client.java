import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        int PORT = 12345;
        try {
            Socket cs = new Socket("localhost", PORT);

            // Get the I/O steams
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            dos.writeUTF("hello");
            dos.writeUTF("world");
            dos.flush();
            System.out.println("MESSAGE SENT TO SERVER");
            cs.close();
        } catch (UnknownHostException e) {
            System.out.println("Unable to reach the HOST");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
        
    }
}
