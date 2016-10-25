package dataTrain;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ScrollPaneBuilder {
	
	public static JScrollPane ScrollPaneBuilder(JScrollPane incomingScrollPanel) {
		incomingScrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		incomingScrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		return incomingScrollPanel;
	}
	
}
