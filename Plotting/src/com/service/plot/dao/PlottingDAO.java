package com.service.plot.dao;

import java.sql.SQLException ;

import com.service.plot.domain.DeviceInfo;

public interface PlottingDAO {
		
		public DeviceInfo getLocation(String macId) throws SQLException, ClassNotFoundException;
		
}
