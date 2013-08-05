package com.cw.test;

import org.junit.Test;

public class TriangularisationTestCase {

	/**
	 * @param args
	 */
	@Test public void compute() throws Exception {
		System.setProperty("debug.mode","true"); // evite le System.exit() dans le batch
		Triangularisation.main(new String [] {"src/test/resources/inputfileok.txt"});
	}
}
