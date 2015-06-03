package com.service.crowd.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.crowd.domain.Sniffer;

public interface SnifferDAO {
		/*
		 * 
		 */
		public ArrayList<Sniffer> getLocationCount () throws SQLException, ClassNotFoundException;
		public ArrayList<Sniffer> getSubLocationCount () throws SQLException, ClassNotFoundException;

}
