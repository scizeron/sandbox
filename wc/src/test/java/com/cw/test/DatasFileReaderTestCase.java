package com.cw.test;

import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

import com.cw.test.model.Datas;
import com.cw.test.model.Signaux;

public class DatasFileReaderTestCase {

	/**
	 * 
	 * @throws Exception
	 */
	@Test public void read() throws Exception {
		Datas datas = new  DatasFileReader(new File("src/test/resources/inputfileok.txt")).read();
		Assert.assertNotNull(datas);
		Assert.assertEquals(4, datas.getNbAntennes());
		Assert.assertEquals(4, datas.getAntennes().size());
		Assert.assertEquals(2, datas.getSignaux().size());
		for (Signaux signaux : datas.getSignaux()) {
			Assert.assertEquals(3, signaux.getValues().size());
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test(expected=FileNotFoundException.class) public void readFichierIntrouvable() throws Exception {
		new DatasFileReader(new File("src/test/resources/introuvable.txt")).read();
	}
	
	/**
	 * N etre inférieur à  20
	 * @throws Exception
	 */
	@Test(expected=DataExeption.class) public void readError1() throws Exception {
		new DatasFileReader(new File("src/test/resources/error1.txt")).read();
	}
	
	/**
	 * M etre inférieur à 100
	 * @throws Exception
	 */
	@Test(expected=DataExeption.class) public void readError2() throws Exception {
		new DatasFileReader(new File("src/test/resources/error2.txt")).read();
	}
	
	/**
	 *mauvais format ligne Antenne
	 * @throws Exception
	 */
	@Test(expected=DataExeption.class) public void readError3() throws Exception {
		new DatasFileReader(new File("src/test/resources/error3.txt")).read();
	}
	
	/**
	 *mauvais format ligne Signal
	 * @throws Exception
	 */
	@Test(expected=DataExeption.class) public void readError4() throws Exception {
		new DatasFileReader(new File("src/test/resources/error4.txt")).read();
	}
}
