package com.service.plot.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private Connection con;
    private Statement st;
    
	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param set the connection
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the statement
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * @param set the statement
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	
    
    /** Creates a new instance of DB */
    public void createConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://localhost/cs581","root","" );

    }
    
    public Statement createStatement() throws SQLException{
        this.st = this.con.createStatement();
        return this.st;
    }
    
    public void closeStatement() throws SQLException{
        this.st.close();
    }
    public void closeConnection() throws SQLException{
        this.con.close();
    }
}
