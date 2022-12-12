package fenetre;
import fenetre.*;
import listener.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Interface extends JFrame{
    JTextField text = new JTextField();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton button = new JButton("Envoyer");
    Vector<JLabel> liste_label = new Vector<>();

    public JTextField get_text_field(){return this.text;}
    public JButton get_button(){return this.button;}
    public JPanel get_panel1(){return this.panel1;}
    public JPanel get_panel2(){return this.panel2;}
    public Vector<JLabel> get_liste_discu(){return this.liste_label;}

    public void set_text_field(JTextField jt){this.text=jt;}
    public void set_button(JButton b){this.button=b;}
    public void set_panel1(JPanel p1){this.panel1=p1;}
    public void set_panel2(JPanel p2){this.panel2=p2;}
    public void set_liste_discu(Vector<JLabel> ls){this.liste_label=ls;}

    public Interface(){
        this.setTitle("Chat");
        this.setSize(800, 500);
        this.setLayout(new GridLayout(2,0));
        panel1.setPreferredSize(new Dimension(1200, 1000));
        panel1.setLayout(null);
        panel1.add(new JLabel("null"));
        panel2.setLayout(null);
        text.setBounds(20,80,250,50);
        button.setBounds(280,80,100,50);
        panel2.add(text);
        panel2.add(button);
        //panel1.setBackground(Color.blue);
        panel2.setBackground(Color.red);
        button.addMouseListener(new Mouse(this,20,20));
        this.add(panel1);
        this.add(panel2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
