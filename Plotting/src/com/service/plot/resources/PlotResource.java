package com.service.plot.resources;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.plot.dao.PlottingDAO;
import com.service.plot.dao.PlottingDAOImpl;
import com.service.plot.domain.DeviceInfo;
@Path("/plot")

public class PlotResource {
	PlottingDAO object;
	@GET
	@Path("{path:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public DeviceInfo displayXml(@PathParam("path") String pathS) throws ClassNotFoundException, SQLException{
		String []split = pathS.split("/");
		if (split[0].equalsIgnoreCase("Mac_Address") && split.length == 1){
			object = new PlottingDAOImpl();
			return object.getLocation("50:85:69:46:F5:A8");
		}
		return null;
	}
	
	

}
