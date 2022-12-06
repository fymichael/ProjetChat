package fenetre;
import fenetre.*;
import listener.*;

import javax.swing.*;
import java.awt.*;

public class Interface_envoie extends JFrame{
    JTextField text = new JTextField();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton button = new JButton("Envoyer");
    String message=null;
    JLabel label = new JLabel();

    public JTextField get_text_field(){return this.text;}
    public JButton get_button(){return this.button;}
    public String get_message(){return this.message;}

    public void set_message(String m){this.message=m;}
    public void set_text_field(JTextField jt){this.text=jt;}
    public void set_button(JButton b){this.button=b;}

    public Interface_envoie(String me){
      set_message(me);
        this.setTitle("Chat Envoie");
        this.setSize(300, 500);
        this.setLayout(new GridLayout(2,0));
        panel1.setPreferredSize(new Dimension(500, 1000));
        panel1.setBackground(Color.blue);
        label.setText(get_message());
        panel1.add(label);
        panel2.setLayout(null);
        text.setBounds(20,80,250,50);
        button.setBounds(280,80,100,50);
        panel2.add(text);
        panel2.add(button);
        button.addMouseListener(new Mouse(this));
        System.out.println(get_message());
        this.add(panel1);
        this.add(panel2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
