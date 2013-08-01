package com.cw.test.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datas {
	
	int nbAntennes;
	
	Map<String, Antenne> antennes;
	
	List<Signaux> signaux;
	
	public Datas() {
		this.antennes = new HashMap<String, Antenne>();
		this.signaux = new ArrayList<Signaux>();
	}

	public int getNbAntennes() {
		return nbAntennes;
	}

	public void setNbAntennes(int nbAntennes) {
		this.nbAntennes = nbAntennes;
	}

	public Map<String, Antenne> getAntennes() {
		return antennes;
	}

	public void setAntennes(Map<String, Antenne> antennes) {
		this.antennes = antennes;
	}
	
	public void addAntenne(Antenne antenne) {
		this.antennes.put(antenne.getId(), antenne);
	}
	
	public void addSignaux(Signaux signaux) {
		this.signaux.add(signaux);
	}
	
	public List<Signaux> getSignaux() {
		return this.signaux;
	}
}