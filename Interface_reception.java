package fenetre;
import fenetre.*;

import javax.swing.*;
import java.awt.*;

public class Interface_reception extends JFrame{
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
     JLabel label = new JLabel();
     String message=null;

      public String get_message(){return this.message;}

      public void set_message(String m){this.message=m;}

    public Interface_reception(String mess){
      set_message(mess);
        System.out.println(mess);
        this.setTitle("Chat Reception");
        this.setSize(300, 300);
        this.setLayout(new GridLayout(2,0));
        label.setText(get_message());
        panel1.add(label);
        this.add(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
