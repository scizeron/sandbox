package com.cw.test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import junit.framework.Assert;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.cw.test.model.Datas;

public class DatasComputerTestCase {

	@Test public void compute() throws Exception {
		Datas datas = new  DatasFileReader(new File("src/test/resources/inputfileok.txt")).read();
		StringWriter sw = new StringWriter();
		new DatasComputer().compute(datas, new PrintWriter(sw));
		System.out.print(sw.toString());
		String [] lines = StringUtils.split(sw.toString(),System.getProperty("line.separator"));
		Assert.assertEquals("40 80", lines[0]);
		Assert.assertEquals("42 84", lines[1]);
	}
}