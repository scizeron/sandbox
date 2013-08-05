package com.cw.test;

import java.io.PrintWriter;
import java.util.List;

import com.cw.test.model.Result;

/**
 * 
 * @author Bellevue
 *
 */
public class SimpleDatasWriterImpl implements DatasWriter {

	PrintWriter printWriter = new PrintWriter(System.out);
	
	@Override
	public void write(List<Result> results) {
		for (Result result : results) {
			printWriter.println(String.format("%d %d", result.getX(), result.getY()));
			printWriter.flush();
		}
	}
}
