package prog.unknown_hero.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public ImagePanel(BufferedImage image) {
		this.image = image;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
	
}
