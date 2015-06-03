package com.service.wait.client1;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JFrame;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

//import com.service.crowd.client.BarChart1;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class WaitLocationChart {
	public WaitLocationChart() {
		super();
	}
	
	public static void main(String[] args) throws JSONException {
		BarChart1 demo = new BarChart1("Wait Time","");
		demo.pack();
		demo.setVisible(true);
		
	}

}

class BarChart1 extends JFrame {
	 
	 private static final long serialVersionUID = 1L;
	 
	 
	 public BarChart1(String applicationTitle, String chartTitle) throws JSONException {
		 super(applicationTitle);
		 Client c = Client.create();
	     WebResource resource = c.resource("http://localhost:8080/AvgWait/resources/avgwait/location");
	     JSONObject response = resource.get(JSONObject.class);
	     Iterator<String> itr = response.keys();
	     String key = null;
	     
	     while (itr.hasNext()){
	    	 key = itr.next().toString();
	     }
	        
	     JSONArray list= (JSONArray) response.get(key);
	     
	     CategoryDataset dataset = this.createDataSet(list);
	     JFreeChart chart = createChart(dataset, chartTitle);
	     ChartPanel chartPanel = new ChartPanel(chart);
	   
	     // to define the size of the bar chart
	     chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
	     setContentPane(chartPanel);
	 }
	 
	 public DefaultCategoryDataset createDataSet(JSONArray list) throws JSONException {
		 DefaultCategoryDataset result = new DefaultCategoryDataset();
		 for(int i=0; i<list.length(); i++){
	        	JSONObject obj = list.getJSONObject(i);
	        	double value = Double.parseDouble(obj.getString("count"));
	        	result.setValue(value, "", obj.getString("locationName"));
	     } 
		  return result;
		 }
	 
	 /**
	  * Creates a chart
	  */
	 
	 private JFreeChart createChart(CategoryDataset dataset, String title) {
	         //creates 3D bar chart with the chart name as "Employee Salary Increment"
	         // In order to create a horizontal bar chart, we need yo mention Plot orientation as PlotOrientation.HORIZONTAL
	 
	  JFreeChart chart = ChartFactory.createBarChart3D(
	    "Wait Time", "Location", "Average (Minutes)",
	    dataset, PlotOrientation.VERTICAL, true, true, false);
	  Plot plot = chart.getPlot();
	   
	  // set the opacity of the hart
	  plot.setForegroundAlpha(1.0f);
	  CategoryPlot p = chart.getCategoryPlot();
	   
	  // set the color of the grid line
	  p.setRangeGridlinePaint(Color.blue);
	  //set the color of the title
	  chart.getTitle().setPaint(Color.blue);
	  return chart;
	 
	 }
}
