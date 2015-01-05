package com.autoget.core.reptile;

import com.autoget.core.reptile.impl.CityReptile;
import com.autoget.core.reptile.impl.CountyReptile;
import com.autoget.core.reptile.impl.PrivenceReptile;
import com.autoget.core.reptile.impl.TownReptile;
import com.autoget.core.state.RegionState;

public class ReginReptileFactory {
	/**
	 * 通过状态来判断要创建哪种类型的爬虫
	 * @param regionState
	 * @return
	 */
	public ReginReptile getReptile(RegionState regionState){
		ReginReptile reginReptile = null;
		switch (regionState.getStep()) {
		case PROVINCE:
			reginReptile = new PrivenceReptile();
			
			break;
		case CITY:
			reginReptile = new CityReptile();
			break;
		case COUNTY:
			reginReptile = new CountyReptile();
			break;
		case TOWN:
			reginReptile = new TownReptile();
			break;
		default:
			break;
		}
		reginReptile.setState(regionState);
		return reginReptile;
	}
}
