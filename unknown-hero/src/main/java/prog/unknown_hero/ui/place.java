package prog.unknown_hero.ui;
import java.awt.*;
import javax.swing.*;
 

public class place { 
    public static void main(String[] args) { 
        JFrame p = new JFrame();
        ImageIcon img = new ImageIcon("D:/ui/src/DSC04833.JPG");
        p.setSize(800, 600);
        p.setLayout(null);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        paintIcon(img, 20, 10);
        JLabel n0 = new JLabel(img);
        GridBagConstraints c0 = new GridBagConstraints();
        c0.gridx = 0;
        c0.gridy = 0;
        c0.gridwidth = 10;
        c0.gridheight = 10;
        c0.weightx = 0;
        c0.weighty = 0;
        c0.fill = GridBagConstraints.BOTH;
        c0.anchor = GridBagConstraints.WEST;
        p.add(n0, c0);
    
        JButton n2 = new JButton("QAQQQQ");
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 0;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weightx = 0;
        c2.weighty = 0;
        c2.fill = GridBagConstraints.NONE;
        c2.anchor = GridBagConstraints.WEST;
        p.add(n2, c2);   
 
         
        p.setVisible(true);
    }
}