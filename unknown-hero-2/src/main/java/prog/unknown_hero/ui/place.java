package prog.unknown_hero.ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Sender;

public class place extends JFrame {
    	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ImageIcon card_back_img;
	ImageIcon img2;
	ImageIcon img3;
	ImageIcon img4;
	ImageIcon img5;
	ImageIcon img6;
	ImageIcon img7;
	BufferedImage background;
	
	private boolean loadImages() {
		try {
			card_back_img = new ImageIcon("./img/DSC04833.JPG");
			img2 = new ImageIcon("./img/ATK-13.jpg");
			img3 = new ImageIcon("./img/HP-3.jpg");
			img4 = new ImageIcon("./img/WEAPON-無.jpg");
			img5 = new ImageIcon("./img/DEF+0.jpg");
			img6 = new ImageIcon("./img/END-BOTTON-NOT-CLICK.jpg");
			img7 = new ImageIcon("./img/CD-3.jpg");
			background = ImageIO.read(new File(".\\img\\BG-1.jpg"));
		} catch(IOException ex) {
			return false;
		}
		return true;
	}

	public place() {
		if(!loadImages()) {
			return;
		}
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new ImagePanel(background);
        setContentPane(panel);
        panel.setLayout(new GridBagLayout());

        //=========================================================== enemy1
        JButton[] hero = new JButton[4];
        JLabel[] hp = new JLabel[4];
        JLabel[] atk = new JLabel[4];
        JLabel[] def = new JLabel[4];
        JLabel[] cardnum = new JLabel[4];
        JLabel[] weapon = new JLabel[4];
        JLabel end_button = new JLabel();
        
        GridBagConstraints[] heroC = new GridBagConstraints[4];
        GridBagConstraints[] hpC = new GridBagConstraints[4];
        GridBagConstraints[] atkC = new GridBagConstraints[4];
        GridBagConstraints[] defC = new GridBagConstraints[4];
        GridBagConstraints[] cardnumC = new GridBagConstraints[4];
        GridBagConstraints[] weaponC = new GridBagConstraints[4];
        GridBagConstraints end_buttonC = new GridBagConstraints();
        
        for(int i=0; i<4; i++) {
        	hero[i].setIcon(card_back_img);
            hp[i].setIcon(img3);
            atk[i].setIcon(img2);
            def[i].setIcon(img5);
            cardnum[i].setIcon(img7);
            weapon[i].setIcon(img4);
            end_button.setIcon(img6);
            
        	switch(i) {
        	case 1:
        		heroC[1].gridx = 2;
        		heroC[1].gridy = 0;
        		heroC[1].gridwidth = 1;
        		heroC[1].gridheight = 4;
        		heroC[1].weightx = 0;
        		heroC[1].weighty = 0;
        		heroC[1].fill = GridBagConstraints.NONE;
        		heroC[1].anchor = GridBagConstraints.CENTER;
                hpC[1].gridx = 1;
                hpC[1].gridy = 0;
                hpC[1].gridwidth = 1;
                hpC[1].gridheight = 1;
                hpC[1].weightx = 0;
                hpC[1].weighty = 0;
                hpC[1].fill = GridBagConstraints.NONE;
                hpC[1].anchor = GridBagConstraints.EAST;
                atkC[1].gridx = 1;
                atkC[1].gridy = 2;
                atkC[1].gridwidth = 1;
                atkC[1].gridheight = 1;
                atkC[1].weightx = 0;
                atkC[1].weighty = 0;
                atkC[1].fill = GridBagConstraints.NONE;
                atkC[1].anchor = GridBagConstraints.EAST;
                defC[1].gridx = 1;
                defC[1].gridy = 3;
                defC[1].gridwidth = 1;
                defC[1].gridheight = 1;
                defC[1].weightx = 0;
                defC[1].weighty = 0;
                defC[1].fill = GridBagConstraints.NONE;
                defC[1].anchor = GridBagConstraints.EAST;
                cardnumC[1].gridx = 1;
                cardnumC[1].gridy = 1;
                cardnumC[1].gridwidth = 1;
                cardnumC[1].gridheight = 1;
                cardnumC[1].weightx = 0;
                cardnumC[1].weighty = 0;
                cardnumC[1].fill = GridBagConstraints.NONE;
                cardnumC[1].anchor = GridBagConstraints.EAST;
                weaponC[1].gridx = 2;
                weaponC[1].gridy = 4;
                weaponC[1].gridwidth = 1;
                weaponC[1].gridheight = 1;
                weaponC[1].weightx = 0;
                weaponC[1].weighty = 0;
                weaponC[1].fill = GridBagConstraints.NONE;
                weaponC[1].anchor = GridBagConstraints.CENTER;
        		break;
        	case 2:
        		heroC[2].gridx = 4;
        		heroC[2].gridy = 0;
        		heroC[2].gridwidth = 1;
        		heroC[2].gridheight = 4;
        		heroC[2].weightx = 0;
        		heroC[2].weighty = 0;
        		heroC[2].fill = GridBagConstraints.NONE;
        		heroC[2].anchor = GridBagConstraints.CENTER;
                hpC[2].gridx = 3;
                hpC[2].gridy = 0;
                hpC[2].gridwidth = 1;
                hpC[2].gridheight = 1;
                hpC[2].weightx = 0;
                hpC[2].weighty = 0;
                hpC[2].fill = GridBagConstraints.NONE;
                hpC[2].anchor = GridBagConstraints.EAST;
                atkC[2].gridx = 3;
                atkC[2].gridy = 2;
                atkC[2].gridwidth = 1;
                atkC[2].gridheight = 1;
                atkC[2].weightx = 0;
                atkC[2].weighty = 0;
                atkC[2].fill = GridBagConstraints.NONE;
                atkC[2].anchor = GridBagConstraints.EAST;
                defC[2].gridx = 3;
                defC[2].gridy = 3;
                defC[2].gridwidth = 1;
                defC[2].gridheight = 1;
                defC[2].weightx = 0;
                defC[2].weighty = 0;
                defC[2].fill = GridBagConstraints.NONE;
                defC[2].anchor = GridBagConstraints.EAST;
                cardnumC[2].gridx = 3;
                cardnumC[2].gridy = 1;
                cardnumC[2].gridwidth = 1;
                cardnumC[2].gridheight = 1;
                cardnumC[2].weightx = 0;
                cardnumC[2].weighty = 0;
                cardnumC[2].fill = GridBagConstraints.NONE;
                cardnumC[2].anchor = GridBagConstraints.EAST;
                weaponC[2].gridx = 4;
                weaponC[2].gridy = 4;
                weaponC[2].gridwidth = 1;
                weaponC[2].gridheight = 1;
                weaponC[2].weightx = 0;
                weaponC[2].weighty = 0;
                weaponC[2].fill = GridBagConstraints.NONE;
                weaponC[2].anchor = GridBagConstraints.CENTER;
                break;
        	case 3:
        		heroC[3].gridx = 6;
        		heroC[3].gridy = 0;
        		heroC[3].gridwidth = 1;
        		heroC[3].gridheight = 4;
        		heroC[3].weightx = 0;
        		heroC[3].weighty = 0;
        		heroC[3].fill = GridBagConstraints.NONE;
        		heroC[3].anchor = GridBagConstraints.CENTER;
                hpC[3].gridx = 5;
                hpC[3].gridy = 0;
                hpC[3].gridwidth = 1;
                hpC[3].gridheight = 1;
                hpC[3].weightx = 0;
                hpC[3].weighty = 0;
                hpC[3].fill = GridBagConstraints.NONE;
                hpC[3].anchor = GridBagConstraints.EAST;
                atkC[3].gridx = 5;
                atkC[3].gridy = 2;
                atkC[3].gridwidth = 1;
                atkC[3].gridheight = 1;
                atkC[3].weightx = 0;
                atkC[3].weighty = 0;
                atkC[3].fill = GridBagConstraints.NONE;
                atkC[3].anchor = GridBagConstraints.EAST;
                defC[3].gridx = 5;
                defC[3].gridy = 3;
                defC[3].gridwidth = 1;
                defC[3].gridheight = 1;
                defC[3].weightx = 0;
                defC[3].weighty = 0;
                defC[3].fill = GridBagConstraints.NONE;
                defC[3].anchor = GridBagConstraints.EAST;
                cardnumC[3].gridx = 5;
                cardnumC[3].gridy = 1;
                cardnumC[3].gridwidth = 1;
                cardnumC[3].gridheight = 1;
                cardnumC[3].weightx = 0;
                cardnumC[3].weighty = 0;
                cardnumC[3].fill = GridBagConstraints.NONE;
                cardnumC[3].anchor = GridBagConstraints.EAST;
                weaponC[3].gridx = 6;
                weaponC[3].gridy = 4;
                weaponC[3].gridwidth = 1;
                weaponC[3].gridheight = 1;
                weaponC[3].weightx = 0;
                weaponC[3].weighty = 0;
                weaponC[3].fill = GridBagConstraints.NONE;
                weaponC[3].anchor = GridBagConstraints.CENTER;
                break;
        	case 0:
        		heroC[0].gridx = 6;
        		heroC[0].gridy = 10;
        		heroC[0].gridwidth = 1;
        		heroC[0].gridheight = 4;
        		heroC[0].weightx = 0;
        		heroC[0].weighty = 0;
        		heroC[0].fill = GridBagConstraints.NONE;
        		heroC[0].anchor = GridBagConstraints.CENTER;
                hpC[0].gridx = 5;
                hpC[0].gridy = 10;
                hpC[0].gridwidth = 1;
                hpC[0].gridheight = 1;
                hpC[0].weightx = 0;
                hpC[0].weighty = 0;
                hpC[0].fill = GridBagConstraints.NONE;
                hpC[0].anchor = GridBagConstraints.EAST;
                atkC[0].gridx = 5;
                atkC[0].gridy = 11;
                atkC[0].gridwidth = 1;
                atkC[0].gridheight = 1;
                atkC[0].weightx = 0;
                atkC[0].weighty = 0;
                atkC[0].fill = GridBagConstraints.NONE;
                atkC[0].anchor = GridBagConstraints.EAST;
                defC[0].gridx = 5;
                defC[0].gridy = 12;
                defC[0].gridwidth = 1;
                defC[0].gridheight = 1;
                defC[0].weightx = 0;
                defC[0].weighty = 0;
                defC[0].fill = GridBagConstraints.NONE;
                defC[0].anchor = GridBagConstraints.EAST;
                weaponC[0].gridx = 5;
                weaponC[0].gridy = 13;
                weaponC[0].gridwidth = 1;
                weaponC[0].gridheight = 1;
                weaponC[0].weightx = 0;
                weaponC[0].weighty = 0;
                weaponC[0].fill = GridBagConstraints.NONE;
                weaponC[0].anchor = GridBagConstraints.EAST;
                end_buttonC.gridx = 6;
                end_buttonC.gridy = 14;
                end_buttonC.gridwidth = 1;
                end_buttonC.gridheight = 1;
                end_buttonC.weightx = 0;
                end_buttonC.weighty = 0;
                end_buttonC.fill = GridBagConstraints.NONE;
                end_buttonC.anchor = GridBagConstraints.NORTH;
                break;
        	}
            panel.add(hero[i], heroC[i]);
            panel.add(hp[i], hpC[i]);
            panel.add(atk[i], atkC[i]);
            panel.add(def[i], defC[i]);
            panel.add(cardnum[i], cardnumC[i]);
            panel.add(weapon[i], weaponC[i]);
            panel.add(end_button, end_buttonC);
        }
          
          
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
          panel.add(ne, ce);
          
          for(int i=1; i<5; i++){
              JButton n5 = new JButton(card_back_img);
              GridBagConstraints c5 = new GridBagConstraints();
              c5.gridx = i;
              c5.gridy = 11;
              c5.gridwidth = 1;
              c5.gridheight = 3;
              c5.weightx = 0;
              c5.weighty = 0;
              c5.fill = GridBagConstraints.NONE;
              c5.anchor = GridBagConstraints.CENTER;
              panel.add(n5, c5);
          }
          
                    
   
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
          panel.add(Ninfo, Cinfo);
          
          setVisible(true);
          
          Thread detector = new Thread(new Runnable() {

        	public void run() {
        		  if(Sender.hasMessage()) {
        			  BaseMessage message = Sender.get();
        			  String type = message.type();
        			  String[] contents = message.content();
        			  if("ORDER".equals(message.type())) {
        				  
        			  } else if("SETHAND".equals(message.type())) {
        				  
        			  } else if("SETHERO".equals(message.type())) {
        				  
        			  } else if("SETAP".equals(message.type())) {
        				  
        			  } else if("SETDP".equals(message.type())) {
        				  
        			  } else if("SETWP".equals(message.type())) {
        				  
        			  } else if("DELWP".equals(message.type())) {
        				  
        			  } else if("SETINFO".equals(message.type())) {
        				  
        			  } else if("SETHANDN".equals(message.type())) {
        				  
        			  }
        		  }
        		  try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
       	  
          });
	}

}