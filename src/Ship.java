import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel {
	private Image image;
	
	private int x;
	private int y;
	
	public Ship() {
		ImageIcon ii = new ImageIcon("ship.png"); 
		image = ii.getImage();
		
		x = (CrazyBullets.SCREEN_WIDTH / 2) - (image.getWidth(null) / 2);
		// (x, y) is the coordinates of the upper-left corner of the image.
		// 50 is subtracted to leave some space at the bottom of the screen.
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

		g.drawImage(image, x, y, null);
	}
}
