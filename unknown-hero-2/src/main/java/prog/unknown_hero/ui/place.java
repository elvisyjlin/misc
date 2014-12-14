package prog.unknown_hero.ui;
import java.awt.*;

import javax.swing.*;

public class place { 
    public static void main(String[] args) { 
    	

    	
        JFrame p = new JFrame();
        ImageIcon img1 = new ImageIcon("./img/DSC04833.JPG");
        ImageIcon img2 = new ImageIcon("./img/ATK-13.jpg");
        ImageIcon img3 = new ImageIcon("./img/HP-3.jpg");
        ImageIcon img4 = new ImageIcon("./img/WEAPON-無.jpg");
        ImageIcon img5 = new ImageIcon("./img/DEF+0.jpg");
        ImageIcon img6 = new ImageIcon("./img/END-BOTTON-NOT-CLICK.jpg");
        
        p.setSize(805, 635);
        p.setLayout(new GridBagLayout());
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //=========================================================== enemy1
        JButton N1 = new JButton(img1);
        GridBagConstraints C1 = new GridBagConstraints();
        C1.gridx = 2;
        C1.gridy = 0;
        C1.gridwidth = 1;
        C1.gridheight = 4;
        C1.weightx = 0;
        C1.weighty = 0;
        C1.fill = GridBagConstraints.NONE;
        C1.anchor = GridBagConstraints.CENTER;
        p.add(N1, C1);
        
        JLabel N1hp = new JLabel(img3);
        GridBagConstraints C1hp= new GridBagConstraints();
        C1hp.gridx = 1;
        C1hp.gridy = 0;
        C1hp.gridwidth = 1;
        C1hp.gridheight = 1;
        C1hp.weightx = 0;
        C1hp.weighty = 0;
        C1hp.fill = GridBagConstraints.NONE;
        C1hp.anchor = GridBagConstraints.EAST;
        p.add(N1hp, C1hp);
        
        JLabel N1card = new JLabel(img2);
        GridBagConstraints C1card= new GridBagConstraints();
        C1card.gridx = 1;
        C1card.gridy = 1;
        C1card.gridwidth = 1;
        C1card.gridheight = 1;
        C1card.weightx = 0;
        C1card.weighty = 0;
        C1card.fill = GridBagConstraints.NONE;
        C1card.anchor = GridBagConstraints.EAST;
        p.add(N1card, C1card);
        
        JLabel N1atk = new JLabel(img2);
        GridBagConstraints C1atk= new GridBagConstraints();
        C1atk.gridx = 1;
        C1atk.gridy = 2;
        C1atk.gridwidth = 1;
        C1atk.gridheight = 1;
        C1atk.weightx = 0;
        C1atk.weighty = 0;
        C1atk.fill = GridBagConstraints.NONE;
        C1atk.anchor = GridBagConstraints.EAST;
        p.add(N1atk, C1atk);       
  
        JLabel N1def = new JLabel(img5);
        GridBagConstraints C1def= new GridBagConstraints();
        C1def.gridx = 1;
        C1def.gridy = 3;
        C1def.gridwidth = 1;
        C1def.gridheight = 1;
        C1def.weightx = 0;
        C1def.weighty = 0;
        C1def.fill = GridBagConstraints.NONE;
        C1def.anchor = GridBagConstraints.EAST;
        p.add(N1def, C1def);
        
        JLabel N1wep = new JLabel(img4);
        GridBagConstraints C1wep= new GridBagConstraints();
        C1wep.gridx = 2;
        C1wep.gridy = 4;
        C1wep.gridwidth = 1;
        C1wep.gridheight = 1;
        C1wep.weightx = 0;
        C1wep.weighty = 0;
        C1wep.fill = GridBagConstraints.NONE;
        C1wep.anchor = GridBagConstraints.CENTER;
        p.add(N1wep, C1wep);   
        
        //=========================================================== enemy2
            
        JButton N2 = new JButton(img1);
        GridBagConstraints C2 = new GridBagConstraints();
        C2.gridx = 4;
        C2.gridy = 0;
        C2.gridwidth = 1;
        C2.gridheight = 4;
        C2.weightx = 0;
        C2.weighty = 0;
        C2.fill = GridBagConstraints.NONE;
        C2.anchor = GridBagConstraints.CENTER;
        p.add(N2, C2);
        
        JLabel N2hp = new JLabel(img3);
        GridBagConstraints C2hp= new GridBagConstraints();
        C2hp.gridx = 3;
        C2hp.gridy = 0;
        C2hp.gridwidth = 1;
        C2hp.gridheight = 1;
        C2hp.weightx = 0;
        C2hp.weighty = 0;
        C2hp.fill = GridBagConstraints.NONE;
        C2hp.anchor = GridBagConstraints.EAST;
        p.add(N2hp, C2hp);
        
        JLabel N2card = new JLabel("CARD:9999");
        GridBagConstraints C2card= new GridBagConstraints();
        C2card.gridx = 3;
        C2card.gridy = 1;
        C2card.gridwidth = 1;
        C2card.gridheight = 1;
        C2card.weightx = 0;
        C2card.weighty = 0;
        C2card.fill = GridBagConstraints.NONE;
        C2card.anchor = GridBagConstraints.EAST;
        p.add(N2card, C2card);
        
        JLabel N2atk = new JLabel(img2);
        GridBagConstraints C2atk= new GridBagConstraints();
        C2atk.gridx = 3;
        C2atk.gridy = 2;
        C2atk.gridwidth = 1;
        C2atk.gridheight = 1;
        C2atk.weightx = 0;
        C2atk.weighty = 0;
        C2atk.fill = GridBagConstraints.NONE;
        C2atk.anchor = GridBagConstraints.EAST;
        p.add(N2atk, C2atk);       
  
        JLabel N2def = new JLabel(img5);
        GridBagConstraints C2def= new GridBagConstraints();
        C2def.gridx = 3;
        C2def.gridy = 3;
        C2def.gridwidth = 1;
        C2def.gridheight = 1;
        C2def.weightx = 0;
        C2def.weighty = 0;
        C2def.fill = GridBagConstraints.NONE;
        C2def.anchor = GridBagConstraints.EAST;
        p.add(N2def, C2def);
        
        JLabel N2wep = new JLabel(img4);
        GridBagConstraints C2wep= new GridBagConstraints();
        C2wep.gridx = 4;
        C2wep.gridy = 4;
        C2wep.gridwidth = 1;
        C2wep.gridheight = 1;
        C2wep.weightx = 0;
        C2wep.weighty = 0;
        C2wep.fill = GridBagConstraints.NONE;
        C2wep.anchor = GridBagConstraints.CENTER;
        p.add(N2wep, C2wep);  
       
        //=========================================================== enemy3
                
        JButton N3 = new JButton(img1);
        GridBagConstraints C3 = new GridBagConstraints();
        C3.gridx = 6;
        C3.gridy = 0;
        C3.gridwidth = 1;
        C3.gridheight = 4;
        C3.weightx = 0;
        C3.weighty = 0;
        C3.fill = GridBagConstraints.NONE;
        C3.anchor = GridBagConstraints.CENTER;
        p.add(N3, C3);
        
        JLabel N3hp = new JLabel(img3);
        GridBagConstraints C3hp= new GridBagConstraints();
        C3hp.gridx = 5;
        C3hp.gridy = 0;
        C3hp.gridwidth = 1;
        C3hp.gridheight = 1;
        C3hp.weightx = 0;
        C3hp.weighty = 0;
        C3hp.fill = GridBagConstraints.NONE;
        C3hp.anchor = GridBagConstraints.EAST;
        p.add(N3hp, C3hp);
        
        JLabel N3card = new JLabel("CARD:9999");
        GridBagConstraints C3card= new GridBagConstraints();
        C3card.gridx = 5;
        C3card.gridy = 1;
        C3card.gridwidth = 1;
        C3card.gridheight = 1;
        C3card.weightx = 0;
        C3card.weighty = 0;
        C3card.fill = GridBagConstraints.NONE;
        C3card.anchor = GridBagConstraints.EAST;
        p.add(N3card, C3card);
        
        JLabel N3atk = new JLabel(img2);
        GridBagConstraints C3atk= new GridBagConstraints();
        C3atk.gridx = 5;
        C3atk.gridy = 2;
        C3atk.gridwidth = 1;
        C3atk.gridheight = 1;
        C3atk.weightx = 0;
        C3atk.weighty = 0;
        C3atk.fill = GridBagConstraints.NONE;
        C3atk.anchor = GridBagConstraints.EAST;
        p.add(N3atk, C3atk);       
  
        JLabel N3def = new JLabel(img5);
        GridBagConstraints C3def= new GridBagConstraints();
        C3def.gridx = 5;
        C3def.gridy = 3;
        C3def.gridwidth = 1;
        C3def.gridheight = 1;
        C3def.weightx = 0;
        C3def.weighty = 0;
        C3def.fill = GridBagConstraints.NONE;
        C3def.anchor = GridBagConstraints.EAST;
        p.add(N3def, C3def);
        
        JLabel N3wep = new JLabel(img4);
        GridBagConstraints C3wep= new GridBagConstraints();
        C3wep.gridx = 6;
        C3wep.gridy = 4;
        C3wep.gridwidth = 1;
        C3wep.gridheight = 1;
        C3wep.weightx = 0;
        C3wep.weighty = 0;
        C3wep.fill = GridBagConstraints.NONE;
        C3wep.anchor = GridBagConstraints.CENTER;
        p.add(N3wep, C3wep);
        
      //=========================================================== YOU

            JLabel ne = new JLabel();
            GridBagConstraints ce = new GridBagConstraints();
            ce.gridx = 0;
            ce.gridy = 5;
            ce.gridwidth = 1;
            ce.gridheight = 1;
            ce.weightx = 0;
            ce.weighty = 1;
            ce.fill = GridBagConstraints.NONE;
            ce.anchor = GridBagConstraints.SOUTH;
            p.add(ne, ce);
        
        for(int i=1; i<5; i++){
            JButton n5 = new JButton(img1);
            GridBagConstraints c5 = new GridBagConstraints();
            c5.gridx = i;
            c5.gridy = 11;
            c5.gridwidth = 1;
            c5.gridheight = 3;
            c5.weightx = 0;
            c5.weighty = 0;
            c5.fill = GridBagConstraints.NONE;
            c5.anchor = GridBagConstraints.CENTER;
            p.add(n5, c5);
        }
        
        JLabel NYOU = new JLabel(img1);
        GridBagConstraints CYOU = new GridBagConstraints();
        CYOU.gridx = 6;
        CYOU.gridy = 10;
        CYOU.gridwidth = 1;
        CYOU.gridheight = 4;
        CYOU.weightx = 0;
        CYOU.weighty = 0;
        CYOU.fill = GridBagConstraints.NONE;
        CYOU.anchor = GridBagConstraints.CENTER;
        p.add(NYOU, CYOU);

        JLabel NYOUhp = new JLabel(img3);
        GridBagConstraints CYOUhp = new GridBagConstraints();
        CYOUhp.gridx = 5;
        CYOUhp.gridy = 10;
        CYOUhp.gridwidth = 1;
        CYOUhp.gridheight = 1;
        CYOUhp.weightx = 0;
        CYOUhp.weighty = 0;
        CYOUhp.fill = GridBagConstraints.NONE;
        CYOUhp.anchor = GridBagConstraints.EAST;
        p.add(NYOUhp, CYOUhp);

        JLabel NYOUatk = new JLabel(img2);
        GridBagConstraints CYOUatk = new GridBagConstraints();
        CYOUatk.gridx = 5;
        CYOUatk.gridy = 11;
        CYOUatk.gridwidth = 1;
        CYOUatk.gridheight = 1;
        CYOUatk.weightx = 0;
        CYOUatk.weighty = 0;
        CYOUatk.fill = GridBagConstraints.NONE;
        CYOUatk.anchor = GridBagConstraints.EAST;
        p.add(NYOUatk, CYOUatk);
        
        JLabel NYOUdef = new JLabel(img5);
        GridBagConstraints CYOUdef = new GridBagConstraints();
        CYOUdef.gridx = 5;
        CYOUdef.gridy = 12;
        CYOUdef.gridwidth = 1;
        CYOUdef.gridheight = 1;
        CYOUdef.weightx = 0;
        CYOUdef.weighty = 0;
        CYOUdef.fill = GridBagConstraints.NONE;
        CYOUdef.anchor = GridBagConstraints.EAST;
        p.add(NYOUdef, CYOUdef);

        JLabel NYOUwep = new JLabel(img4);
        GridBagConstraints CYOUwep = new GridBagConstraints();
        CYOUwep.gridx = 5;
        CYOUwep.gridy = 13;
        CYOUwep.gridwidth = 1;
        CYOUwep.gridheight = 1;
        CYOUwep.weightx = 0;
        CYOUwep.weighty = 0;
        CYOUwep.fill = GridBagConstraints.NONE;
        CYOUwep.anchor = GridBagConstraints.EAST;
        p.add(NYOUwep, CYOUwep);
        
        JButton NYOUend = new JButton(img6);
        GridBagConstraints CYOUend = new GridBagConstraints();
        CYOUend.gridx = 6;
        CYOUend.gridy = 14;
        CYOUend.gridwidth = 1;
        CYOUend.gridheight = 1;
        CYOUend.weightx = 0;
        CYOUend.weighty = 0;
        CYOUend.fill = GridBagConstraints.NONE;
        CYOUend.anchor = GridBagConstraints.NORTH;
        p.add(NYOUend, CYOUend);
        
 
        JLabel Ninfo = new JLabel("QAQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        GridBagConstraints Cinfo = new GridBagConstraints();
        Cinfo.gridx = 2;
        Cinfo.gridy = 5;
        Cinfo.gridwidth = 4;
        Cinfo.gridheight = 1;
        Cinfo.weightx = 0;
        Cinfo.weighty = 0;
        Cinfo.fill = GridBagConstraints.NONE;
        Cinfo.anchor = GridBagConstraints.CENTER;
        p.add(Ninfo, Cinfo);
        
        p.setVisible(true);
    }
    
}