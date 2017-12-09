import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemy extends JPanel {
	protected int x;
	protected int y;
	protected boolean rightToLeft;
	
	protected Image image;
	
	public Enemy(int x, int y, boolean rightToLeft) {
		this.x = x;
		this.y = y;
		this.rightToLeft = rightToLeft;

		// TODO: Set this in the subclasses.
		ImageIcon ii = new ImageIcon("enemy1.png");
		image = ii.getImage();

		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
	}
	
	public void update() {
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(image, x, y, null);
	}
}
