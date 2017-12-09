import java.awt.Dimension;

import javax.swing.ImageIcon;

public class ClassicEnemy extends Enemy {
	private static int speed = 10;

	public ClassicEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);

		ImageIcon ii = new ImageIcon("classic_enemy.png");
		image = ii.getImage();

		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
	}
	
	public void update() {
		if (rightToLeft) {
			x -= speed;
		} else {
			x += speed;
		}
		
		if (x < 0 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH) {
			rightToLeft = !rightToLeft;
			y += 20;
		}
	}

}
