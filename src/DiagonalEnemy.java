
public class DiagonalEnemy extends Enemy {
	private static int xSpeed = 10;
	private static int ySpeed = 2;

	public DiagonalEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);
	}
	
	public void update() {
		if (rightToLeft) {
			x -= xSpeed;
		} else {
			x += xSpeed;
		}
		y += ySpeed;
		
		if (x < 16 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH - 16) {
			rightToLeft = !rightToLeft;
		}
	}
}
