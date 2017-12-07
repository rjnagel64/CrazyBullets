
public class ParabolaEnemy extends Enemy {
	private int xSpeed = 10;
	private int ySpeed = 1;

	public ParabolaEnemy(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		x += xSpeed;
		y += ySpeed;
		
		ySpeed++;
	}

}
