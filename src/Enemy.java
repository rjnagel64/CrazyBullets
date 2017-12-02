import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Enemy extends JPanel {
	private int x;
	private int y;
	
	private MovementPattern pattern;
	private Image image;
	
	public Enemy() {
		;
	}
	
	public void setMovementPattern(MovementPattern pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
		// Draw the image here.
	}

}
