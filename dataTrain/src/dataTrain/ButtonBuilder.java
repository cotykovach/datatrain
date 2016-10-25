package dataTrain;

import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonBuilder {
	
	public static JButton buttonBuilder(final JButton button, String buttonName,
			int buttonHeight, int buttonWidth) throws IOException {
		BufferedImage buttonBufferedImage = ImageIO.read(new File(
				"images\\buttons\\" + buttonName + ".png"));
		Image buttonImage = buttonBufferedImage.getScaledInstance(buttonWidth,
				buttonHeight, Image.SCALE_SMOOTH);
		BufferedImage buttonHighlightBufferedImage = ImageIO.read(new File(
				"images\\buttons\\" + buttonName + "_highlight.png"));
		final Image buttonHighlightImage = buttonHighlightBufferedImage
				.getScaledInstance(buttonWidth, buttonHeight,
						Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(buttonImage));
		button.setRolloverIcon(new ImageIcon(buttonHighlightImage));
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(buttonImage));
		return button;
	}
	
}
