package prog.unknown_hero.ui;

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
		setTitle("MainPage");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BufferedImage background;
		try {
			background = ImageIO.read(new File(".\\img\\2014-10-06 01.21.00.jpg"));
			setContentPane(new ImagePanel(background));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
