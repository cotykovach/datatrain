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

public class TicketPanel extends JPanel {

	public static JTextArea searchTicketID, searchTicketOrigin,
			searchTicketDestination, searchTicketCustomerID,
			searchTicketDatePurchased, searchGreaterThanPriceTicket,
			searchLessThanPriceTicket;
	public static JButton ticketDataSearchButton = new JButton();
	public static JComboBox searchTicketOrderByBox;
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static TicketPanel ticketPanelBuilder() throws IOException {
		TicketPanel ticketDataPanel = new TicketPanel();
		SearchPanel.setUpSearchPanel(ticketDataPanel);

		String[] searchTicketOrderBy = { "ID", "ORIGIN", "DESTINATION", "PRICE" };

		searchTicketOrderByBox = new JComboBox(searchTicketOrderBy);
		searchTicketOrderByBox.setFont(searchLabelFont);
		searchTicketOrderByBox.setBounds(1120, 25, 200, 25);
		ticketDataPanel.add(searchTicketOrderByBox);

		ticketDataSearchButton = new JButton();
		ticketDataSearchButton.setName("searchButton");
		ticketDataSearchButton.setBounds(1120, 70, 200, 45);
		ticketDataSearchButton = ButtonBuilder.buttonBuilder(
				ticketDataSearchButton, ticketDataSearchButton.getName(),
				ticketDataSearchButton.getHeight(),
				ticketDataSearchButton.getWidth());
		ticketDataPanel.add(ticketDataSearchButton);

		JLabel searchTicketIDLabel = new JLabel();
		ticketDataPanel.add(JLabelBuilder.createJLabel(searchTicketIDLabel, 15,
				0, 200, 35, "TicketID:"));

		searchTicketID = new JTextArea();
		JScrollPane searchTicketIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTicketID));
		searchTicketIDPanel.setBounds(15, 25, 200, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchTicketIDPanel));

		JLabel searchTicketOriginLabel = new JLabel();
		ticketDataPanel.add(JLabelBuilder.createJLabel(searchTicketOriginLabel,
				255, 0, 200, 35, "Origin:"));

		searchTicketOrigin = new JTextArea();
		JScrollPane searchTicketOriginPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTicketOrigin));
		searchTicketOriginPanel.setBounds(255, 25, 200, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchTicketOriginPanel));

		JLabel searchTicketDestinationLabel = new JLabel();
		ticketDataPanel.add(JLabelBuilder.createJLabel(
				searchTicketDestinationLabel, 495, 0, 200, 35, "Destination:"));

		searchTicketDestination = new JTextArea();
		JScrollPane searchTicketDestinationPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTicketDestination));
		searchTicketDestinationPanel.setBounds(495, 25, 200, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchTicketDestinationPanel));

		JLabel searchTicketCustomerIDLabel = new JLabel();
		ticketDataPanel.add(JLabelBuilder.createJLabel(
				searchTicketCustomerIDLabel, 735, 0, 200, 35, "CustomerID:"));

		searchTicketCustomerID = new JTextArea();
		JScrollPane searchTicketCustomerIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchTicketCustomerID));
		searchTicketCustomerIDPanel.setBounds(735, 25, 200, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchTicketCustomerIDPanel));

		JLabel searchPriceTicket = new JLabel();
		ticketDataPanel.add(JLabelBuilder.createJLabel(searchPriceTicket, 320,
				70, 150, 35, "< Ticket Price <"));

		searchGreaterThanPriceTicket = new JTextArea();
		JScrollPane searchGreaterThanPriceTicketPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchGreaterThanPriceTicket));
		searchGreaterThanPriceTicketPanel.setBounds(165, 75, 150, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchGreaterThanPriceTicketPanel));

		searchLessThanPriceTicket = new JTextArea();
		JScrollPane searchLessThanPriceTicketPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchLessThanPriceTicket));
		searchLessThanPriceTicketPanel.setBounds(455, 75, 150, 25);
		ticketDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchLessThanPriceTicketPanel));

		return ticketDataPanel;
	}
}
