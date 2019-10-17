package ClientServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 {

    public static void main(String[] args) {

        new ChatClient2().runClient();

    }

    public void runClient(){

        try {
            Socket socket = new Socket("localhost", 1337);
            Scanner scanner = new Scanner(System.in);
            DataOutputStream DOut = new DataOutputStream(socket.getOutputStream());
            System.out.println("er forbundet til server");

            while(true){
                DOut.writeBytes( "client 2: "+ scanner.nextLine() + "\n");
                DOut.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}