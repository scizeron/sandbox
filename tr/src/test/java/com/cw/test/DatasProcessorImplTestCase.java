package com.cw.test;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.cw.test.model.Datas;
import com.cw.test.model.Result;
/**
 * 
 * @author Bellevue
 *
 */
public class DatasProcessorImplTestCase {

	@Test public void process() throws Exception {
		Datas datas = new  FileDatasReaderImpl(new File("src/test/resources/inputfileok.txt")).read();
		List<Result> results = new DatasProcessImpl().process(datas);

		Assert.assertNotNull(results);
		Assert.assertEquals(2, results.size());
		
		new SimpleDatasWriterImpl().write(results);
		
		Assert.assertEquals(40, results.get(0).getX());
		Assert.assertEquals(80, results.get(0).getY());
		Assert.assertEquals(42, results.get(1).getX());
		Assert.assertEquals(84, results.get(1).getY());
	}
}