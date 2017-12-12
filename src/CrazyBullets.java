
import java.awt.EventQueue;
import javax.swing.JFrame;

public class CrazyBullets extends JFrame {
	
	// the link to the presentation
	// https://prezi.com/view/DWOLM9oHAUqSu9LeiFLJ/

	public static final int SCREEN_WIDTH = 640;
	public static final int SCREEN_HEIGHT = 480;

	public CrazyBullets() {
		add(new Game());
		
		// Does this include the header at the top of the screen?
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
