package dataTrain;

import java.awt.Font;

import javax.swing.JTextArea;

public class TextAreaBuilder {

	private static Font dataFont = new Font("Verdana", Font.PLAIN, 12);

	public static JTextArea textAreaBuilder(JTextArea incomingTextArea) {
		incomingTextArea.setWrapStyleWord(true);
		incomingTextArea.setFont(dataFont);
		incomingTextArea.setLineWrap(false);
		incomingTextArea.setWrapStyleWord(true);
		incomingTextArea.setVerifyInputWhenFocusTarget(true);
		return incomingTextArea;
	}
}
