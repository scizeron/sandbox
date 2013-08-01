package com.cw.test.model;

import java.util.ArrayList;
import java.util.List;

public class Signaux {

	List<Signal> values;
	
	public Signaux() {
		this.values = new ArrayList<Signal>(3);
	}
	
	public void addSignal(Signal signal) {
		this.values.add(signal);
	}
	
	public List<Signal> getValues() {
		return this.values;
	}

}
