package fr.istic.model;

import java.util.List;
import java.util.Observer;

public interface IChart {

	public abstract void addObserver(Observer o);

	public abstract void createSegment(int val, String name, String descriptor);

	public abstract void deleteSegment(Segment segment);

	public abstract void setSegment(int val, Segment segment);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract int getTotal();

	public abstract void setTotal(int total);

	public abstract List<Segment> getSegments();

}