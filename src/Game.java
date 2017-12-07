import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	private static final int MS_PER_FRAME = 32;
	private static final int MOVE_AMOUNT = 32;
	private int intBulletX = -32;
	private int intBulletY = -32;
	boolean bulletMove = false;
	boolean bulletActive = false;
	
	private Timer timer;

	private Ship ship;
	private List<Enemy> enemies;
	
	public Game() {
		ship = new Ship();
		enemies = new ArrayList<Enemy>();
		// TODO: Spawn enemies

		timer = new Timer(MS_PER_FRAME, this);
		timer.start();

		setFocusable(true);
		addKeyListener(new KeypressHandler());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// here is the action performed for the bullet shot
		if(bulletMove && bulletActive){
  			intBulletY -= 15;
  			if(intBulletY <= -50){
  				bulletMove = false;
  				bulletActive = false;
  			}
  		}
		repaint();
		
		// Each enemy should be updated here.
		// Enemies must not move every frame -- that's much too fast.
		// One option would be to keep track of the time since last update here,
		// and update all enemies together. However, since enemies move in
		// different ways (and might appear at different times), it might make
		// more sense for each enemy to store the time when it was last updated.
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.red);
		g.fillOval(intBulletX, intBulletY, 10, 25);

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
	  				intBulletX = (ship.getPos()) + 73;
	  				intBulletY = ship.getPosY();
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
