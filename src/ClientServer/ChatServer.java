package ClientServer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class ChatServer {

    public static void main(String[] args) {
        new ChatServer().runServer();


    }

    public void runServer() {

        try (ServerSocket serverSocket = new ServerSocket(1337)) { //Laver en ServerSocket(døren til vores server) som lytter på port 1337

            while (true) {
                System.out.println("Awaiting clients...");
                Socket socket = serverSocket.accept(); // Venter på incomming connection. loopet køre  ikke videre før der er kommet en client
                System.out.println("connected from client: " + socket);
                ClientHandler clientHandler = new ClientHandler(socket); // Opretter et objekt af en ny klasse som består af en socket
                Thread t1 = new Thread(clientHandler); // opretter en ny thread som bliver tildelt den aktuelle connection
                t1.start(); // starter den aktuelle thread

            }


        }catch(IOException e){

        }
    }

    class ClientHandler implements Runnable{

        Socket socket;

        public ClientHandler(Socket socket){
            this.socket = socket;
        }


        @Override
        public void run() {

            try {
                handleClientSocket(); // Kalder metoden handleClientSocket på den aktuelle thread
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void handleClientSocket() throws IOException, InterruptedException{
            InputStream inputStream = socket.getInputStream(); // lytter til incomming data


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); // BufferedReader læser incomming data
            String line;
            while ( (line = reader.readLine()) != null){
                if ("quit".equalsIgnoreCase(line)){
                    break;
                }
                System.out.println(line);
            }

            socket.close();
        }
    }




}
