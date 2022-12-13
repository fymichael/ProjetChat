package fenetre;
import fenetre.*;
import listener.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Index extends JFrame{
    JTextField text = new JTextField();
    JButton button = new JButton("Envoyer");
    JLabel l = new JLabel("Chat List");
    Vector<JLabel> list_label = new Vector<>();
    String sd="";
    
    public JTextField get_text_field(){return this.text;}
    public JButton get_button(){return this.button;}
    public Vector<JLabel> get_list_label(){return this.list_label;}

    public void set_text_field(JTextField jt){this.text=jt;}
    public void set_button(JButton b){this.button=b;}
    public void set_list_label(Vector<JLabel> lab){this.list_label = lab;}

    public Index(){
        this.setTitle("Chat List");
        this.setSize(500, 500);
        this.setLayout(null);
        l.setBounds(150,0,200,100);
        this.add(l);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}