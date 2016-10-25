package dataTrain;

import java.awt.Color;

import javax.swing.JPanel;

public class SearchPanel {

	public static JPanel setUpSearchPanel(JPanel incomingSearchPanel) {
		incomingSearchPanel.setBounds(0, 0, 1330, 768);
		incomingSearchPanel.setLayout(null);
		incomingSearchPanel.setBackground(Color.WHITE);
		return incomingSearchPanel;
	}

}
