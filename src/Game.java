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
	private static final int MS_PER_FRAME = 32;
	private static final int MOVE_AMOUNT = 32;
	private static final int ENEMY_DELAY = 250;
	private static final int SPAWN_DELAY = 2000;
	private static final int MAX_ENEMIES = 7;
	
	private int score = 0;
	private int bulletX = -32;
	private int bulletY = -32;
	private boolean bulletMove = false;
	private boolean bulletActive = false;
	private Image bulletImage;
	
	private Timer gameTimer;
	private Timer enemyTimer;
	private Timer enemySpawnTimer;
	private Timer bulletCheck;

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
		
		// this will check for win/loss/and hit collision
		// it will also update the score in the top right corner
		bulletCheck = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				int yUpper = bulletY + 10;
				int yLower = bulletY - 10;
				int xLeft = bulletX - 30;
				int xRight = bulletX + 30;
				for(int i = 0; i < enemies.size(); i++) {
					int Y = (enemies.get(i)).getY(); 
					int X = (enemies.get(i)).getX(); 
					if (Y <= yUpper && Y >= yLower && X <= xRight && X >= xLeft) {
						enemies.remove(i);
						score += 100;
						System.out.println("hit");
					}
					
					if(Y >= 400) {
						bulletCheck.stop();
						enemySpawnTimer.stop();
						gameTimer.stop();
						enemyTimer.stop();
						System.out.println("you lose");
					}
					
				}
				if(score >= 1000) {
					bulletCheck.stop();
					enemySpawnTimer.stop();
					gameTimer.stop();
					enemyTimer.stop();
					System.out.println("you win");
				}
			}
		});
		bulletCheck.start();
		
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
		// here is the action performed for the bullet shot
		if (bulletMove && bulletActive){
  			bulletY -= 15;
  			if (bulletY <= -50){
  				bulletMove = false;
  				bulletActive = false;
  			}
  		}
		
		/*for(int i = 0; i < enemies.size(); i++) {
			if(bulletY == (enemies.get(i)).getY()  ) {
				System.out.println("hi");
				enemies.remove(i);
			}
		} */
		
		// TODO: Check if any enemy has reached the bottom of the screen. If so,
		// the game has been lost.
		
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
				if(bulletActive == false){
	  				bulletX = (ship.getPos()) + 73;
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
