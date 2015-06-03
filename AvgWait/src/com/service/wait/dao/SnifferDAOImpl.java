package com.service.wait.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.service.wait.domain.Sniffer;
import com.service.wait.utils.JDBCUtils;

public class SnifferDAOImpl implements SnifferDAO{

	/*
	 * Get the number of devices at a location
	 */
	public ArrayList<Sniffer> getWaitTime () throws SQLException, ClassNotFoundException{
		
		JDBCUtils db = new JDBCUtils();
		ArrayList<Sniffer> dumpRows = new ArrayList<Sniffer>(); 
		
		db.createConnection();
		Statement st = db.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT AVG(timediff) AS 'Average'"
				+ ",SubLocation_Name AS 'SubLocation'"
				+ "FROM (SELECT Mac_ID,Sniffer_ID,SubLocation_Name,"
				+ "timestampdiff(MINUTE,Min(Time_Stamp),Max(Time_Stamp)) AS timediff "
				+ "FROM cs581.dump JOIN cs581.sublocation "
				+ "WHERE Sniffer_ID=SubLocation_ID GROUP BY Sniffer_ID,Mac_ID "
				+ "HAVING timestampdiff(MINUTE,Min(Time_Stamp),Max(Time_Stamp)) > 5) "
				+ "AS Difference GROUP BY Sniffer_ID;");
		
		
		while(rs.next()){
			Sniffer obj = new Sniffer(rs.getString(1),rs.getString(2));
			dumpRows.add(obj);
		}
		
		db.closeConnection();
		return dumpRows;
	}
	
	public ArrayList<Sniffer> getSubLocationWait () throws SQLException, ClassNotFoundException{
		JDBCUtils db = new JDBCUtils();
		ArrayList<Sniffer> dumpRows = new ArrayList<Sniffer>(); 
		
		db.createConnection();
		Statement st = db.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT AVG(timediff) AS 'Average'"
				+ ",SubLocation_Name AS 'SubLocation'"
				+ "FROM (SELECT Mac_ID,Sniffer_ID,SubLocation_Name,"
				+ "timestampdiff(MINUTE,Min(Time_Stamp),Max(Time_Stamp)) AS timediff "
				+ "FROM cs581.dump JOIN cs581.sublocation "
				+ "WHERE Sniffer_ID=SubLocation_ID AND SubLocation_ID = '1'  GROUP BY Sniffer_ID,Mac_ID "
				+ "HAVING timestampdiff(MINUTE,Min(Time_Stamp),Max(Time_Stamp)) > 5) "
				+ "AS Difference GROUP BY Sniffer_ID;");
		
		
		while(rs.next()){
			Sniffer obj = new Sniffer(rs.getString(1),rs.getString(2));
			dumpRows.add(obj);
		}
		
		db.closeConnection();
		return dumpRows;
	}
	
	
}
