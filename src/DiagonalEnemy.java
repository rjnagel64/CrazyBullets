
public class DiagonalEnemy extends Enemy {
	private static int xSpeed = 10;
	private static int ySpeed = 2;
	private boolean rightToLeft;

	public DiagonalEnemy(int x, int y) {
		super(x, y);
		rightToLeft = false;
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
