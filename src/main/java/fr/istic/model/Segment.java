package fr.istic.model;

public class Segment {
	
	private String name;
	private String descriptor;
	private int val;
	private boolean focused;
	
	public Segment(String name, String descriptor, int val) {
		this.name = name;
		this.descriptor = descriptor;
		this.val = val;
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

	public boolean isFocused() {
		return focused;
	}

	public void setFocused(boolean focused) {
		this.focused = focused;
	}

	
}

