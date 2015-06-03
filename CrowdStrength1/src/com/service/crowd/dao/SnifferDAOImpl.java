package com.service.crowd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.service.crowd.domain.Sniffer;
import com.service.crowd.utils.JDBCUtils;

//@XmlRootElement(name = "Object-List")
public class SnifferDAOImpl implements SnifferDAO{
	public ArrayList<Sniffer> getLocationCount () throws SQLException, ClassNotFoundException{
		
		JDBCUtils db = new JDBCUtils();
		ArrayList<Sniffer> dumpRows = new ArrayList<Sniffer>(); 
		
		db.createConnection();
		//Connection con = db.getCon();
		Statement st = db.createStatement();
		
		ResultSet rs = st.executeQuery(""
				+ "SELECT count(distinct Mac_ID) AS 'Count',SubLocation_Name,Sniffer_ID "
				+ "FROM cs581.dump JOIN cs581.sublocation "
				+ "WHERE SubLocation_ID = Sniffer_ID "
				+ "GROUP BY SubLocation_Name");
		
		
		while(rs.next()){
			Sniffer obj = new Sniffer(rs.getString(1),rs.getString(2));
			dumpRows.add(obj);
		}
		
		db.closeConnection();
		return dumpRows;
	}
	
	/*
	 * Get the number of devices at a sublocation
	 */
	public ArrayList<Sniffer> getSubLocationCount () throws SQLException, ClassNotFoundException{
		JDBCUtils db = new JDBCUtils();
		ArrayList<Sniffer> dumpRows = new ArrayList<Sniffer>(); 
		
		db.createConnection();
		Statement st = db.createStatement();
		
		ResultSet rs = st.executeQuery(""
				+ "SELECT count(distinct Mac_ID) AS 'Count',SubLocation_Name,Sniffer_ID "
				+ "FROM cs581.dump JOIN cs581.sublocation "
				+ "WHERE SubLocation_ID = Sniffer_ID AND SubLocation_ID = 1");
		
		
		while(rs.next()){
			Sniffer obj = new Sniffer(rs.getString(1),rs.getString(2));
			dumpRows.add(obj);
		}
		
		db.closeConnection();
		return dumpRows;
	}
}
