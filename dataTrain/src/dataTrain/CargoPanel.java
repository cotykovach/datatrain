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

public class CargoPanel extends JPanel {

	public static JTextArea searchCargoOrigin, searchCargoDestination,
			searchCargoID, searchGreaterThanWeightCargo,
			searchLessThanWeightCargo, searchCargoSender,
			searchLessThanPriceCargo, searchGreaterThanPriceCargo;
	public static JButton cargoDataSearchButton = new JButton();
	public static JComboBox searchCargoOrderByBox;
	
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static CargoPanel cargoPanelBuilder() throws IOException {
		CargoPanel cargoDataPanel = new CargoPanel();
		SearchPanel.setUpSearchPanel(cargoDataPanel);

		String[] searchCargoOrderBy = {"ID", "ORIGIN",
				"DESTINATION", "WEIGHT", "PRICE", "SENDER" };

		searchCargoOrderByBox = new JComboBox(searchCargoOrderBy);
		searchCargoOrderByBox.setFont(searchLabelFont);
		searchCargoOrderByBox.setBounds(1120, 25, 200, 25);
		cargoDataPanel.add(searchCargoOrderByBox);

		cargoDataSearchButton = new JButton();
		cargoDataSearchButton.setName("searchButton");
		cargoDataSearchButton.setBounds(1120, 70, 200, 45);
		cargoDataSearchButton = ButtonBuilder.buttonBuilder(
				cargoDataSearchButton, cargoDataSearchButton.getName(),
				cargoDataSearchButton.getHeight(),
				cargoDataSearchButton.getWidth());
		cargoDataPanel.add(cargoDataSearchButton);

		JLabel searchWeightCargo = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchWeightCargo, 170,
				70, 150, 35, "< Cargo Weight <"));

		searchGreaterThanWeightCargo = new JTextArea();
		JScrollPane searchGreaterThanWeightCargoPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchGreaterThanWeightCargo));
		searchGreaterThanWeightCargoPanel.setBounds(15, 75, 150, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchGreaterThanWeightCargoPanel));

		searchLessThanWeightCargo = new JTextArea();
		JScrollPane searchLessThanWeightCargoPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchLessThanWeightCargo));
		searchLessThanWeightCargoPanel.setBounds(320, 75, 150, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchLessThanWeightCargoPanel));

		JLabel searchPriceCargo = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchPriceCargo, 650,
				70, 150, 35, "< Cargo Price <"));

		searchGreaterThanPriceCargo = new JTextArea();
		JScrollPane searchLessThanPriceCargoPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchGreaterThanPriceCargo));
		searchLessThanPriceCargoPanel.setBounds(495, 75, 150, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchLessThanPriceCargoPanel));

		searchLessThanPriceCargo = new JTextArea();
		JScrollPane searchGreaterThanPriceCargoPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchLessThanPriceCargo));
		searchGreaterThanPriceCargoPanel.setBounds(785, 75, 150, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchGreaterThanPriceCargoPanel));

		JLabel searchSenderCargo = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchSenderCargo, 735,
				0, 200, 35, "Sender:"));

		searchCargoSender = new JTextArea();
		JScrollPane searchCargoSenderPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCargoSender));
		searchCargoSenderPanel.setBounds(735, 25, 200, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchCargoSenderPanel));

		JLabel searchCargoIDLabel = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchCargoIDLabel, 15,
				0, 200, 35, "CargoID:"));

		searchCargoID = new JTextArea();
		JScrollPane searchCargoIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCargoID));
		searchCargoIDPanel.setBounds(15, 25, 200, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchCargoIDPanel));

		JLabel searchOriginLabel = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchOriginLabel, 255,
				0, 200, 35, "Origin:"));

		searchCargoOrigin = new JTextArea();
		JScrollPane searchOriginPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCargoOrigin));
		searchOriginPanel.setBounds(255, 25, 200, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchOriginPanel));

		JLabel searchDestinationLabel = new JLabel();
		cargoDataPanel.add(JLabelBuilder.createJLabel(searchDestinationLabel,
				495, 0, 200, 35, "Destination:"));

		searchCargoDestination = new JTextArea();
		JScrollPane searchDestinationPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCargoDestination));
		searchDestinationPanel.setBounds(495, 25, 200, 25);
		cargoDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchDestinationPanel));

		return cargoDataPanel;
	}
}
