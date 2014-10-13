package fr.istic.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.sun.glass.events.WindowEvent;
import com.sun.prism.paint.Color;

import fr.istic.model.IChart;

import java.awt.event.WindowAdapter;
import java.awt.geom.*;
import java.awt.*;

public class ChartView extends JComponent {

	 public static void main(String[] args){
	     ChartView chart= new ChartView();
	     
	   
			JFrame f = new JFrame("Chart");
			f.getContentPane().add( chart, "Center" );

			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setSize(new Dimension(500, 450));
			f.setVisible(true);
		
	    
	   }
	 
public class ChartView extends JComponent implements Observer{
	
	private static final long serialVersionUID = 1L;
	private IChart chart;
	private Rectangle2D rect;
	private Line2D line;
	
	
	public ChartView(IChart chart){
		this.chart = chart;
		chart.addObserver(this);
	}

	public ChartView() {
		// TODO Auto-generated constructor stub
	}
	
	

	protected void paintComponent(Graphics g) {
		Graphics2D graph = (Graphics2D) g;
		
		Arc2D.Double arcChart = new Arc2D.Double(0, 0, 90, 0, 0, 360,Arc2D.PIE);
		arcChart.setFrame(100, 100, 200, 200);
		

		
		Arc2D.Double arcCenter = new Arc2D.Double(0, 0, 360, 0, 0, 360, Arc2D.PIE);
		arcCenter.setFrame(150, 150, 100, 100);
		
		
		
		graph.draw(arcCenter);		
		graph.draw(arcChart);
		graph.drawLine(50, 50, 300, 300);
		
	}

	public void update(Observable o, Object arg) {
		System.out.println("updated");
		System.out.println(arg);
		System.out.println(o.getClass());
		
	}

}
