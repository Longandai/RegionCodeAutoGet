package com.autoget.core;
import com.autoget.core.reptile.ReginReptile;
import com.autoget.core.reptile.ReginReptileFactory;
import com.autoget.core.state.RegionState;
import com.autoget.core.ReptileRunner;
/**
 * 执行方式  看看是多线程还是怎么的
 * ...
 * @author Long
 *
 */
public class Handler {
	public static void go(RegionState regionState){
	ReginReptile reginReptile = 	new ReginReptileFactory().getReptile(regionState);
		if(regionState.getStep().equals(StepType.COUNTY)||
				regionState.getStep().equals(StepType.CITY)||
				regionState.getStep().equals(StepType.TOWN)){
			reginReptile.reptile();
		}else{
			ReptileRunner run = new ReptileRunner();
			run.setReginReptile(reginReptile);
			new Thread(run).start();
		}
	
	}
}
