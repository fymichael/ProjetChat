package listener;
import listener.*;
import fenetre.*;
import client.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mouse implements MouseListener{
    Interface interf;
    JPanel p;
    JLabel l;
    int indice=0;
    static String message="";
    int x=0;
    int y=0;
    Client c = new Client();

    public String get_message(){return this.message;}
    public void set_message(String me){this.message = me;}

    public Interface get_interface(){return this.interf;}
    public void set_interface(Interface intf){this.interf=intf;}
    
    public int get_x(){return this.x;}
    public int get_y(){return this.y;}

    public void set_x(int xi){this.x=xi;}
    public void set_y(int yi){this.y=yi;}

    public Mouse(Interface i,int xx,int yy){
        set_interface(i);
        set_x(xx);
        set_y(yy);
    }

    public void mouseClicked(MouseEvent e){
        try{           
            message = this.get_interface().get_text_field().getText();
            c.set_reponse(message);
            l=new JLabel(message);
            set_x(get_x()+50);
            l.setBounds(get_x(),get_y(),100,30);
            System.out.println(l.getText());
            get_interface().get_liste_discu().add(l);
            for(int i=0;i<get_interface().get_liste_discu().size();i++){
                get_interface().get_panel1().add(get_interface().get_liste_discu().get(i));
                get_interface().setVisible(false);
                get_interface().setVisible(true);
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
