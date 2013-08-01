package com.cw.test;

import org.junit.Test;

public class ComputeTestCase {

	/**
	 * @param args
	 */
	@Test public void compute() throws Exception {
		System.setProperty("debug.mode","true"); // evite le System.exit() dans le batch
		Compute.main(new String [] {"src/test/resources/inputfileok.txt"});
	}
}
