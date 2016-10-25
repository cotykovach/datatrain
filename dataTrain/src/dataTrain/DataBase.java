package dataTrain;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
	private static final String String = null;
	public static ArrayList<String> dataBaseArrayList = new ArrayList<String>();
	public static int rowCount;
	public static int columnCount;

	private static Statement main() throws SQLException, IOException {

		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

		String serverName = "csor6.bsu.edu";
		String portNumber = "1521";
		String sid = "or6db";
		String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
				+ sid;

		Connection conn = DriverManager.getConnection(url, "crkovach", "3713");

		Statement stmt = conn.createStatement();

		return stmt;
	}

	public static boolean logInVerification(String userName, String passWord)
			throws SQLException, IOException {

		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from employee where employee.email = '"
						+ userName + "' order by lname");

		if (rset.next() == false) {
			stmt.close();
			return false;
		} else if (rset.getString(6).compareTo(passWord) == 0) {
			stmt.close();
			return true;
		}
		stmt.close();
		return false;
	}

	public static void SearchTrainByOriginOrDestination(String trainID,
			String trainOrigin, String trainDestination, String orderBy) throws SQLException,
			IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();

		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Train where ID LIKE '%" + trainID + "%'" 
						+" AND ORIGIN like '%"
						+ trainOrigin + "%' AND DESTINATION like '%"
						+ trainDestination + "%'"
						+ " ORDER BY " + orderBy);

		ResultSetMetaData rsetMetaData = rset.getMetaData();

		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			rowCount++;
		}
	}// end method

	public static void SearchCargoByOriginOrDestination(String cargoID,
			String cargoOrigin, String cargoDestination, String cargoSender,
			String cargoGreaterThanWeight, String cargoLessThanWeight,
			String cargoGreaterThanPrice, String cargoLessThanPrice, String orderBy)
			throws SQLException, IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();
		
		if(cargoGreaterThanWeight.compareTo("")==0)
		 {
		  cargoGreaterThanWeight = "0";
		 }
		
		if(cargoLessThanWeight.compareTo("")==0)
		{
			cargoLessThanWeight = "9999";
		}
		
		if(cargoGreaterThanPrice.compareTo("")==0)
		 {
		  cargoGreaterThanPrice = "0";
		 }
		 
		if(cargoLessThanPrice.compareTo("")==0)
		{
			cargoLessThanPrice = "9999";
		}
		
		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Cargo where ORIGIN like '%"
						+ cargoOrigin + "%' AND DESTINATION like '%"
						+ cargoDestination + "%' AND ID like '%" + cargoID
						+ "%' AND SENDER like '%" + cargoSender + "%'  AND WEIGHT BETWEEN " + cargoGreaterThanWeight + " AND " + cargoLessThanWeight
						+ " AND PRICE BETWEEN " + cargoGreaterThanPrice + " AND " + cargoLessThanPrice
						+ " ORDER BY " + orderBy);
		
		ResultSetMetaData rsetMetaData = rset.getMetaData();

		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			dataBaseArrayList.add(rset.getString(5));
			dataBaseArrayList.add(rset.getString(6));
			dataBaseArrayList.add(rset.getString(7));
			rowCount++;
		}
	}// end method

	public static void SearchTicketByOriginOrDestination(String ticketID,
			String ticketOrigin, String ticketDestination, String ticketUserID, String ticketGreaterThanPrice, String ticketLessThanPrice, String orderBy) throws SQLException,
			IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();
		
		if(ticketGreaterThanPrice.compareTo("")==0)
		 {
			ticketGreaterThanPrice = "0";
			
		 }
		
		if(ticketLessThanPrice.compareTo("")==0)
		{
			ticketLessThanPrice = "9999";
		}

		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Ticket where ID like '%" + ticketID + "%'" 
						+ " AND ORIGIN like '%"
						+ ticketOrigin + "%' AND DESTINATION like '%"
						+ ticketDestination + "%'"
						+ " AND PRICE BETWEEN " + ticketGreaterThanPrice + " AND " + ticketLessThanPrice
						+ " AND USERID Like '%" + ticketUserID + "%'"
						+ " ORDER BY " + orderBy);

		ResultSetMetaData rsetMetaData = rset.getMetaData();
		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			dataBaseArrayList.add(rset.getString(5));
			dataBaseArrayList.add(rset.getString(6));
			dataBaseArrayList.add(rset.getString(7));
			rowCount++;
		}
	}// end method

	public static void SearchStationByIDNameAddress(String stationID,
			String stationName, String stationAddress, String orderBy) throws SQLException,
			IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();

		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Station where ID like '%"
						+ stationID + "%' AND NAME like '%" + stationName
						+ "%' AND ADDRESS like '%" + stationAddress + "%'"
						+ " ORDER BY " + orderBy);

		ResultSetMetaData rsetMetaData = rset.getMetaData();
		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			rowCount++;
		}
	}// end method

	public static void SearchEmployeeByIDFNameLName(String employeeSSN,
			String employeeFName, String employeeLName, String employeeGreaterSalary, String employeeLessThanSalary, String orderBy) throws SQLException,
			IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();
		
		if(employeeGreaterSalary.compareTo("")==0)
		 {
			employeeGreaterSalary = "0";
		 }

		if(employeeLessThanSalary.compareTo("")==0)
		{
			employeeLessThanSalary = "999999";
		}
		
		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Employee where SSN like '%"
						+ employeeSSN + "%' AND FNAME like '%" + employeeFName
						+ "%' AND LNAME like '%" + employeeLName + "%'"
						+ " AND SALARY BETWEEN " + employeeGreaterSalary + " AND " + employeeLessThanSalary
						+ " ORDER BY " + orderBy);

		ResultSetMetaData rsetMetaData = rset.getMetaData();
		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			dataBaseArrayList.add(rset.getString(5));
			dataBaseArrayList.add(rset.getString(6));
			dataBaseArrayList.add(rset.getString(7));
			dataBaseArrayList.add(rset.getString(8));
			dataBaseArrayList.add(rset.getString(9));
			dataBaseArrayList.add(rset.getString(10));
			dataBaseArrayList.add(rset.getString(11));
			dataBaseArrayList.add(rset.getString(12));
			rowCount++;
		}
	}// end method

	public static void SearchCustomerByIDFNameLName(String customerID,
			String customerFName, String customerLName, String orderBy) throws SQLException,
			IOException {

		rowCount = 0;
		columnCount = 0;
		dataBaseArrayList.clear();

		Statement stmt = main();
		ResultSet rset = stmt
				.executeQuery("select * from Customer where ID like '%"
						+ customerID + "%' AND FNAME like '%" + customerFName
						+ "%' AND LNAME like '%" + customerLName + "%'"
						+ " ORDER BY " + orderBy);

		ResultSetMetaData rsetMetaData = rset.getMetaData();
		columnCount = rsetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			dataBaseArrayList.add(rsetMetaData.getColumnLabel(i));
		}

		while (rset.next() == true) {
			dataBaseArrayList.add(rset.getString(1));
			dataBaseArrayList.add(rset.getString(2));
			dataBaseArrayList.add(rset.getString(3));
			dataBaseArrayList.add(rset.getString(4));
			dataBaseArrayList.add(rset.getString(5));
			dataBaseArrayList.add(rset.getString(6));
			dataBaseArrayList.add(rset.getString(7));
			dataBaseArrayList.add(rset.getString(8));
			rowCount++;
		}
	}// end method

	/*
	 * public static boolean SearchTicketByOriginOrDestination(String origin,
	 * String destination) throws SQLException, IOException { Statement stmt =
	 * main(); ResultSet rset = stmt
	 * .executeQuery("select * from Ticket where ORIGIN like '%" + origin +
	 * "%' or DESTINATION like '%" + destination + "%'");
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) { ticketInfoSeachByOD.add(rset.getString(1));
	 * ticketInfoSeachByOD.add(rset.getString(2));
	 * ticketInfoSeachByOD.add(rset.getString(3));
	 * ticketInfoSeachByOD.add(rset.getString(4));
	 * ticketInfoSeachByOD.add(rset.getString(5));
	 * ticketInfoSeachByOD.add(rset.getString(6));
	 * ticketInfoSeachByOD.add(rset.getString(7));
	 * ticketInfoSeachByOD.add(rset.getString(8)); } return false; }// end
	 * method
	 * 
	 * public static boolean SearchTicketByPrice(double minPrice, double
	 * maxPrice) throws SQLException, IOException { Statement stmt = main();
	 * ResultSet rset = stmt
	 * .executeQuery("select * from Ticket where PRICE BETWEEN " + minPrice +
	 * " AND " + maxPrice);
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) { ticketInfoSeachByPrice.add(rset.getString(1));
	 * ticketInfoSeachByPrice.add(rset.getString(2));
	 * ticketInfoSeachByPrice.add(rset.getString(3));
	 * ticketInfoSeachByPrice.add(rset.getString(4));
	 * ticketInfoSeachByPrice.add(rset.getString(5));
	 * ticketInfoSeachByPrice.add(rset.getString(6));
	 * ticketInfoSeachByPrice.add(rset.getString(7));
	 * ticketInfoSeachByPrice.add(rset.getString(8)); } return false; }// end
	 * method
	 * 
	 * public static boolean SearchTicketByUserID(String userID) throws
	 * SQLException, IOException { Statement stmt = main(); ResultSet rset =
	 * stmt .executeQuery("select * from Ticket where USERID = '" + userID +
	 * "'");
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) { ticketInfoSeachByUserID.add(rset.getString(1));
	 * ticketInfoSeachByUserID.add(rset.getString(2));
	 * ticketInfoSeachByUserID.add(rset.getString(3));
	 * ticketInfoSeachByUserID.add(rset.getString(4));
	 * ticketInfoSeachByUserID.add(rset.getString(5));
	 * ticketInfoSeachByUserID.add(rset.getString(6));
	 * ticketInfoSeachByUserID.add(rset.getString(7));
	 * ticketInfoSeachByUserID.add(rset.getString(8)); } return false; }// end
	 * method
	 * 
	 * public static boolean SearchTicketByStationID(String stationID) throws
	 * SQLException, IOException { Statement stmt = main(); ResultSet rset =
	 * stmt .executeQuery("select * from Ticket where STATIONID = '" + stationID
	 * + "'");
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) {
	 * ticketInfoSeachByStationID.add(rset.getString(1));
	 * ticketInfoSeachByStationID.add(rset.getString(2));
	 * ticketInfoSeachByStationID.add(rset.getString(3));
	 * ticketInfoSeachByStationID.add(rset.getString(4));
	 * ticketInfoSeachByStationID.add(rset.getString(5));
	 * ticketInfoSeachByStationID.add(rset.getString(6));
	 * ticketInfoSeachByStationID.add(rset.getString(7));
	 * ticketInfoSeachByStationID.add(rset.getString(8)); } return false; }//
	 * end method
	 * 
	 * public static boolean SearchTicketByCustomerID(String customerID) throws
	 * SQLException, IOException { Statement stmt = main(); ResultSet rset =
	 * stmt .executeQuery("select * from Ticket where CUSTOMERID = '" +
	 * customerID + "'");
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) {
	 * ticketInfoSeachByCustomerID.add(rset.getString(1));
	 * ticketInfoSeachByCustomerID.add(rset.getString(2));
	 * ticketInfoSeachByCustomerID.add(rset.getString(3));
	 * ticketInfoSeachByCustomerID.add(rset.getString(4));
	 * ticketInfoSeachByCustomerID.add(rset.getString(5));
	 * ticketInfoSeachByCustomerID.add(rset.getString(6));
	 * ticketInfoSeachByCustomerID.add(rset.getString(7));
	 * ticketInfoSeachByCustomerID.add(rset.getString(8)); } return false; }//
	 * end method
	 * 
	 * public static boolean SearchStationByName(String name) throws
	 * SQLException, IOException { Statement stmt = main(); ResultSet rset =
	 * stmt .executeQuery("select * from Station where NAME like '%" + name +
	 * "%'");
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) { stationInfoSearchByName.add(rset.getString(1));
	 * stationInfoSearchByName.add(rset.getString(2));
	 * stationInfoSearchByName.add(rset.getString(3));
	 * stationInfoSearchByName.add(rset.getString(4)); } return false; }// end
	 * method
	 * 
	 * public static boolean SearchEmployeeBySalary(double minSalary, double
	 * maxSalary) throws SQLException, IOException { Statement stmt = main();
	 * ResultSet rset = stmt
	 * .executeQuery("select * from Employee where SALARY BETWEEN " + minSalary
	 * + " AND " + maxSalary);
	 * 
	 * if (rset.next() == false) { stmt.close(); return false; } else if
	 * (rset.next() == true) {
	 * EmployeeInfoSearchBySalary.add(rset.getString(1));
	 * EmployeeInfoSearchBySalary.add(rset.getString(2));
	 * EmployeeInfoSearchBySalary.add(rset.getString(3));
	 * EmployeeInfoSearchBySalary.add(rset.getString(4));
	 * EmployeeInfoSearchBySalary.add(rset.getString(5));
	 * EmployeeInfoSearchBySalary.add(rset.getString(6));
	 * EmployeeInfoSearchBySalary.add(rset.getString(7));
	 * EmployeeInfoSearchBySalary.add(rset.getString(8));
	 * EmployeeInfoSearchBySalary.add(rset.getString(9));
	 * EmployeeInfoSearchBySalary.add(rset.getString(10));
	 * EmployeeInfoSearchBySalary.add(rset.getString(11));
	 * EmployeeInfoSearchBySalary.add(rset.getString(12)); } return false; }//
	 * end method
	 */

	public static ArrayList<java.lang.String> returnArray() {
		return dataBaseArrayList;
	}

	public static int returnRowCount() {
		return rowCount;
	}

	public static int returnColumnCount() {
		return columnCount;
	}

}