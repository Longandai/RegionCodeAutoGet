package com.autoget.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.autoget.core.Handler;
import com.autoget.core.StepType;
import com.autoget.core.log.StateLog;
import com.autoget.core.state.RegionState;
//非常好使~~~~嘿嘿~~
public class ReptileRunner {
	private static String BASE_URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/";
	public static void runReptile() throws Exception{
		Document document = Jsoup.connect(BASE_URL).timeout(999999).get();
		Elements links = document.select("tr.provincetr a");
		System.err.println(links.size());
		int i = 0;
		for(Element link:links){
			i++;
			System.out.println(link.text());
			System.out.println(BASE_URL +link.attr("href"));
			RegionState regionState = new RegionState();
			regionState.setUrl(BASE_URL +link.attr("href"));
			regionState.setSelfName(link.text());
			String code = link.attr("href").substring(0,link.attr("href").indexOf("."));
			regionState.setCode(code);
			regionState.setStep(StepType.PROVINCE);
			new StateLog().log(regionState);
			Handler.go(regionState);
		}
		
	}
	public static void main(String[] args) {
//		RegionState regionState = new RegionState();
//		regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/12.html");
//		regionState.setStep(StepType.PROVINCE);
//		Handler.go(regionState);
		try {
			runReptile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
