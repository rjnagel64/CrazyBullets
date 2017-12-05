import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	private Ship ship;
	
	private Timer timer;
	
	public Game() {
		ship = new Ship();
		timer = new Timer(32, this);
		
		setFocusable(true);
		
		addKeyListener(new KeypressHandler());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ship.paintComponent(g);
	}
	
	private class KeypressHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// Ignore this
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT) {
				System.out.println("Handling keyleft");
				ship.shift(-32);
				System.out.println("New pos: " + ship.getPos());
			} else if (key == KeyEvent.VK_RIGHT) {
				System.out.println("Handling keyright");
				ship.shift(32);
				System.out.println("New pos: " + ship.getPos());
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Ignore this?
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
