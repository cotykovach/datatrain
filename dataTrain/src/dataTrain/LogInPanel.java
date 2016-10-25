package dataTrain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.sql.SQLException;
import dataTrain.GUI;
import dataTrain.DataBase;

public class LogInPanel extends JPanel {

	private static File fileSource = new File("images\\dataTrain_mainPage.png");
	private static BufferedImage mainImage;
	private static JPasswordField passwordField;
	private static JTextField incorrectPassword = new JTextField();
	private static JTextArea userName;
	private static Font f = new Font("Verdana", Font.PLAIN, 26);

	public LogInPanel() throws IOException {
		setUpPanel();
	}

	private void setUpPanel() throws IOException {
		setBackground(Color.WHITE);
		setLayout(null);
		
		mainImage = ImageIO.read(fileSource);
		ImageIcon mainImageBackground = new ImageIcon(mainImage);
		JLabel background = new JLabel(mainImageBackground);
		background.setBounds(0, 0, 864, 648);
		
		userName = new JTextArea();
		userName.setText("username@dataTrain.com");
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar((char) 0);
		passwordField.setFont(f);
		passwordField.setText("password");
		userName.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "none");
		userName.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");
		
		JScrollPane userNamePanel = new JScrollPane(textAreaBuilder(userName));
		JScrollPane passWordPanel = new JScrollPane(passwordField);
		scrollPaneBuilder(userNamePanel);
		scrollPaneBuilder(passWordPanel);
		userNamePanel.setBounds(225, 225, 400, 48);
		passWordPanel.setBounds(225, 335, 400, 48);
		passWordPanel.getInputMap().put(KeyStroke.getKeyStroke("TAB"),
				"pressed");
		
		JButton signInButton = new JButton();
		signInButton.setName("signInButton");
		signInButton.setBounds(315, 455, 213, 59);
		buttonBuilder(signInButton, signInButton.getName());

		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
				passwordField.setEchoChar('*');
				passwordField.removeFocusListener(this);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// doNothing
			}
		});

		incorrectPassword.setBounds(260, 400, 325, 29);
		incorrectPassword.setForeground(new Color(255, 0, 0));
		incorrectPassword
				.setText("Your username or password is incorrect. Please try again.");
		incorrectPassword.setEditable(false);
		incorrectPassword.setVisible(false);
		add(incorrectPassword);
		add(background);
	}

	private JTextArea textAreaBuilder(JTextArea incomingTextArea) {
		incomingTextArea.setWrapStyleWord(true);
		incomingTextArea.setFont(f);
		incomingTextArea.setLineWrap(false);
		incomingTextArea.setWrapStyleWord(true);
		incomingTextArea.setVerifyInputWhenFocusTarget(true);
		return incomingTextArea;
	}

	private void scrollPaneBuilder(JScrollPane incomingScrollPanel) {
		incomingScrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		incomingScrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(incomingScrollPanel);
	}

	private void buttonBuilder(final JButton button, String buttonName)
			throws IOException {
		BufferedImage buttonBufferedImage = ImageIO.read(new File(
				"images\\buttons\\" + buttonName + ".png"));
		Image buttonImage = buttonBufferedImage.getScaledInstance(213, 59,
				Image.SCALE_SMOOTH);
		BufferedImage buttonHighlightBufferedImage = ImageIO.read(new File(
				"images\\buttons\\" + buttonName + "_highlight.png"));
		final Image buttonHighlightImage = buttonHighlightBufferedImage
				.getScaledInstance(213, 59, Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(buttonImage));
		button.setRolloverIcon(new ImageIcon(buttonHighlightImage));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (DataBase.logInVerification(userName.getText(),
							passwordField.getText())) {
						System.out.println("Password is correct");

						button.setIcon(new ImageIcon(buttonHighlightImage));
						GUI.signIn();
					} else {
						incorrectPassword.setVisible(true);
						System.out.println("Password is incorrect");

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(buttonImage));
		add(button);
	}
}
