package edu.kec.entertainment.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbConnector {
	private Connection connection = null;
	private final String hostName= "jdbc:mysql://localhost:3306/entertainment";
	private final String userName="root";
	private final String password= "";
	 
	public Connection getConnection() {
		try{
			connection = DriverManager.getConnection(this.hostName, this.userName, this.password);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return connection;
	}
	public boolean insertOrUpdate(String query) {
		boolean isCommit=false;
		try {
			Statement statement = this.connection.createStatement();
			statement.executeUpdate(query);
			isCommit = true;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return isCommit;
	}
	
	public ResultSet getDataFromTable(String query) {
		ResultSet resultSet=null;
		try {
			Statement statement=this.connection.createStatement();
			resultSet=statement.executeQuery(query);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return resultSet;
	}
	public void closeConnection() {
		try {
			this.connection.close();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
