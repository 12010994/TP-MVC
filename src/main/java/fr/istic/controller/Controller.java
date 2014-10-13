package fr.istic.controller;

import java.util.Observable;
import java.util.Observer;

import fr.istic.model.Chart;
import fr.istic.model.IChart;
import fr.istic.view.ChartView;
import fr.istic.view.IChartView;

public class Controller implements Observer{
	
	private IChart chart;
	private IChartView chartView;

	public Controller(){
		
		chart = new Chart("Chart1");
		chartView = new ChartView(chart);
	}
	
	public static void main(final String[] args) {
		
		Controller controller = new Controller();
		controller.chart.addObserver(controller);
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
