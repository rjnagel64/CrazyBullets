
import java.awt.EventQueue;

import javax.swing.JFrame;

public class CrazyBullets extends JFrame {
	
	public CrazyBullets() {
		setSize(640, 480);
		setTitle("CrazyBullets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CrazyBullets cb = new CrazyBullets();
				cb.setVisible(true);
			}
		});
	}

}
