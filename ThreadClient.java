package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ThreadClient implements Runnable {
    Client c;
    Socket socket;

    public Socket get_socket(){return this.socket;}

    public void set_socket(Socket s){this.socket = s;}

    public ThreadClient(Socket socket,Client cl) throws IOException {
        set_socket(socket);
        this.c = cl;
    }

    @Override
    public void run() {
        try {
            while (true) {
                c.set_reponse(c.get_reponse());
                System.out.println("continue");
            }
        } catch (SocketException e) {
            System.out.println("Exiting the chat-room ... ");
            System.out.println("You left the chat-room");
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
