package prog.unknown_hero.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import prog.unknown_hero.core.GameController;

public class WaitingPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WaitingPage(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		BufferedImage background;
		try {
			background = ImageIO.read(new File(".\\img\\F-2.jpg"));
			panel = new ImagePanel(background);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContentPane(panel);

		setVisible(true);
		
        System.out.println( "Waiting page created." );
	}
	
}
