
public class ClassicEnemy extends Enemy {
	private static int speed = 10;
	private boolean rightToLeft;

	public ClassicEnemy(int x, int y) {
		super(x, y);
		rightToLeft = false;
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
