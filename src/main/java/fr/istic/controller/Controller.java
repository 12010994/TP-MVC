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
	
	public static void main(final String[] args){
		
		Controller controller = new Controller();
		
		controller.chart.createSegment(100, "segment1", "Premier segment", "Blue");
	}

	public void update(Observable o, Object arg) {
		System.out.println("controller updated");
	}
	
	public void nextSegment(){
		selected.next();
	}
	
}
