package com.service.wait.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.wait.domain.Sniffer;



public interface SnifferDAO {
		/*
		 * 
		 */
		public ArrayList<Sniffer> getWaitTime () throws SQLException, ClassNotFoundException;
		public ArrayList<Sniffer> getSubLocationWait () throws SQLException, ClassNotFoundException;

}
