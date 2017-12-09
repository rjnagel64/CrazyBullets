import java.awt.Dimension;

import javax.swing.ImageIcon;

public class DiagonalEnemy extends Enemy {
	private static int xSpeed = 10;
	private static int ySpeed = 2;

	public DiagonalEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);
		
		ImageIcon ii = new ImageIcon("diagonal_enemy.png");
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
		
		if (x < 0 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH) {
			rightToLeft = !rightToLeft;
		}
	}
}
