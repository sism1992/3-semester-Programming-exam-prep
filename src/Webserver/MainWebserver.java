package Webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainWebserver {

    static String path = System.getProperty("user.dir"); // her får man path C:\Users\1992K\Desktop\intellij mappe\Exam prep

    public static void main(String[] args) {
        System.out.println(path);
        try {
            ServerSocket serverSocket = new ServerSocket(1337);

            while(true) {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connection created...");
                serviceTheClient(socket);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serviceTheClient(Socket socket) {
        try {
            Scanner fromClient = new Scanner(socket.getInputStream());
            System.out.println("From Client: ");
            //System.out.println(fromClient.nextLine());
            String test = fromClient.nextLine();
            test = test.substring(4,test.length()-9);
            String fullPath;
            System.out.println("Dette er en test "+test);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            /*if(test.equals("/about.html")) {
                fullPath = path+test;
            }
            else if(test.equals("/products.html")) {
                fullPath = path+test;
            }
            else {
                fullPath = path+"/index.html";
            }*/

            fullPath = path+test;


            File file = new File(fullPath);


            if(!file.isFile()) {
                System.out.println("File not found");
            } else {
                System.out.println("File found");

                int length = (int) file.length();
                byte[] byteArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(byteArr);
                fileInputStream.close();

                //Send response to client(browser)
                dataOutputStream.writeBytes("HTTP/1.0 200 Here comes the crap\r\n");
                dataOutputStream.writeBytes("Content-Length: "+length+"\r\n");
                dataOutputStream.writeBytes("\r\n"); //Vigtigt denne adskiller header fra indhold

                dataOutputStream.write(byteArr,0,length);
                dataOutputStream.writeBytes("\n");
            }



        }
        catch(IOException e) {

        }
    }
}
