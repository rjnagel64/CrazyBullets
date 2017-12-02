import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel {
	private Image image;
	
	// Since the ship is always at the bottom of the screen, there is no need
	// to track the y-coordinate.
	private int x;
	
	public Ship() {
		ImageIcon ii = new ImageIcon("ship.png"); 
		image = ii.getImage();
		x = 320 - (image.getWidth(null) / 2);
		setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
	}
	
	public void shift(int delta) {
		x += delta;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// The y-coordinate is the height of the image because the .drawImage()
		// method puts the top-left corner of the image at (x, y).
		g.drawImage(image, x, CrazyBullets.SCREEN_HEIGHT - image.getHeight(this) - 20, null);
	}
}
