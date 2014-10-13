package fr.istic.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.sun.glass.events.WindowEvent;
import com.sun.prism.paint.Color;

import fr.istic.model.Chart;

import java.awt.event.WindowAdapter;
import java.awt.geom.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ChartView extends JComponent implements Observer{


	private static final long serialVersionUID = 1L;
	private Chart chart;
	private Rectangle2D rect;
	private Line2D line;
	 
	public ChartView(Chart chart){
		this.chart = chart;
		chart.addObserver(this);
	}

	public static void main(String[] args){
	     ChartView chart= new ChartView(new Chart("test"));
	     
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

	protected void paintComponent(Graphics g) {
		Graphics2D graph = (Graphics2D) g;
		
		Font font = new Font("Arial",Font.BOLD, 16);
		graph.setFont(font);
		int degres = 0;
		
		for (int i =0; i<chart.getTotal(); i++){
			//degres += 
		}
		Arc2D.Double arcChart = new Arc2D.Double(0, 0, 90, 0, 0, 90,Arc2D.PIE);
		arcChart.setFrame(100, 100, 300, 300);
		

		
		//Arc2D.Double arcCenter = new Arc2D.Double(0, 0, 360, 0, 0, 360, Arc2D.PIE);
		//arcCenter.setFrame(150, 150, 200, 200);
		
		
		//graph.drawString(chart.getName(), 200,230);
		

		//graph.draw(arcCenter);		
		graph.fill(arcChart);
		
		
	}

	public void update(Observable o, Object arg) {
		System.out.println("view updated");
		paintComponent(getGraphics());
		System.out.println(arg);
		System.out.println(o.getClass());
		
	}

}
