package dataTrain;

import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import dataTrain.SearchPanel;
import dataTrain.ScrollPaneBuilder;
import dataTrain.TextAreaBuilder;
import dataTrain.JLabelBuilder;

;

public class StationPanel extends JPanel {

	public static JTextArea searchStationID, searchStationName,
			searchStationAddress;
	public static JButton stationDataSearchButton = new JButton();
	public static JComboBox searchStationOrderByBox;
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static StationPanel stationPanelBuilder() throws IOException {
		StationPanel stationDataPanel = new StationPanel();
		SearchPanel.setUpSearchPanel(stationDataPanel);

		String[] searchStationOrderBy = { "ID",
				"NAME", "ADDRESS" };

		searchStationOrderByBox = new JComboBox(searchStationOrderBy);
		searchStationOrderByBox.setFont(searchLabelFont);
		searchStationOrderByBox.setBounds(1120, 25, 200, 25);
		stationDataPanel.add(searchStationOrderByBox);

		stationDataSearchButton = new JButton();
		stationDataSearchButton.setName("searchButton");
		stationDataSearchButton.setBounds(1120, 70, 200, 45);
		stationDataSearchButton = ButtonBuilder.buttonBuilder(
				stationDataSearchButton, stationDataSearchButton.getName(),
				stationDataSearchButton.getHeight(),
				stationDataSearchButton.getWidth());
		stationDataPanel.add(stationDataSearchButton);

		JLabel searchStationIDLabel = new JLabel();
		stationDataPanel.add(JLabelBuilder.createJLabel(searchStationIDLabel,
				15, 0, 200, 35, "StationID:"));

		searchStationID = new JTextArea();
		JScrollPane searchStationIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchStationID));
		searchStationIDPanel.setBounds(15, 25, 200, 25);
		stationDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchStationIDPanel));

		JLabel searchStationNameLabel = new JLabel();
		stationDataPanel.add(JLabelBuilder.createJLabel(searchStationNameLabel,
				255, 0, 200, 35, "StationName:"));

		searchStationName = new JTextArea();
		JScrollPane searchStationNamePanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchStationName));
		searchStationNamePanel.setBounds(255, 25, 200, 25);
		stationDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchStationNamePanel));

		JLabel searchStationAddressLabel = new JLabel();
		stationDataPanel.add(JLabelBuilder.createJLabel(
				searchStationAddressLabel, 495, 0, 200, 35, "StationAddress:"));

		searchStationAddress = new JTextArea();
		JScrollPane searchStationAddressPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchStationAddress));
		searchStationAddressPanel.setBounds(495, 25, 200, 25);
		stationDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchStationAddressPanel));

		return stationDataPanel;
	}
}
