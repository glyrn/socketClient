import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("已连接到服务器");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            while (true) {
                serverMessage = reader.readLine();
                System.out.println("服务器: " + serverMessage);

                clientMessage = consoleReader.readLine();
                writer.println(clientMessage);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
