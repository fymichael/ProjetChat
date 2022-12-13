package client;
import listener.*;
import fenetre.*;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client {
    String name = "";
    String reponse = " ";
    String host="localhost";
    int port=2000;
    JLabel l;
    int x=20;
    int y=20;
    //

    public String get_name(){return this.name;}
    public String get_reponse(){return this.reponse;}

    public int get_x(){return this.x;}
    public int get_y(){return this.y;}

    public void set_x(int xi){this.x=xi;}
    public void set_y(int yi){this.y=yi;}

    public  void set_name(String n){this.name=n;}
    public void set_reponse(String r){this.reponse=r;}

    public Client(){}

    public void sendMessage(Index i,String nom,String message){
        try {
            Socket socket = new Socket("localhost", 1234);
            this.set_name(nom);
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

             ThreadClient threadClient = new ThreadClient(socket,i);
             new Thread(threadClient).start();

            System.out.println(nom + " has joined chat-room.");
                String mess = (nom + " : ");
                if (message.equals("logout")) {
                    System.out.println("logout");
                }
                this.set_reponse(mess + message);
                set_y(get_y()+20);
                i.get_list_label().add(l=new JLabel(this.get_reponse()));
                l.setBounds(get_x(),get_y(),100,30);
                //System.out.println(mess + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
