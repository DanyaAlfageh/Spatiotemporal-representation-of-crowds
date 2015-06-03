package com.service.plot.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.service.plot.domain.DeviceInfo;
import com.service.plot.utils.JDBCUtils;

public class PlottingDAOImpl implements PlottingDAO {

		public DeviceInfo getLocation(String macId) throws SQLException, ClassNotFoundException{
			String resultSnifferID = null,resultDistance = null;
			DeviceInfo obj;
			JDBCUtils db = new JDBCUtils();
			db.createConnection();
			//Connection con = db.getCon();
			Statement st = db.createStatement();
			
			ResultSet rs = st.executeQuery(
					"SELECT Sniffer_ID,Distance "
					+ "FROM cs581.dump "
					+ "WHERE Mac_ID ='"+macId+"'"
					);
			

			
			while(rs.next()){
				resultSnifferID=new String(rs.getString(1));
				resultDistance=rs.getString(2);
				}
			obj=new DeviceInfo(macId,resultSnifferID.substring(0,2),resultSnifferID.substring(3),Integer.parseInt(resultDistance));
			db.closeConnection();
			return obj;
		}
		
		
	}
