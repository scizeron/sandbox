package com.cw.test;

import java.util.List;

import com.cw.test.model.Datas;
import com.cw.test.model.Result;
/**
 * 
 * @author Bellevue
 *
 */
public interface DatasProcessor {

	/*
	 * 
	 */
	public abstract List<Result> process(Datas datas) throws Exception;

}