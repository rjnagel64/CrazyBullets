
public class ClassicEnemy extends Enemy {
	private static int speed = 10;

	public ClassicEnemy(int x, int y, boolean rightToLeft) {
		super(x, y, rightToLeft);
	}
	
	public void update() {
		if (rightToLeft) {
			x -= speed;
		} else {
			x += speed;
		}
		
		if (x < 16 || x + image.getWidth(null) > CrazyBullets.SCREEN_WIDTH - 16) {
			rightToLeft = !rightToLeft;
			y += 20;
		}
	}

}
