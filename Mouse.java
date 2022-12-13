package listener;
import listener.*;
import fenetre.*;
import client.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mouse implements MouseListener{
    JPanel p;
    JLabel l;
    int indice=0;
    String message="";
    String nom ="";
    Interface interf;
    Index ind = new Index(); 
    Client c = new Client();


    public String get_message(){return this.message;}
    public void set_message(String me){this.message = me;}

    public Interface get_interface(){return this.interf;}
    public void set_interface(Interface intf){this.interf=intf;}

    public Mouse(Interface i,Index de){
        set_interface(i);
        this.ind = de;
    }

    public void mouseClicked(MouseEvent e){
        try{
            message = this.interf.get_text_field().getText();
            nom = this.interf.get_text1_field().getText();
            c.sendMessage(ind,nom,message);
            // c.set_reponse(message);
            // l=new JLabel(message);
            //System.out.println(l.getText());
            //ind.get_liste_discu().add(l);

            for(int i=0;i<ind.get_list_label().size();i++){
                //System.out.println(ind.get_list_label().size());
                ind.add(ind.get_list_label().get(i));
                ind.setVisible(false);
                ind.setVisible(true);
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
