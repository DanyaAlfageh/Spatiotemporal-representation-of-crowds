package com.service.wait.client1;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
 


import java.util.Iterator;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class SublocationChart {
	public SublocationChart(){
		super();
	}

	
	
	public static void main(String[] args) throws JSONException {
		BarChartSub demo = new BarChartSub("Avg Wait Time","");
		demo.pack();
		demo.setVisible(true);
		
	}

}

class BarChartSub extends JFrame {
	 
	 private static final long serialVersionUID = 1L;
	 
	 
	 public BarChartSub(String applicationTitle, String chartTitle) throws JSONException {
		 super(applicationTitle);
		 Client c = Client.create();
	     WebResource resource = c.resource("http://localhost:8080/AvgWait/resources/avgwait/sublocation");
	     JSONObject response = resource.get(JSONObject.class);
	     Iterator<String> itr = response.keys();
	     String key = null;
	     
	     while (itr.hasNext()){
	    	 key = itr.next().toString();
	     }
	        
	     JSONObject list= (JSONObject) response.get(key);
	     
	     CategoryDataset dataset = this.createDataSet(list);
	     JFreeChart chart = createChart(dataset, chartTitle);
	     ChartPanel chartPanel = new ChartPanel(chart);
	   
	     // to define the size of the bar chart
	     chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	     setContentPane(chartPanel);
	 }
	 
	 public DefaultCategoryDataset createDataSet(JSONObject list) throws JSONException {
		 DefaultCategoryDataset result = new DefaultCategoryDataset();
	     double value = Double.parseDouble(list.getString("count"));
	     result.setValue(value, "Number of people", list.getString("locationName"));
		 
	     return result;
		 }
	 
	 /**
	  * Creates a chart
	  */
	 
	 private JFreeChart createChart(CategoryDataset dataset, String title) {
	         //creates 3D bar chart with the chart name as "Employee Salary Increment"
	         // In order to create a horizontal bar chart, we need yo mention Plot orientation as PlotOrientation.HORIZONTAL
	 
	  JFreeChart chart = ChartFactory.createBarChart3D(
	    "Wait Time", "Location", "Count",
	    dataset, PlotOrientation.VERTICAL, true, true, false);
	  Plot plot = chart.getPlot();
	   
	  // set the opacity of the hart
	  plot.setForegroundAlpha(0.5f);
	  CategoryPlot p = chart.getCategoryPlot();
	   
	  // set the color of the grid line
	  p.setRangeGridlinePaint(Color.blue);
	  //set the color of the title
	  chart.getTitle().setPaint(Color.blue);
	  return chart;
	 
	 }
}
