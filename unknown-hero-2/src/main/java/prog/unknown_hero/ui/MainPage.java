package prog.unknown_hero.ui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





import javax.imageio.ImageIO;
import javax.swing.*;

import prog.unknown_hero.core.GameController;

public class MainPage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPage(final String title,final int width,final int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		BufferedImage background;
		try {
			background = ImageIO.read(new File(".\\img\\F-3.jpg"));
			panel = new ImagePanel(background);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContentPane(panel);

		final ImageIcon buttonImage_def = new ImageIcon(".\\img\\B-NOT CLICK.jpg");
		final ImageIcon buttonImage_hov = new ImageIcon(".\\img\\B-CLICK.jpg");
		
		panel.setLayout(null);
		final JButton button = new JButton(buttonImage_def);
		button.setSize(322, 300);
		button.setBounds(239, 300, 322, 300);
		panel.add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setIcon(buttonImage_hov);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setIcon(buttonImage_def);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				WaitingPage w = new WaitingPage(title, width, height);
				Thread t = new Thread(new Runnable() {

					public void run() {
						GameController.login(false, w);
					}
					
				});
				t.start();
				dispose();
			}
		});
		
		setVisible(true);
		
        System.out.println( "Main page created." );
	}
	
	public BufferedImage resize(BufferedImage image, int small_w, int small_h) {
		BufferedImage newImage = new BufferedImage(small_w, small_h, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImage.createGraphics();
		g.drawImage(image, 0, 0, small_w, small_h, null);
		g.dispose();
		return newImage;
	}
	
}
