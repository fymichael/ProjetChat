package fenetre;
import fenetre.*;
import listener.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Index extends JFrame{
    JTextField text = new JTextField();
    JButton button = new JButton("Envoyer");
    JLabel l = new JLabel("Votre nom");
    
    public JTextField get_text_field(){return this.text;}
    public JButton get_button(){return this.button;}

    public void set_text_field(JTextField jt){this.text=jt;}
    public void set_button(JButton b){this.button=b;}

    public Index(){
        this.setTitle("Chat");
        this.setSize(300, 300);
        this.setLayout(null);
        l.setBounds(50,30,200,50);
        text.setBounds(20,80,180,30);
        button.setBounds(200,80,100,30);
        button.addMouseListener(new Mouse_index(this));
        this.add(text);
        this.add(button);
        this.add(l);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}