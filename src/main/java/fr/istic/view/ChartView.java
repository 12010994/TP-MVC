package fr.istic.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JComponent;

import fr.istic.model.Chart;
import fr.istic.model.Segment;

import java.awt.geom.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class ChartView extends JComponent implements Observer{


	private static final long serialVersionUID = 1L;
	private Chart chart;
	private Rectangle2D rect;
	private Line2D line;
	
	Color[] colors = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.DARK_GRAY, Color.LIGHT_GRAY};
	int indcolor = 0;

	public ChartView(Chart chart){
		this.chart = chart;
		chart.addObserver(this);
	}
	
	public int nextColor(){
		if(colors.length-1 <= indcolor){
			indcolor = 0;
		}else{
			indcolor += 1;
		}
		return indcolor;
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D graph = (Graphics2D) g;

		Font font = new Font("Arial",Font.BOLD, 16);
		graph.setFont(font);
		int ecart = 0;
		
		for (Segment seg : chart.getSegments()){
			
			float degres = ((float) seg.getVal() /(float) chart.getTotal())*360;
			Arc2D.Double arcChart;
			if(seg.isFocused()){
				arcChart = new Arc2D.Double(0, 0, 110, 110, ecart, degres,Arc2D.PIE);
				//new Arc2D.D
				arcChart.setFrame(100, 100, 300, 300);
				System.out.println("true");
			}else{
				arcChart = new Arc2D.Double(0, 0, 90, 90, ecart, degres,Arc2D.PIE);
				arcChart.setFrame(100, 100, 300, 300);
			}
			graph.setPaint(colors[indcolor]);

			graph.fill(arcChart);
			arcChart.contains(ecart, ecart+degres);
			//System.out.println(arcChart.contains(ecart, ecart+degres));
			
			indcolor = nextColor();
			ecart += degres;
		}
		
		//Allows separation between the segments and the center circle
		graph.setPaint(Color.WHITE);
		Arc2D.Double arcWhite = new Arc2D.Double(0, 0, 360, 0, 0, 360, Arc2D.PIE);
		arcWhite.setFrame(150, 150, 200, 200);
		graph.fill(arcWhite);	
		
		//center circle with the title and the total numerical values ​​of the fields.
		graph.setPaint(Color.BLUE);
		Arc2D.Double arcCenter = new Arc2D.Double(0, 0, 360, 0, 0, 360, Arc2D.PIE);
		arcCenter.setFrame(175, 175, 150, 150);
		graph.fill(arcCenter);	
		
		graph.setPaint(Color.WHITE);
		graph.drawString(chart.getName(), 200,230);
		graph.drawString(Integer.toString(chart.getTotal()), 200, 260);



	}

	public void update(Observable o, Object arg) {
		repaint();
	}
	

}

