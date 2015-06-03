package com.service.plot.domain;

import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
//@XmlType(namespace = "com.service/sniffer")
public class DeviceInfo {
	
	private String Mac_ID;
	private String locationName;
	private String subLocationName;
	private int range;
	
	public DeviceInfo(){
		
	}
	
	public DeviceInfo(String Mac_ID, String locationName, String subLocationName, int range){
		this.setMac_ID(Mac_ID);
		this.setLocationName(locationName);
		this.setSubLocationName(subLocationName);
		this.setRange(range);
	}

	public String getMac_ID() {
		return Mac_ID;
	}

	public void setMac_ID(String mac_ID) {
		Mac_ID = mac_ID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getSubLocationName() {
		return subLocationName;
	}

	public void setSubLocationName(String subLocationName) {
		this.subLocationName = subLocationName;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	
}

