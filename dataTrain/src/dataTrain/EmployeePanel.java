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



public class EmployeePanel extends JPanel {

	public static JTextArea searchEmployeeSSN, searchEmployeeFName,
			searchEmployeeLName, searchLessThanEmployeeSalary,
			searchGreaterThanEmployeeSalary;
	public static JButton employeeDataSearchButton = new JButton();
	public static JComboBox searchEmployeeOrderByBox;
	
	private static Font searchLabelFont = new Font("Verdana", Font.BOLD, 14);

	public static EmployeePanel employeePanelBuilder() throws IOException {
		EmployeePanel employeeDataPanel = new EmployeePanel();
		SearchPanel.setUpSearchPanel(employeeDataPanel);

		String[] searchEmployeeOrderBy = { "SSN",
				"FNAME", "LNAME", "SALARY" };

		searchEmployeeOrderByBox = new JComboBox(
				searchEmployeeOrderBy);
		searchEmployeeOrderByBox.setFont(searchLabelFont);
		searchEmployeeOrderByBox.setBounds(1120, 25, 200, 25);
		employeeDataPanel.add(searchEmployeeOrderByBox);

		employeeDataSearchButton = new JButton();
		employeeDataSearchButton.setName("searchButton");
		employeeDataSearchButton.setBounds(1120, 70, 200, 45);
		employeeDataSearchButton = ButtonBuilder.buttonBuilder(
				employeeDataSearchButton, employeeDataSearchButton.getName(),
				employeeDataSearchButton.getHeight(),
				employeeDataSearchButton.getWidth());
		employeeDataPanel.add(employeeDataSearchButton);

		JLabel searchEmployeeSSNLabel = new JLabel();
		employeeDataPanel.add(JLabelBuilder.createJLabel(searchEmployeeSSNLabel, 15, 0, 200, 35,
				"Employee SSN:"));

		searchEmployeeSSN = new JTextArea();
		JScrollPane searchEmployeeSSNPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchEmployeeSSN));
		searchEmployeeSSNPanel.setBounds(15, 25, 200, 25);
		employeeDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchEmployeeSSNPanel));

		JLabel searchEmployeeFNameLabel = new JLabel();
		employeeDataPanel.add(JLabelBuilder.createJLabel(searchEmployeeFNameLabel, 255, 0, 200,
				35, "First Name:"));

		searchEmployeeFName = new JTextArea();
		JScrollPane searchEmployeeFNamePanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchEmployeeFName));
		searchEmployeeFNamePanel.setBounds(255, 25, 200, 25);
		employeeDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchEmployeeFNamePanel));

		JLabel searchEmployeeLNameLabel = new JLabel();
		employeeDataPanel.add(JLabelBuilder.createJLabel(searchEmployeeLNameLabel, 495, 0, 200,
				35, "Last Name:"));

		searchEmployeeLName = new JTextArea();
		JScrollPane searchEmployeeLNamePanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchEmployeeLName));
		searchEmployeeLNamePanel.setBounds(495, 25, 200, 25);
		employeeDataPanel.add(ScrollPaneBuilder.ScrollPaneBuilder(searchEmployeeLNamePanel));

		JLabel searchEmployeeSalary = new JLabel();
		employeeDataPanel.add(JLabelBuilder.createJLabel(searchEmployeeSalary, 320, 70, 150, 35,
				"< Salary <"));

		searchGreaterThanEmployeeSalary = new JTextArea();
		JScrollPane searchGreaterThanEmployeeSalaryPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchGreaterThanEmployeeSalary));
		searchGreaterThanEmployeeSalaryPanel.setBounds(165, 75, 150, 25);
		employeeDataPanel
				.add(ScrollPaneBuilder.ScrollPaneBuilder(searchGreaterThanEmployeeSalaryPanel));

		searchLessThanEmployeeSalary = new JTextArea();
		JScrollPane searchLessThanEmployeeSalaryPanel = new JScrollPane(
				TextAreaBuilder.textAreaBuilder(searchLessThanEmployeeSalary));
		searchLessThanEmployeeSalaryPanel.setBounds(410, 75, 150, 25);
		employeeDataPanel
				.add(ScrollPaneBuilder.ScrollPaneBuilder(searchLessThanEmployeeSalaryPanel));

		return employeeDataPanel;
	}
}
