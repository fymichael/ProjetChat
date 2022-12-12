package server;

import java.net.*;
import java.util.*;

public class Server {

    public Server(){}
    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        HashMap<Socket, String> clientNameList = new HashMap<Socket, String>();
        try (ServerSocket serversocket = new ServerSocket(5000)) {
            System.out.println("Server is started...");
            while (true) {
                Socket socket = serversocket.accept();
                clients.add(socket);
                ThreadServer ThreadServer = new ThreadServer(socket, clients, clientNameList);
                ThreadServer.start();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}