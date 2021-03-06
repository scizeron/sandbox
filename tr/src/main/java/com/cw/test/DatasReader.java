package com.cw.test;

import com.cw.test.model.Datas;

/**
 * 
 * @author Bellevue
 *
 */
public interface DatasReader {

	public static final int MAX_ANTENNES = 20;
	
	public static final int MAX_SIGNAUX = 100;
	
	public static final int NB_ATTRIBUTS_PAR_LIGNE_ANTENNE = 3;
	
	public static final int NB_ATTRIBUTS_PAR_LIGNE_SIGNAL = 6;
	
	public static final String SEP_LIGNE_ANTENNE = " ";
	
	public static final String SEP_LIGNE_SIGNAL = " ";
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract Datas read() throws Exception;

}