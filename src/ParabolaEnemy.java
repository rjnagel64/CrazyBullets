
public class ParabolaEnemy extends Enemy {
	private int xSpeed = 10;
	private int ySpeed = 1;

	public ParabolaEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);
	}

	public void update() {
		if (rightToLeft) {
			x -= xSpeed;
		} else {
			x += xSpeed;
		}
		y += ySpeed;
		ySpeed++;
		
		if (x < 16 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH - 16) {
			rightToLeft = !rightToLeft;
			y += 20;
		}
	}

}
