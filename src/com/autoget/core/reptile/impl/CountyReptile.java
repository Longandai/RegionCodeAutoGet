package com.autoget.core.reptile.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.autoget.core.Config;
import com.autoget.core.Handler;
import com.autoget.core.StepType;
import com.autoget.core.log.ErrorLog;
import com.autoget.core.log.StateLog;
import com.autoget.core.reptile.ReginReptile;
import com.autoget.core.state.RegionState;

public class CountyReptile implements ReginReptile {
	private RegionState regionState;
	private StateLog log = new StateLog(); 
	@Override
	public void reptile() {
		Document document;
		try {
			document = Jsoup.connect(regionState.getUrl()).timeout(999999).get();
			Elements links = document.select("tr.towntr");
			System.err.println(links.size());
			String url1 = regionState.getUrl();
			int i = url1.lastIndexOf("/");
			String url_ = url1.substring(0, i+1);
			for(Element element:links ){
				/**
				 * ���⴦��û�����ӵĸ�ʽ
				 */
				String code = null;
				String url=null;
				String name = null;
				if(element.select("a").size() == 0 ){
					 code = element.child(0).text();
					 name = element.child(1).text();
				}else{
					 code = element.child(0).select("a").get(0).text();
					 url =url_+  element.child(0).select("a").get(0).attr("href");
					 name = element.child(1).select("a").get(0).text();
				}
				RegionState regionState_ = (RegionState) this.regionState.clone();
				regionState_.setParentCode(regionState_.getCode());
				regionState_.setSelfName(name);
				regionState_.setCounty(name);
				regionState_.setCode(code);
				regionState_.setUrl(url);
				regionState_.setStep(StepType.TOWN);
				log.log(regionState_);
				if(url!=null){
					Handler.go(regionState_);
				}
				
			}
		} catch (Exception e) {
			ErrorLog.log(regionState);
			System.out.println(regionState.getUrl());
			e.printStackTrace();
		}
		regionState = null;
		System.gc();
	}

	@Override
	public void setState(RegionState regionState) {
		// TODO Auto-generated method stub
		this.regionState = regionState;
	}


}
