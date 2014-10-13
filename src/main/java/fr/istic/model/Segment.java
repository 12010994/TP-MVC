package fr.istic.model;

public class Segment {
	
	private String name;
	private String descriptor;
	private String color;
	private int val;
	
	public Segment(String name, String descriptor, int val, String color) {
		this.name = name;
		this.descriptor = descriptor;
		this.val = val;
		this.setColor(color);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
