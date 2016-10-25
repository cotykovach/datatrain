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



public class TrainPanel extends JPanel {

	public static JTextArea searchTrainID, searchTrainOrigin,
			searchTrainDestination, searchGreaterThanCargoOnTrain,
			searchLessThanCargoOnTrain;
	public static JButton trainDataSearchButton = new JButton();
	public static JComboBox searchTrainOrderByBox;
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static TrainPanel trainPanelBuilder() throws IOException {
		TrainPanel trainDataPanel = new TrainPanel();
		SearchPanel.setUpSearchPanel(trainDataPanel);

		String[] searchTrainOrderBy = { "ID", "ORIGIN",
				"DESTINATION" };

		searchTrainOrderByBox = new JComboBox(searchTrainOrderBy);
		searchTrainOrderByBox.setFont(searchLabelFont);
		searchTrainOrderByBox.setBounds(1120, 25, 200, 25);
		trainDataPanel.add(searchTrainOrderByBox);

		trainDataSearchButton = new JButton();
		trainDataSearchButton.setName("searchButton");
		trainDataSearchButton.setBounds(1120, 70, 200, 45);
		trainDataSearchButton = ButtonBuilder.buttonBuilder(
				trainDataSearchButton, trainDataSearchButton.getName(),
				trainDataSearchButton.getHeight(),
				trainDataSearchButton.getWidth());
		trainDataPanel.add(trainDataSearchButton);

		JLabel searchTrainIDLabel = new JLabel();
		trainDataPanel.add(JLabelBuilder.createJLabel(searchTrainIDLabel, 15,
				0, 200, 35, "TrainID:"));

		searchTrainID = new JTextArea();
		JScrollPane searchTrainIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTrainID));
		searchTrainIDPanel.setBounds(15, 25, 200, 25);
		trainDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchTrainIDPanel));

		JLabel searchTrainOriginLabel = new JLabel();
		trainDataPanel.add(JLabelBuilder.createJLabel(searchTrainOriginLabel, 255, 0, 200, 35,
				"Origin:"));

		searchTrainOrigin = new JTextArea();
		JScrollPane searchTrainOriginPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTrainOrigin));
		searchTrainOriginPanel.setBounds(255, 25, 200, 25);
		trainDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchTrainOriginPanel));

		JLabel searchTrainDestinationLabel = new JLabel();
		trainDataPanel.add(JLabelBuilder.createJLabel(searchTrainDestinationLabel, 495, 0, 200,
				35, "Destination:"));

		searchTrainDestination = new JTextArea();
		JScrollPane searchTrainDestinationPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTrainDestination));
		searchTrainDestinationPanel.setBounds(495, 25, 200, 25);
		trainDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchTrainDestinationPanel));

		return trainDataPanel;
	}
}
