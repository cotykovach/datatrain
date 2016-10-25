package dataTrain;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GUI {

	private JFrame frame;
	private static LogInPanel currentPanel;
	private static HomePanel homePanel;
	private static LogInPanel logInPanel;
	private static GUI window = new GUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setTitle("dataTrain");
					currentPanel = new LogInPanel();
					window.frame.setVisible(true);
					window.frame.setContentPane(currentPanel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 50, 865, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

	static void signIn() {
		try {
			homePanel = new HomePanel();
			window.frame.setContentPane(homePanel);
			window.frame.repaint();
			window.frame.setVisible(true);
			window.frame.setBounds(0, 20, 1366, 790);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void signOut() {
		try {
			logInPanel = new LogInPanel();
			window.frame.setContentPane(logInPanel);
			window.frame.repaint();
			window.frame.setVisible(true);
			window.frame.setBounds(555, 180, 865, 700);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
