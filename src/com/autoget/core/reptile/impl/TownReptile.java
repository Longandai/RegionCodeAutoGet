package com.autoget.core.reptile.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.autoget.core.Config;
import com.autoget.core.log.ErrorLog;
import com.autoget.core.log.StateLog;
import com.autoget.core.reptile.ReginReptile;
import com.autoget.core.state.RegionState;

public class TownReptile implements ReginReptile {
	private RegionState regionState;
	private StateLog log = new StateLog(); 
	@Override
	public void reptile() {
		Document document;
		try {
			document = Jsoup.connect(regionState.getUrl()).timeout(999999).get();
			Elements links = document.select("tr.villagetr");
			System.err.println(links.size());
			for(Element element:links ){
					String code = element.child(0).text();
					String type = element.child(1).text();
					String name = element.child(2).text();
					RegionState regionState_ = (RegionState) this.regionState.clone();
					regionState_.setParentCode(regionState_.getCode());
					regionState_.setSelfName(name);
					regionState_.setVillage(name);
					regionState_.setCode(code);
					regionState_.setTownType(type);
					log.log(regionState_);
					regionState_ = null;
					System.gc();
			}
			regionState = null;
			System.gc();
		} catch (Exception e) {
			ErrorLog.log(regionState);
			System.out.println(regionState.getUrl());
			e.printStackTrace();
		}
		
	}

	@Override
	public void setState(RegionState regionState) {
		// TODO Auto-generated method stub
		this.regionState = regionState;
	}


}
