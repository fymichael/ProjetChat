package listener;
import listener.*;
import fenetre.*;
import client.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Mouse_index implements MouseListener{
    static String name = "";
    Index i;
    Client c=new Client();
    Interface inte;
        
    public String get_name(){return this.name;}
    public void set_name(String n){this.name=n;}

    public Mouse_index(Index ind){this.i=ind;}
    public Mouse_index(Client cl){this.c = cl;}
    public void mouseClicked(MouseEvent e){
        try{
            c.set_name(this.i.get_text_field().getText());
            //System.out.println(c.get_name());
            inte = new Interface();
        }
        catch(Exception ep){
            ep.printStackTrace();
        }
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}