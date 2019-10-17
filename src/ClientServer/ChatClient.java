package ClientServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        new ChatClient().runClient();

    }

    public void runClient(){

        try {
            Socket socket = new Socket("localhost", 1337);
            Scanner scanner = new Scanner(System.in);
            DataOutputStream DOut = new DataOutputStream(socket.getOutputStream());
            System.out.println("er forbundet til server");

            while(true){
                DOut.writeBytes("client 1: "+ scanner.nextLine() + "\n");

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}

