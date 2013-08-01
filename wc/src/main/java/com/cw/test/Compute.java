/**
 * 
 */
package com.cw.test;

import java.io.File;
import java.io.PrintWriter;

import com.cw.test.model.Datas;

/**
 * 
 * @author Bellevue
 *
 */
public class Compute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File file = null;
		
		if (args != null && args.length == 1 && args[0] != null && args[0].trim().length() > 0) {
			file = new File(args[0]);
		
		} else {
			System.err.println("bad arguments");
			usage();
			exit(1);
		}
		
		try {
			DatasReader reader = new DatasFileReader(file);
			Datas datas = reader.read();
			
			DatasComputer datasComputer = new DatasComputer();
			datasComputer.compute(datas, new PrintWriter(System.out));
			
			exit(0);
			
		} catch(Exception exception) {
			exception.printStackTrace();
			exit(1);
		}
	}

	/**
	 * 
	 */
	private static void usage() {
		System.out.println("Usage : Calcul de triangularisation");
		System.out.println("arguments :");
		System.out.println("<fichier> : ficher contenant les données de calcul");
	}
	
	/**
	 * 
	 * @param code
	 */
	private static void exit(int code) {
		if (!"true".equals(System.getProperty("debug.mode"))) {
			System.exit(code);
		}
	}
}
