import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int PORT = 12000;

        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket sc = server.accept();

            DataInputStream dis = new DataInputStream(
                new BufferedInputStream(sc.getInputStream()));
            
            String line = dis.readUTF();
            while (!line.equalsIgnoreCase("EOF") && 
            line != null) {
                System.out.println("Got: -> "+ line);
                // Read the next line
                try {
                    line = dis.readUTF();
                } catch (EOFException e) {
                    System.out.println("Reached End of File");
                    break;
                }
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
