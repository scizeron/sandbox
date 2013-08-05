package com.cw.test.model;

import com.cw.test.DataExeption;

/**
 * 
 * @author Bellevue
 *
 */
public class Antenne {

	String id;
	
	int x;
	
	int y;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int  getX() {
		return x;
	}

	public void setX(int  x) {
		this.x = parseUnsignedInt(x);
	}

	public int  getY() {
		return y;
	}

	public void setY(int y) {
		this.y = parseUnsignedInt(y);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private int parseUnsignedInt(int value) {
		if (value < 0) {
			throw new DataExeption(
					"La postion '" + value + "' ne respecte pas le format attendu, entier > 0 uniquement");
		}
		return value;
	}
}