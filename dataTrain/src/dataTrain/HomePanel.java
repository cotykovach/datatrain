package dataTrain;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import dataTrain.GUI;
import dataTrain.DataBase;
import dataTrain.ButtonBuilder;

public class HomePanel extends JPanel {

	private static File fileSource = new File(
			"images\\dataTrain_backGround.png");
	private static File fileSourceLoaded = new File(
			"images\\dataTrain_loadPicture.png");
	private static BufferedImage mainImage, trainImage;
	private static Font f = new Font("Verdana", Font.PLAIN, 26);
	private static Font dataFont = new Font("Verdana", Font.PLAIN, 12);
	private static JButton selectedTab;
	protected Component currentTrainData, currentCargoData, currentTicketData,
			currentStationData, currentEmployeeData, currentCustomerData;

	CargoPanel cargoDataPanel = new CargoPanel();
	TrainPanel trainDataPanel = new TrainPanel();
	TicketPanel ticketDataPanel = new TicketPanel();
	StationPanel stationDataPanel = new StationPanel();
	EmployeePanel employeeDataPanel = new EmployeePanel();
	CustomerPanel customerDataPanel = new CustomerPanel();

	public HomePanel() throws IOException {
		setUpPanel();
	}

	private void setUpPanel() throws IOException {
		setBackground(Color.WHITE);
		setLayout(null);
		mainImage = ImageIO.read(fileSource);
		trainImage = ImageIO.read(fileSourceLoaded);
		ImageIcon mainImageBackground = new ImageIcon(mainImage);
		ImageIcon subImageBackground = new ImageIcon(trainImage);
		JLabel background = new JLabel(mainImageBackground);
		JLabel backgroundLoad = new JLabel(subImageBackground);
		backgroundLoad.setBounds(0, 0, 1330, 650);
		background.setBounds(0, 0, 1377, 768);

		JButton trainDataButton = new JButton();
		trainDataButton.setName("trainDataButton");
		trainDataButton.setBounds(7, 85, 197, 52);

		JButton cargoDataButton = new JButton();
		cargoDataButton.setName("cargoDataButton");
		cargoDataButton.setBounds(205, 85, 197, 52);

		JButton ticketDataButton = new JButton();
		ticketDataButton.setName("ticketDataButton");
		ticketDataButton.setBounds(403, 85, 197, 52);

		JButton stationDataButton = new JButton();
		stationDataButton.setName("stationDataButton");
		stationDataButton.setBounds(601, 85, 197, 52);

		JButton employeeDataButton = new JButton();
		employeeDataButton.setName("employeeDataButton");
		employeeDataButton.setBounds(799, 85, 197, 52);

		JButton customerDataButton = new JButton();
		customerDataButton.setName("customerDataButton");
		customerDataButton.setBounds(997, 85, 197, 52);

		JButton signOutButton = new JButton();
		signOutButton.setName("signOutButton");
		signOutButton.setBounds(1195, 87, 73, 49);

		trainDataButton = ButtonBuilder.buttonBuilder(trainDataButton,
				trainDataButton.getName(), trainDataButton.getHeight(),
				trainDataButton.getWidth());
		cargoDataButton = ButtonBuilder.buttonBuilder(cargoDataButton,
				cargoDataButton.getName(), cargoDataButton.getHeight(),
				cargoDataButton.getWidth());
		ticketDataButton = ButtonBuilder.buttonBuilder(ticketDataButton,
				ticketDataButton.getName(), ticketDataButton.getHeight(),
				ticketDataButton.getWidth());
		stationDataButton = ButtonBuilder.buttonBuilder(stationDataButton,
				stationDataButton.getName(), stationDataButton.getHeight(),
				stationDataButton.getWidth());
		employeeDataButton = ButtonBuilder.buttonBuilder(employeeDataButton,
				employeeDataButton.getName(), employeeDataButton.getHeight(),
				employeeDataButton.getWidth());
		customerDataButton = ButtonBuilder.buttonBuilder(customerDataButton,
				customerDataButton.getName(), customerDataButton.getHeight(),
				customerDataButton.getWidth());
		signOutButton = ButtonBuilder.buttonBuilder(signOutButton,
				signOutButton.getName(), signOutButton.getHeight(),
				signOutButton.getWidth());

		final JPanel parentPanel = new JPanel();
		parentPanel.setBounds(10, 139, 1330, 550);
		parentPanel.setLayout(null);
		parentPanel.setBackground(Color.WHITE);
		parentPanel.add(backgroundLoad);
		
		
		cargoDataPanel = CargoPanel.cargoPanelBuilder();
		trainDataPanel = TrainPanel.trainPanelBuilder();
		ticketDataPanel = TicketPanel.ticketPanelBuilder();
		employeeDataPanel = EmployeePanel.employeePanelBuilder();
		stationDataPanel = StationPanel.stationPanelBuilder();
		customerDataPanel = CustomerPanel.customerPanelBuilder();

		SearchPanel.setUpSearchPanel(trainDataPanel);
		SearchPanel.setUpSearchPanel(cargoDataPanel);
		SearchPanel.setUpSearchPanel(ticketDataPanel);
		SearchPanel.setUpSearchPanel(stationDataPanel);
		SearchPanel.setUpSearchPanel(employeeDataPanel);
		SearchPanel.setUpSearchPanel(customerDataPanel);

		addNewActionListenerPanelSwitch(trainDataButton, parentPanel,
				trainDataPanel);
		addNewActionListenerPanelSwitch(cargoDataButton, parentPanel,
				cargoDataPanel);
		addNewActionListenerPanelSwitch(ticketDataButton, parentPanel,
				ticketDataPanel);
		addNewActionListenerPanelSwitch(stationDataButton, parentPanel,
				stationDataPanel);
		addNewActionListenerPanelSwitch(employeeDataButton, parentPanel,
				employeeDataPanel);
		addNewActionListenerPanelSwitch(customerDataButton, parentPanel,
				customerDataPanel);

		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.signOut();
			}
		});

		JPanel searchedTrainDataContainer = new JPanel();
		searchedTrainDataContainer = initializeDataSheets(" ",
				searchedTrainDataContainer);
		JScrollPane trainData = new JScrollPane(searchedTrainDataContainer);
		trainData.setBounds(15, 125, 1310, 425);
		currentTrainData = trainData;
		trainDataPanel.add(trainData);

		JPanel searchedCargoDataContainer = new JPanel();
		searchedCargoDataContainer = initializeDataSheets(" ",
				searchedCargoDataContainer);
		JScrollPane cargoData = new JScrollPane(searchedCargoDataContainer);
		cargoData.setBounds(15, 125, 1310, 425);
		currentCargoData = cargoData;
		cargoDataPanel.add(cargoData);

		JPanel searchedTicketDataContainer = new JPanel();
		searchedTicketDataContainer = initializeDataSheets(" ",
				searchedTicketDataContainer);
		JScrollPane ticketData = new JScrollPane(searchedTicketDataContainer);
		ticketData.setBounds(15, 125, 1310, 425);
		currentTicketData = ticketData;
		ticketDataPanel.add(ticketData);

		JPanel searchedStationDataContainer = new JPanel();
		searchedStationDataContainer = initializeDataSheets(" ",
				searchedStationDataContainer);
		JScrollPane stationData = new JScrollPane(searchedStationDataContainer);
		stationData.setBounds(15, 125, 1310, 425);
		currentStationData = stationData;
		stationDataPanel.add(stationData);

		JPanel searchedEmployeeDataContainer = new JPanel();
		searchedEmployeeDataContainer = initializeDataSheets(" ",
				searchedEmployeeDataContainer);
		JScrollPane employeeData = new JScrollPane(
				searchedEmployeeDataContainer);
		employeeData.setBounds(15, 125, 1310, 425);
		currentEmployeeData = employeeData;
		employeeDataPanel.add(employeeData);

		JPanel searchedCustomerDataContainer = new JPanel();
		searchedCustomerDataContainer = initializeDataSheets(" ",
				searchedCustomerDataContainer);
		JScrollPane customerData = new JScrollPane(
				searchedCustomerDataContainer);
		customerData.setBounds(15, 125, 1310, 425);
		currentCustomerData = customerData;
		customerDataPanel.add(customerData);

		cargoDataPanel.cargoDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(cargoDataPanel.searchCargoOrderByBox
											.getSelectedItem());

							DataBase.SearchCargoByOriginOrDestination(
									cargoDataPanel.searchCargoID.getText(),
									cargoDataPanel.searchCargoOrigin.getText(),
									cargoDataPanel.searchCargoDestination
											.getText(),
									cargoDataPanel.searchCargoSender.getText(),
									cargoDataPanel.searchGreaterThanWeightCargo
											.getText(),
									cargoDataPanel.searchLessThanWeightCargo
											.getText(),
									cargoDataPanel.searchGreaterThanPriceCargo
											.getText(),
									cargoDataPanel.searchLessThanPriceCargo
											.getText(), orderBy);
							cargoDataPanel.remove(currentCargoData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane cargoData = new JScrollPane(
										searchedDataContainer);
								cargoData.setBounds(15, 125, 1310, 425);
								currentCargoData = cargoData;
								cargoDataPanel.add(cargoData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {
								JScrollPane emptyDataSheets = noDataFound(cargoDataPanel);
								currentCargoData = emptyDataSheets;
								cargoDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		trainDataPanel.trainDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(trainDataPanel.searchTrainOrderByBox
											.getSelectedItem());

							DataBase.SearchTrainByOriginOrDestination(
									trainDataPanel.searchTrainID.getText(),
									trainDataPanel.searchTrainOrigin.getText(),
									trainDataPanel.searchTrainDestination
											.getText(), orderBy);
							trainDataPanel.remove(currentTrainData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane trainData = new JScrollPane(
										searchedDataContainer);
								trainData.setBounds(15, 125, 1310, 425);
								currentTrainData = trainData;
								trainDataPanel.add(trainData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {
								JScrollPane emptyDataSheets = noDataFound(trainDataPanel);
								currentTrainData = emptyDataSheets;
								trainDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		ticketDataPanel.ticketDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(ticketDataPanel.searchTicketOrderByBox
											.getSelectedItem());

							DataBase.SearchTicketByOriginOrDestination(
									ticketDataPanel.searchTicketID.getText(),
									ticketDataPanel.searchTicketOrigin
											.getText(),
									ticketDataPanel.searchTicketDestination
											.getText(),
									ticketDataPanel.searchTicketCustomerID
											.getText(),
									ticketDataPanel.searchGreaterThanPriceTicket
											.getText(),
									ticketDataPanel.searchLessThanPriceTicket
											.getText(), orderBy);
							ticketDataPanel.remove(currentTicketData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane trainData = new JScrollPane(
										searchedDataContainer);
								trainData.setBounds(15, 125, 1310, 425);
								currentTicketData = trainData;
								ticketDataPanel.add(trainData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {
								JScrollPane emptyDataSheets = noDataFound(ticketDataPanel);
								currentTicketData = emptyDataSheets;
								ticketDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		employeeDataPanel.employeeDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(employeeDataPanel.searchEmployeeOrderByBox
											.getSelectedItem());

							DataBase.SearchEmployeeByIDFNameLName(
									employeeDataPanel.searchEmployeeSSN
											.getText(),
									employeeDataPanel.searchEmployeeFName
											.getText(),
									employeeDataPanel.searchEmployeeLName
											.getText(),
									employeeDataPanel.searchGreaterThanEmployeeSalary
											.getText(),
									employeeDataPanel.searchLessThanEmployeeSalary
											.getText(), orderBy);
							employeeDataPanel.remove(currentEmployeeData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane employeeData = new JScrollPane(
										searchedDataContainer);
								employeeData.setBounds(15, 125, 1310, 425);
								currentEmployeeData = employeeData;
								employeeDataPanel.add(employeeData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {
								JScrollPane emptyDataSheets = noDataFound(employeeDataPanel);
								currentEmployeeData = emptyDataSheets;
								employeeDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		customerDataPanel.customerDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(customerDataPanel.searchCustomerOrderByBox
											.getSelectedItem());

							DataBase.SearchCustomerByIDFNameLName(
									customerDataPanel.searchCustomerID
											.getText(),
									customerDataPanel.searchCustomerFName
											.getText(),
									customerDataPanel.searchCustomerLName
											.getText(), orderBy);
							customerDataPanel.remove(currentCustomerData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane customerData = new JScrollPane(
										searchedDataContainer);
								customerData.setBounds(15, 125, 1310, 425);
								currentCustomerData = customerData;
								customerDataPanel.add(customerData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {
								JScrollPane emptyDataSheets = noDataFound(customerDataPanel);
								currentCustomerData = emptyDataSheets;
								customerDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		stationDataPanel.stationDataSearchButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// selectedTab = insertButton;
						try {
							String orderBy = String
									.valueOf(stationDataPanel.searchStationOrderByBox
											.getSelectedItem());

							DataBase.SearchStationByIDNameAddress(
									stationDataPanel.searchStationID.getText(),
									stationDataPanel.searchStationName
											.getText(),
									stationDataPanel.searchStationAddress
											.getText(), orderBy);

							stationDataPanel.remove(currentStationData);

							if (DataBase.returnArray().size() != DataBase
									.returnColumnCount()) {

								int rowCount = DataBase.returnRowCount() + 1;
								int columnCount = DataBase.returnColumnCount();

								JPanel searchedDataContainer = new JPanel();
								searchedDataContainer = refreshData(
										DataBase.returnArray(),
										searchedDataContainer, rowCount,
										columnCount);
								JScrollPane stationData = new JScrollPane(
										searchedDataContainer);
								stationData.setBounds(15, 125, 1310, 425);
								currentStationData = stationData;
								stationDataPanel.add(stationData);
								parentPanel.repaint();
								parentPanel.validate();
							} else {

								JScrollPane emptyDataSheets = (noDataFound(stationDataPanel));
								currentStationData = emptyDataSheets;
								stationDataPanel.add(emptyDataSheets);
								parentPanel.repaint();
								parentPanel.validate();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		add(trainDataButton);
		add(cargoDataButton);
		add(ticketDataButton);
		add(stationDataButton);
		add(employeeDataButton);
		add(customerDataButton);
		add(signOutButton);
		parentPanel.add(trainDataPanel);
		parentPanel.add(cargoDataPanel);
		parentPanel.add(ticketDataPanel);
		parentPanel.add(stationDataPanel);
		parentPanel.add(employeeDataPanel);
		parentPanel.add(customerDataPanel);
		trainDataPanel.setVisible(false);
		cargoDataPanel.setVisible(false);
		ticketDataPanel.setVisible(false);
		stationDataPanel.setVisible(false);
		employeeDataPanel.setVisible(false);
		customerDataPanel.setVisible(false);
		add(parentPanel);
		add(background);
	}

	private JScrollPane noDataFound(JPanel incomingNoDataFoundPanel) {
		JPanel emptySearchDataSheets = new JPanel();
		emptySearchDataSheets = initializeDataSheets("noDataFound",
				emptySearchDataSheets);
		JScrollPane emptyDataSheets = new JScrollPane(emptySearchDataSheets);
		emptyDataSheets.setBounds(15, 125, 1310, 425);

		return emptyDataSheets;
	}

	private JPanel refreshData(ArrayList<String> incomingArray,
			JPanel refreshedContainer, int rowCount, int columnCount) {
		GridLayout scrollGridLayout = new GridLayout(0, 6, 0, 0);
		refreshedContainer.setLayout(scrollGridLayout);
		Dimension maxSize = new Dimension();
		maxSize.setSize(1100, 0);
		int arrayTraverse = 0;

		for (int i = 0; i < rowCount; i++) {
			JPanel searchedDataText = new JPanel();
			searchedDataText.setFont(f);
			searchedDataText.setLayout(new GridLayout());
			for (int j = 0; j < columnCount; j++) {
				JTextField searchedDataTextField = new JTextField();
				searchedDataTextField.setFont(dataFont);
				searchedDataTextField.setEditable(false);
				searchedDataTextField.setText(incomingArray.get(arrayTraverse));
				searchedDataText.add(searchedDataTextField);
				maxSize.setSize(maxSize.getWidth() + 12,
						maxSize.getHeight() + 2);
				refreshedContainer.setPreferredSize(maxSize);
				arrayTraverse++;

			}
			scrollGridLayout.setRows(scrollGridLayout.getRows() + 1);
			refreshedContainer.add(searchedDataText);
		}
		return refreshedContainer;
	}

	private void addNewActionListenerPanelSwitch(JButton incomingButton,
			final JPanel parentPanel, final JPanel childPanel) {
		incomingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.repaint();
				parentPanel.setVisible(true);
				parentPanel.add(childPanel);
				childPanel.repaint();
				childPanel.setVisible(true);
			}
		});

	}

	private JPanel initializeDataSheets(String string,
			JPanel searchedDataContainer) {
		GridLayout scrollGridLayout = new GridLayout(0, 6, 0, 0);
		searchedDataContainer.setLayout(scrollGridLayout);
		Dimension maxSize = new Dimension();
		maxSize.setSize(1100, 150);

		for (int i = 0; i < 10; i++) {
			JPanel searchedDataText = new JPanel();
			searchedDataText.setFont(f);
			searchedDataText.setLayout(new GridLayout());
			for (int j = 0; j < 6; j++) {
				JTextField searchedDataTextField = new JTextField();
				searchedDataTextField.setFont(dataFont);
				searchedDataTextField.setEditable(false);
				searchedDataTextField.setText(string);
				searchedDataText.add(searchedDataTextField);
				maxSize.setSize(maxSize.getWidth(), maxSize.getHeight() + 8);
				searchedDataContainer.setPreferredSize(maxSize);
			}

			scrollGridLayout.setRows(scrollGridLayout.getRows() + 1);
			searchedDataContainer.add(searchedDataText);
		}

		return searchedDataContainer;
	}
}