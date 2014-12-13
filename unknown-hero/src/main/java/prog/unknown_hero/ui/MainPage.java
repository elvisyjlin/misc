package prog.unknown_hero.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPage() {
		setTitle("變身英雄");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BufferedImage background;
		try {
			background = ImageIO.read(new File(".\\img\\2014-10-06 01.21.00.jpg"));
			setContentPane(new ImagePanel(resize(background, 800, 600)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
