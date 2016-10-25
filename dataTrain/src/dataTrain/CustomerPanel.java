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

public class CustomerPanel extends JPanel {

	public static JTextArea searchCustomerID, searchCustomerFName,
			searchCustomerLName;
	public static JButton customerDataSearchButton = new JButton();
	public static JComboBox searchCustomerOrderByBox;
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static CustomerPanel customerPanelBuilder() throws IOException {
		CustomerPanel customerDataPanel = new CustomerPanel();
		SearchPanel.setUpSearchPanel(customerDataPanel);

		String[] searchCustomerOrderBy = { "ID",
				"FNAME", "LNAME"};

		searchCustomerOrderByBox = new JComboBox(
				searchCustomerOrderBy);
		searchCustomerOrderByBox.setFont(searchLabelFont);
		searchCustomerOrderByBox.setBounds(1120, 25, 200, 25);
		customerDataPanel.add(searchCustomerOrderByBox);

		customerDataSearchButton = new JButton();
		customerDataSearchButton.setName("searchButton");
		customerDataSearchButton.setBounds(1120, 70, 200, 45);
		customerDataSearchButton = ButtonBuilder.buttonBuilder(
				customerDataSearchButton, customerDataSearchButton.getName(),
				customerDataSearchButton.getHeight(),
				customerDataSearchButton.getWidth());
		customerDataPanel.add(customerDataSearchButton);

		JLabel searchCustomerIDLabel = new JLabel();
		customerDataPanel.add(JLabelBuilder.createJLabel(searchCustomerIDLabel,
				15, 0, 200, 35, "CustomerID:"));

		searchCustomerID = new JTextArea();
		JScrollPane searchCustomerIDPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCustomerID));
		searchCustomerIDPanel.setBounds(15, 25, 200, 25);
		customerDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchCustomerIDPanel));

		JLabel searchCustomerFNameLabel = new JLabel();
		customerDataPanel.add(JLabelBuilder.createJLabel(
				searchCustomerFNameLabel, 255, 0, 200, 35, "First Name:"));

		searchCustomerFName = new JTextArea();
		JScrollPane searchCustomerFNamePanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCustomerFName));
		searchCustomerFNamePanel.setBounds(255, 25, 200, 25);
		customerDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchCustomerFNamePanel));

		JLabel searchCustomerLNameLabel = new JLabel();
		customerDataPanel.add(JLabelBuilder.createJLabel(
				searchCustomerLNameLabel, 495, 0, 200, 35, "Last Name:"));

		searchCustomerLName = new JTextArea();
		JScrollPane searchCustomerLNamePanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchCustomerLName));
		searchCustomerLNamePanel.setBounds(495, 25, 200, 25);
		customerDataPanel.add(ScrollPaneBuilder
				.ScrollPaneBuilder(searchCustomerLNamePanel));

		return customerDataPanel;
	}
}
