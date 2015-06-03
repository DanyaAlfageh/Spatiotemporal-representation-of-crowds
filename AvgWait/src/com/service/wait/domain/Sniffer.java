package com.service.wait.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
//@XmlType(namespace = "com.service/sniffer")
public class Sniffer {
	
	private String count;
	private String locationName;
	private String avg;
	
	
	public Sniffer(){
		
	}
	
	public Sniffer(String count, String locationName){
		this.setcount(count);
		this.setLocationName(locationName);
		
	}

	public String getcount() {
		return count;
	}

	public void setcount(String count) {
		this.count = count;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
}

