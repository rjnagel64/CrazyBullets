
import java.awt.EventQueue;
import javax.swing.JFrame;

public class CrazyBullets extends JFrame {

	public static final int SCREEN_WIDTH = 640;
	public static final int SCREEN_HEIGHT = 480;

	public CrazyBullets() {
		add(new Game());
		
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
