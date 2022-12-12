package client;
import listener.*;
import fenetre.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    static String name = "";
    static String reponse = " ";
    static String host="localhost";
    static int port=5000;
    //Mouse_index m = new Mouse_index();

    public String get_name(){return this.name;}
    public String get_reponse(){return this.reponse;}

    public  void set_name(String n){this.name=n;}
    public void set_reponse(String r){this.reponse=r;}

    public Client(){}
    public Client(String na,String rep){
        set_name(na);
        set_reponse(rep);
    }  
    public static void main(String[] args) {
        Index i = new Index();
        Client c = new Client();
        Scanner sc = new Scanner(System.in);
        System.out.print("Your name : "+c.get_name());

        try (Socket socket = new Socket(host, port)) {
             System.out.println(" : "+c.get_name());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            ThreadClient threadClient = new ThreadClient(socket);
            new Thread(threadClient).start();

            out.println(c.get_name() + ": has joined chat-room.");
            do {
                String message = (c.get_name() + " : ");
                if (c.get_reponse().equals("logout")) {
                    out.println("logout");
                    break;
                }
                out.println(message + c.get_reponse());
            } while (!c.get_reponse().equals("logout"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
