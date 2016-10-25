package dataTrain;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelBuilder {

	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static Component createJLabel(JLabel newJLabel, int x, int y,
			int width, int height, String text) {
		newJLabel.setFont(searchLabelFont);
		newJLabel.setText(text);
		newJLabel.setBounds(x, y, width, height);
		return newJLabel;
	}
}
