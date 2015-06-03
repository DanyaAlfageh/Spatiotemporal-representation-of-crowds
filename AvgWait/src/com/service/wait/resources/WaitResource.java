package com.service.wait.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.wait.dao.SnifferDAO;
import com.service.wait.dao.SnifferDAOImpl;
import com.service.wait.domain.Sniffer;

@Path("/avgwait")
public class WaitResource {
	SnifferDAO obj;
	
	@GET
	@Path("{path:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sniffer> displayXml(@PathParam("path") String pathS) throws ClassNotFoundException, SQLException{
		String []split = pathS.split("/");
		if (split[0].equalsIgnoreCase("location") && split.length == 1){
			obj = new SnifferDAOImpl();
			return obj.getWaitTime();
		}
		
		else if (split[0].equalsIgnoreCase("sublocation") && split.length == 1){
			obj = new SnifferDAOImpl();
			return obj.getSubLocationWait();
		}
		return null;
	}
	
	
	/*@GET
	public String sayHello() {
		return "Hello world";
	}*/
	
	/*@GET
	@Path("{path:.*}")
	@Produces("application/json")
	public ArrayList<Sniffer> displayJson(@PathParam("path") String pathS) throws ClassNotFoundException, SQLException{
		String []split = pathS.split("/");
		if (split[0].equalsIgnoreCase("ab") && split.length == 1){
			 obj = new SnifferDAOImpl();
			return obj.getLocationCount();
		}
		return null;
	}*/
}
