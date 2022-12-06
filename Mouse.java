package listener;
import listener.*;
import fenetre.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mouse implements MouseListener{
    Interface_envoie interf;

    public Interface_envoie get_interface_envoie(){return this.interf;}
    public void set_interface_envoie(Interface_envoie intf){this.interf=intf;}

    public Mouse(Interface_envoie i){set_interface_envoie(i);}
    public void mouseClicked(MouseEvent e){
        try{
            String message = this.get_interface_envoie().get_text_field().getText();
            interf = new Interface_envoie(message);
            //Interface_reception r = new Interface_reception(message);
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
