package client;
import fenetre.*;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;


/**
 * Thread for clients
 */
public class ThreadClient implements Runnable {

    private Socket socket;
    private BufferedReader cin;
    private Index interf;

    public ThreadClient(Socket socket,Index inte) throws IOException {
        this.socket = socket;
        this.interf=inte;
        this.cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = cin.readLine();
                System.out.println(message);
                this.interf.get_list_label().add(new JLabel(message));
            }
        } catch (SocketException e) {
            System.out.println("exiting...");
            System.out.println("You left the chat-room");
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                cin.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
