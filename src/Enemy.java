import java.awt.Graphics;
import java.awt.Image;

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
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public boolean collides(int x, int y, int width, int height) {
		if (this.x < x + width &&
				this.x + this.image.getWidth(null) > x &&
				this.y < y + height &&
				this.y + this.image.getHeight(null) > y) {
			return true;
		}
		return false;
	}

	public void update() {
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);

		g.drawImage(image, x, y, null);
	}
}
