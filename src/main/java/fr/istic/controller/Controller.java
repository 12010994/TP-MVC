package fr.istic.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;

import fr.istic.model.Chart;
import fr.istic.model.Segment;
import fr.istic.view.ChartView;

public class Controller implements Observer{
	
	private Chart chart;
	private ChartView chartView;
	private ListIterator<Segment> it;

	public Controller(){
		
		chart = new Chart("Sample Chart");
		chart.addObserver(this);
		chartView = new ChartView(chart);
		it = chart.getSegments().listIterator();
	}
	
	public static void main(final String[] args) throws InterruptedException {
		
		Controller controller = new Controller();
		
		JFrame frame = new JFrame("Chart Application");
		frame.setSize(600,600);
		
		frame.getContentPane().add(controller.chartView);

		frame.setVisible(true);
		
		controller.chart.createSegment(100, "segment1", "Premier segment de test");
		controller.chart.createSegment(500, "segment2", "Deuxieme semgnet de test");
		controller.chart.createSegment(300, "segment3", "Troisieme segment de test");
		controller.chart.createSegment(300, "segment4", "Quatrieme segment de test");
		controller.chart.createSegment(100, "segment5", "Cinquieme segment de test");
		controller.nextSegment();
		Thread.sleep(1000);
		System.out.println("hello");
		controller.nextSegment();
		Thread.sleep(1000);
		System.out.println("hello");
		controller.nextSegment();
		Thread.sleep(1000);
		System.out.println("hello");
		controller.nextSegment();
		MouseListener l = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//e.getPos().x; e.getPos().y pour mouse listener 
			    System.out.println(e.getX()+","+e.getY());
			    //controller.chartView.
			}
		};
		
		//controller.chartView.addMouseListener(l);
		frame.addMouseListener(l);
		
	}

	public void update(Observable o, Object arg) {
		if (it != chart.getSegments().listIterator()){
			it = chart.getSegments().listIterator();
		}
	}
	
	public void nextSegment(){
		it.next();
		it.previous().setFocused(false);
		it.next().setFocused(true);
		chart.hasChanged();
		chart.notifyObservers();
	}
	
}

