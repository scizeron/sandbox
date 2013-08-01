package com.cw.test;

import java.io.PrintWriter;
import java.util.List;

import com.cw.test.model.Antenne;
import com.cw.test.model.Datas;
import com.cw.test.model.Signal;
import com.cw.test.model.Signaux;

/**
 * 
 * @author Bellevue
 *
 */
public class DatasComputer {

	/*
	 * 
	 */
	public void compute(Datas datas, PrintWriter printWriter) throws Exception {
		List<Signaux> listSignaux = datas.getSignaux();
		
		for (Signaux signaux : listSignaux) {
			float cumulIntensite = 0;
			float cumulPositionIntensiteX = 0;
			float cumulPositionIntensiteY = 0;
			
			for (Signal signal : signaux.getValues()) {
				Antenne antenne = datas.getAntennes().get(signal.getAntenneId());
				cumulIntensite += signal.getValue();
				cumulPositionIntensiteX += signal.getValue()*antenne.getX();
				cumulPositionIntensiteY += signal.getValue()*antenne.getY();
			}
			
			int x = Math.round(cumulPositionIntensiteX / cumulIntensite);
			int y = Math.round(cumulPositionIntensiteY / cumulIntensite);
			printWriter.println(String.format("%d %d", x, y));
			printWriter.flush();
		}
	}
}
