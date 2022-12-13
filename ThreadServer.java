package server;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import fenetre.*;
import java.util.*;

public class ThreadServer extends Thread {

    private Socket socket;
    private ArrayList<Socket> clients;
    private HashMap<Socket, String> clientNameList;
    JLabel l;
   Index index;

    public Socket get_socket(){return this.socket;}
    public ArrayList<Socket> get_clients(){return this.clients;}
    public HashMap<Socket,String> get_client_name_list(){return this.clientNameList;}

    public void set_socket(Socket s){this.socket = s;}
    public void set_clients(ArrayList<Socket> cl){this.clients=cl;}
    public void set_client_name_list(HashMap<Socket, String> clm){this.clientNameList = clm;}

    public ThreadServer(Index n,Socket socket, ArrayList<Socket> clients, HashMap<Socket, String> clientNameList) {
        set_socket(socket);
        set_clients(clients);
        set_client_name_list(clientNameList);
        this.index = n;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                System.out.println("id"+index.get_list_label().size());
                Vector<String> vec_str = new Vector<>();
                for(int i = 0;i<index.get_list_label().size();i++){
                    vec_str.add(index.get_list_label().get(i).getText());
                    System.out.println("liste : "+vec_str.get(i));
                }
                String outputString = input.readLine();
                if (outputString.equals("logout")) {
                    throw new SocketException();
                }
                if (!clientNameList.containsKey(socket)) {
                    String[] messageString = outputString.split(":", 2);
                    clientNameList.put(socket, messageString[0]);
                    System.out.println(messageString[0] + messageString[1]);
                    showMessageToAllClients(index,socket, messageString[0] + messageString[1]);
                } else {
                    System.out.println(outputString);
                    showMessageToAllClients(index,socket, outputString);
                }
            }
        } catch (SocketException e) {
            String printMessage = clientNameList.get(socket) + " left the chat room";
            System.out.println(printMessage);
            showMessageToAllClients(index,socket, printMessage);
            clients.remove(socket);
            clientNameList.remove(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMessageToAllClients(Index in,Socket sender, String outputString) {
        Socket socket;
        PrintWriter printWriter;
        int i = 0;
        while (i < clients.size()) {
            socket = clients.get(i);
            i++;
            try {
                if (socket != sender) {
                    printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(outputString);
                    index.get_list_label().add(l=new JLabel(outputString));
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
