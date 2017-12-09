import java.awt.Dimension;

import javax.swing.ImageIcon;

public class ParabolaEnemy extends Enemy {
	private int xSpeed = 10;
	private int ySpeed = 1;

	public ParabolaEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);

		ImageIcon ii = new ImageIcon("parabola_enemy.png");
		image = ii.getImage();

		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
	}

	public void update() {
		if (rightToLeft) {
			x -= xSpeed;
		} else {
			x += xSpeed;
		}
		y += ySpeed;
		ySpeed++;
		
		if (x < 0 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH) {
			rightToLeft = !rightToLeft;
		}
	}

}
