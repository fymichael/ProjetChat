package server;

import java.net.*;
import java.util.*;

import fenetre.Index;
import fenetre.Interface;

public class Server {

    public Server(){}
    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        HashMap<Socket, String> clientNameList = new HashMap<Socket, String>();
        Index ind = new Index();
        Interface i = new Interface(ind);
        try (ServerSocket serversocket = new ServerSocket(1234)) {
            System.out.println("Server is started...");
            while (true) {
                Socket socket = serversocket.accept();
                clients.add(socket);
                ThreadServer ThreadServer = new ThreadServer(ind,socket, clients, clientNameList);
                ThreadServer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
