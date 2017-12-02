
import java.awt.EventQueue;

import javax.swing.JFrame;

public class CrazyBullets extends JFrame {

	public static int SCREEN_WIDTH = 640;
	public static int SCREEN_HEIGHT = 480;

	private Ship ship;

	public CrazyBullets() {
		ship = new Ship();
		add(ship);

		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setTitle("CrazyBullets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			CrazyBullets cb = new CrazyBullets();
			cb.setVisible(true);
		});
	}

}
