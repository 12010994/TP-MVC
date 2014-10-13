package fr.istic.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import fr.istic.model.Chart;
import fr.istic.model.IChart;

public class ChartView extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	public ChartView(){
		IChart chart = new Chart("Chart1");
	}

	protected void paintComponent(Graphics g){
		
		Arc2D.Float arcChart = new Arc2D.Float(Arc2D.PIE);
		arcChart.setFrame(70, 200, 150, 150);
		arcChart.setAngleStart(0);
		arcChart.setAngleExtent(145);
		
		Graphics2D graph = (Graphics2D) g;
		graph.draw(arcChart);
		graph.drawLine(50, 50, 300, 300);
	}



}
