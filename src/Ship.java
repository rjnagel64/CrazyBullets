import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel {
	private Image image;
	
	// Since the ship is always at the bottom of the screen, there is no need
	// to track the ship's y-coordinate.
	private int x;
	private int y;
	
	public Ship() {
		ImageIcon ii = new ImageIcon("ship.png"); 
		image = ii.getImage();
		
		x = (CrazyBullets.SCREEN_WIDTH / 2) - (image.getWidth(null) / 2);
		y = (CrazyBullets.SCREEN_HEIGHT - 50) - image.getHeight(this);
		
		setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
	}
	
	public void shift(int delta) {
		x += delta;
	}
	
	public int getPos() {
		return x;
	}
	public int getPosY() {
		return y;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// The y-coordinate is the height of the image because the .drawImage()
		// method puts the top-left corner of the image at (x, y).
		// 20 is subtracted from the screen height so as to provide a small
		// border below the ship.
		g.drawImage(image, x, (CrazyBullets.SCREEN_HEIGHT - 50) - image.getHeight(this), null);
	}
}
