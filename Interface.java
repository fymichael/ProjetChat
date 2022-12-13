package fenetre;
import fenetre.*;
import listener.*;
import client.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Interface extends JFrame{
    JTextField text = new JTextField();
    JTextField text1 = new JTextField();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton button = new JButton("Envoyer");
    //Vector<JLabel> liste_discu = new Vector<>();
    JLabel l = new JLabel("Votre nom");
    Index ind;

    // Client cl = new Client();

    public JTextField get_text_field(){return this.text;}
    public JTextField get_text1_field(){return this.text1;}
    //public Client get_client(){return this.cl;}
    public JButton get_button(){return this.button;}
    public JPanel get_panel1(){return this.panel1;}
    public JPanel get_panel2(){return this.panel2;}
    //public Vector<JLabel> get_liste_discu(){return this.liste_discu;}

    //public void set_client(Client c){this.cl = c;}
    public void set_text_field(JTextField jt){this.text=jt;}
    public void set_text1_field(JTextField jt1){this.text1=jt1;}
    public void set_button(JButton b){this.button=b;}
    public void set_panel1(JPanel p1){this.panel1=p1;}
    public void set_panel2(JPanel p2){this.panel2=p2;}
    //public void set_liste_discu(Vector<JLabel> ls){this.liste_discu=ls;}

    public Interface(Index id){
        this.ind = id;
        //this.set_client(c);
        this.setTitle("Chat");
        this.setSize(800, 500);
        this.setLayout(new GridLayout(2,0));
        panel1.setPreferredSize(new Dimension(1200, 1000));
        panel1.setLayout(null);
        panel1.add(new JLabel("null"));
        panel2.setLayout(null);
        text.setBounds(20,80,180,30);
        button.setBounds(250,150,100,30);
        text1.setBounds(280,80,180,30);
        panel2.add(text);
        panel2.add(button);
        panel2.add(text1);
        //panel1.setBackground(Color.blue);
        panel2.setBackground(Color.red);
        button.addMouseListener(new Mouse(this,ind));
        //this.add(panel1);
        this.add(panel2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
