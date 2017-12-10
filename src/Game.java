import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	private static final int POINTS_PER_ENEMY = 100;
	private static final int POINTS_TO_WIN = 1000;
	private static final int MAX_ENEMIES = 7;
	
	private static final int MOVE_AMOUNT = 32;
	
	private static final int MS_PER_FRAME = 32;
	
	private static final int ENEMY_DELAY = 250;
	private static final int SPAWN_DELAY = 2000;
	
	private int score = 0;
	
	private int bulletX = -32;
	private int bulletY = -32;
	private boolean bulletMove = false;
	private boolean bulletActive = false;
	private Image bulletImage;

	private Timer gameTimer;
	private Timer enemyTimer;
	private Timer enemySpawnTimer;

	private Ship ship;
	private List<Enemy> enemies;

	public Game() {
		ImageIcon ii = new ImageIcon("bullet.png");
		bulletImage = ii.getImage();

		ship = new Ship();
		enemies = new ArrayList<Enemy>();

		gameTimer = new Timer(MS_PER_FRAME, this);
		gameTimer.start();

		enemyTimer = new Timer(ENEMY_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for (Enemy e : enemies) {
					e.update();
				}
			}
		});
		enemyTimer.start();

		enemySpawnTimer = new Timer(SPAWN_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (enemies.size() < MAX_ENEMIES) {
					Random r = new Random();
					
					int x = r.nextInt(CrazyBullets.SCREEN_WIDTH);
					int y = r.nextInt(CrazyBullets.SCREEN_HEIGHT / 4);
					int type = r.nextInt(3);
					boolean rightToLeft = r.nextBoolean();
					
					switch (type) {
					case 0:
						enemies.add(new ClassicEnemy(x, y, rightToLeft));
						break;
					case 1:
						enemies.add(new ParabolaEnemy(x, y, rightToLeft));
						break;
					case 2:
						enemies.add(new DiagonalEnemy(x, type, rightToLeft));
						break;
					default:
						// This should never be reached.
						break;
					}
				}
			}
		});
		enemySpawnTimer.start();

		setFocusable(true);
		addKeyListener(new KeypressHandler());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Update the bullet's position.
		if (bulletMove && bulletActive){
  			bulletY -= 15;
  			if (bulletY <= -50){
  				bulletMove = false;
  				bulletActive = false;
  			}
  		}
		
		// Check for bullet collisions.
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);

			// If a collision occurs, delete the enemy and increment the score.
			if (e.collides(
					bulletX,
					bulletY,
					bulletImage.getWidth(null),
					bulletImage.getHeight(null))) {

				enemies.remove(i);
				score += POINTS_PER_ENEMY;
				System.out.println("AABB: hit");
			
			// Otherwise, if this enemy has fallen off the bottom of the screen,
			// The game has been lost.
			} else if (e.getY() >= CrazyBullets.SCREEN_HEIGHT) {
				enemySpawnTimer.stop();
				gameTimer.stop();
				enemyTimer.stop();
				System.out.println("you lose");
			}
		}

		// The game is won when sufficient points have been earned.
		if (score >= POINTS_TO_WIN) {
			enemySpawnTimer.stop();
			gameTimer.stop();
			enemyTimer.stop();
			System.out.println("you win");
		}

		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bulletImage, bulletX, bulletY, null);

		ship.paintComponent(g);

		for (Enemy e : enemies) {
			e.paintComponents(g);
		}
	}

	private class KeypressHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				ship.shift(-MOVE_AMOUNT);
			} else if (key == KeyEvent.VK_RIGHT) {
				ship.shift(MOVE_AMOUNT);
			} else if (key == KeyEvent.VK_SPACE) { 
				if (bulletActive == false) {
					// 72 is half the width of the ship minus half the width of
					// the bullet. This centers the bullet above the ship.
	  				bulletX = (ship.getPos()) + 72;
	  				bulletY = ship.getPosY();
	  			}
	  			bulletMove = true;
	  			bulletActive = true;
			} else {
				//ignore all other key presses
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// Ignore this event.
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Ignore this event.
		}
	}
}
