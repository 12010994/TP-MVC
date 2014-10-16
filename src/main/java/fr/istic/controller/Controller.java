package fr.istic.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

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
	
	public static void main(final String[] args) {
		
		JFrame frame = new JFrame("test");
		frame.setSize(500,500);
		
		Controller controller = new Controller();
		
		frame.getContentPane().add(controller.chartView);

		frame.setVisible(true);
		
		
		controller.chart.createSegment(100, "segment1", "Test");
		controller.chart.createSegment(500, "segment2", "testoi");
		controller.chart.createSegment(300, "segment3", "Hello");
		controller.chart.createSegment(300, "segment4", "Hello1");
		controller.chart.createSegment(100, "segment53", "Hello2");
		
		

		MouseListener l = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//e.getPos().x; e.getPos().y pour mouse listener 
			    e.getX(); e.getY();
			    System.out.println(e.getX());
			    System.out.println(e.getY());
			    //controller.chartView.
				
			}
		};
		frame.addMouseListener(l);
		
		
	}

	public void update(Observable o, Object arg) {
		System.out.println("controller updated");
	}
	
	public void nextSegment(){
		selected.next();
	}
	
}

