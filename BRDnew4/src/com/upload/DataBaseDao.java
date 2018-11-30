package com.upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fileHandling.Customers;

public class DataBaseDao {
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {

			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static boolean validate(String username, String password) {
		boolean status = false;

		try {
			preparedStatement = connection
					.prepareStatement("select * from login_details where user_id=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultset = preparedStatement.executeQuery();

			status = resultset.next();
		} catch (SQLException e) {

			System.out.println(e);
		}

		return status;

	}

	public static void makerForm(int CustomerID, String CustomerCode, String CustomerName, String CustomerAddress1,
			String CustomerAddress2, String CustomerPincode, String Email, String ContactNumber,
			String PrimaryContactPerson, String RecordStatus, String ActiveInactiveFlag, String CreateDate,
			String CreateBy, String ModifiedDate, String ModifiedBy, String AuthorizedDate, String AuthorizedBy) {

		try {
			preparedStatement = connection
					.prepareStatement("insert into user_details_form values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, CustomerID);
			preparedStatement.setString(2, CustomerCode);
			preparedStatement.setString(3, CustomerName);
			preparedStatement.setString(4, CustomerAddress1);
			preparedStatement.setString(5, CustomerAddress2);
			preparedStatement.setString(6, CustomerPincode);
			preparedStatement.setString(7, Email);
			preparedStatement.setString(8, ContactNumber);
			preparedStatement.setString(9, PrimaryContactPerson);
			preparedStatement.setString(10, RecordStatus);
			preparedStatement.setString(11, ActiveInactiveFlag);
			preparedStatement.setString(12, CreateDate);
			preparedStatement.setString(13, CreateBy);
			preparedStatement.setString(14, ModifiedDate);
			preparedStatement.setString(15, ModifiedBy);
			preparedStatement.setString(16, AuthorizedDate);
			preparedStatement.setString(17, AuthorizedBy);
			preparedStatement.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public static void databaseMethod(Customers customer) throws SQLException
	{
		
		PreparedStatement preparedstatement =connection.prepareStatement("insert into user_details_form values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setInt(1, customer.getCustomerID());
		preparedstatement.setString(2, customer.getCustomerCode());
		preparedstatement.setString(3, customer.getCustomerName());
		preparedstatement.setString(4, customer.getCustomerAddress1());
		preparedstatement.setString(5, customer.getCustomerAddress2());
		preparedstatement.setString(6, customer.getCustomerPinCode());
		preparedstatement.setString(7, customer.getEmailAddress());
		preparedstatement.setString(8, customer.getContactNumber());
		preparedstatement.setString(9, customer.getPrimaryContactPerson());
		preparedstatement.setString(10, customer.getRecordStatus());
		preparedstatement.setString(11, customer.getActiveInactiveFlag());
		preparedstatement.setString(12, customer.getCreateDate());
		preparedstatement.setString(13, customer.getCreatedBy());
		preparedstatement.setString(14, customer.getModifiedDate());
		preparedstatement.setString(15, customer.getModifiedBy());
		preparedstatement.setString(16, customer.getAuthorizedDate());
		preparedstatement.setString(17, customer.getAuthorizedBy());
		
		preparedstatement.executeUpdate();
		

	}
	public static void name()
	{
		try
		{
			PreparedStatement preparedstatement =connection.prepareStatement("TRUNCATE TABLE user_details_form");
			preparedstatement.executeUpdate();
			connection.close();
		} catch (SQLException e)
		{
			System.out.println(e);
		}
	}

}