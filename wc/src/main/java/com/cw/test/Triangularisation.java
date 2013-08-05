/**
 * 
 */
package com.cw.test;

import java.io.File;

/**
 * 
 * @author Bellevue
 *
 */
public class Triangularisation {

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
			System.exit(1);
		}
		
		try {
			new SimpleDatasWriterImpl().write(
					new DatasProcessImpl().process(
							new FileDatasReaderImpl(file).read()));
			
		} catch(Exception exception) {
			exception.printStackTrace();
			System.exit(1);
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
}