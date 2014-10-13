package fr.istic.controller;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import fr.istic.model.Chart;
import fr.istic.model.Segment;
import fr.istic.view.ChartView;

public class Controller implements Observer{
	
	private Chart chart;
	private ChartView chartView;
	
	private Iterator<Segment> selected;

	public Controller(){
		
		chart = new Chart("ChartTest");
		chart.addObserver(this);
		chartView = new ChartView(chart);
		
		selected = chart.getSegments().iterator();
	}
	
	public static void main(final String[] args) throws InterruptedException {
		
		Controller controller = new Controller();
		
		controller.chart.createSegment(100, "segment1", "Test", "Blue");
		while(true){
			controller.chart.setName("test");
			Thread.sleep(1000);
		}
	}

	public void update(Observable o, Object arg) {
		
	}
	
	public void leftSegment(){
		selected.next();
	}
	
}
