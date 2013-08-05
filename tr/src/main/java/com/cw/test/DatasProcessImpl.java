package com.cw.test;

import java.util.ArrayList;
import java.util.List;

import com.cw.test.model.Antenne;
import com.cw.test.model.Datas;
import com.cw.test.model.Result;
import com.cw.test.model.Signal;
import com.cw.test.model.Signaux;

/**
 * 
 * @author Bellevue
 *
 */
public class DatasProcessImpl implements DatasProcessor {

	/*
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.cw.test.DatasComputer#compute(com.cw.test.model.Datas)
	 */
	@Override
	public List<Result> process(Datas datas) throws Exception {
		List<Signaux> listSignaux = datas.getSignaux();
		List<Result> results = new ArrayList<Result>();
		
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
			
			Result result=  new Result();
			result.setX(Math.round(cumulPositionIntensiteX / cumulIntensite));
			result.setY(Math.round(cumulPositionIntensiteY / cumulIntensite));
			results.add(result);
		}
		
		return results;
	}
}
