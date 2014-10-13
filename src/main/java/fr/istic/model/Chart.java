package fr.istic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Chart extends Observable{
	
	private String name;
	private int total;
	
	private List<Segment> segments;
	
	public Chart(String name) {
		this.name = name;
		total = 0;
		segments = new ArrayList<Segment>();
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}

	public void createSegment(int val, String name, String descriptor, String color){
		total+=val;
		segments.add(new Segment(name, descriptor, val, color));
		notifyObservers();
	}
	
	public void deleteSegment(Segment segment){
		total-=segment.getVal();
		segments.remove(segment);
		notifyObservers();
	}
	
	public void setSegment(int val, Segment segment){
		deleteSegment(segment);
		createSegment(val, segment.getName(), segment.getDescriptor(), segment.getColor());
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
		notifyObservers();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		notifyObservers();
	}

	public List<Segment> getSegments() {
		return segments;
	}

}
