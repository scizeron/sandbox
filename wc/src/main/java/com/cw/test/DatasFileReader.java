package com.cw.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

import com.cw.test.model.Antenne;
import com.cw.test.model.Datas;
import com.cw.test.model.Signal;
import com.cw.test.model.Signaux;

/**
 * 
 * @author ByTel
 * 
 */
public class DatasFileReader implements DatasReader {

	private File file;

	/**
	 * 
	 * @param file
	 */
	public DatasFileReader(File file) {
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cw.test.DatasReader#read()
	 */
	@Override
	public Datas read() throws Exception {
		Datas datas = new Datas();
		final AtomicInteger lines = new AtomicInteger(0);
		BufferedReader br = null;
		int index;
		String line;

		try {
			br = new BufferedReader(new FileReader(this.file));

			while ((line = br.readLine()) != null) {
				index = lines.incrementAndGet();

				if (index == 1) {
					// N : nb antennes
					int nbAntennes = Integer.parseInt(line);

					if (nbAntennes == MAX_ANTENNES) {
						throw new DataExeption("nb antennes: " + nbAntennes
								+ " doit être inférieur à " + MAX_ANTENNES);
					}

					datas.setNbAntennes(nbAntennes);

				} else if (1 < index && index <= datas.getNbAntennes() + 1) {
					// caracteritiques antenne
					// <ID> <X> <Y>

					List<String> antennesAttributes = Arrays.asList(StringUtils
							.split(line, SEP_LIGNE_ANTENNE));
					if (antennesAttributes == null
							|| antennesAttributes.size() != NB_ATTRIBUTS_PAR_LIGNE_ANTENNE) {
						throw new DataExeption("ligne antenne mal formattée : "
								+ line);
					}

					String id = antennesAttributes.get(0);

					if (!StringUtils.isAlphanumeric(id)) {
						throw new DataExeption(
								"id antenne : "
										+ id
										+ " ne respecte pas le format attendu, lettre uniquement : "
										+ line);
					}

					Antenne antenne = new Antenne();
					antenne.setId(id);
					antenne.setX(parseUnsignedInt(antennesAttributes.get(1),
							line));
					antenne.setY(parseUnsignedInt(antennesAttributes.get(2),
							line));
					datas.addAntenne(antenne);

				} else {

					if (datas.getSignaux().size() == MAX_SIGNAUX - 1) {
						throw new DataExeption(
								"la limite des signaux est atteinte : "
										+ MAX_SIGNAUX);
					}

					// signaux par antenne
					// <ID1> <G1> <ID2> <G2> <ID3> <G3>
					List<String> strSignaux = Arrays.asList(StringUtils.split(
							line, SEP_LIGNE_SIGNAL));
					if (strSignaux == null
							|| strSignaux.size() != NB_ATTRIBUTS_PAR_LIGNE_SIGNAL) {
						throw new RuntimeException("ligne signaux (" + index
								+ ") mal formattée : " + line);
					}

					Iterator<String> itSignaux = strSignaux.iterator();
					Signaux signaux = new Signaux();

					while (itSignaux.hasNext()) {
						String antenneId = itSignaux.next();
						int value = Integer.parseInt(itSignaux.next());
						Signal signal = new Signal();
						signal.setAntenneId(antenneId);
						signal.setValue(value);
						signaux.addSignal(signal);
					}

					datas.addSignaux(signaux);
				}
			}
		} finally {
			if (br != null)
				br.close();
		}

		return datas;
	}

	/**
	 * 
	 * @param value
	 * @param line
	 * @return
	 */
	private int parseUnsignedInt(String value, String line) {
		int intValue = Integer.parseInt(value);
		if (intValue < 0) {
			throw new DataExeption(
					"La postion '"
							+ value
							+ "' ne respecte pas le format attendu, entier > 0 uniquement : "
							+ line);
		}
		return intValue;
	}
}
