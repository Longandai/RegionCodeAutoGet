package com.autoget.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.junit.Test;

import com.autoget.core.Config;
import com.autoget.core.Handler;
import com.autoget.core.StepType;
import com.autoget.core.log.ErrorLog;
import com.autoget.core.reptile.ReginReptile;
import com.autoget.core.reptile.impl.CityReptile;
import com.autoget.core.reptile.impl.CountyReptile;
import com.autoget.core.reptile.impl.PrivenceReptile;
import com.autoget.core.reptile.impl.TownReptile;
import com.autoget.core.state.RegionState;

import static org.junit.Assert.*;
public class ReptileTest {
	
	
	
	@Test
	public void test(){
		System.out.println("i can use");
		assertTrue(true);
	}
	@Test
	public void testCity(){
		ReginReptile reginReptile = new CityReptile();
		RegionState regionState = new RegionState();
		regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/21/2102.html");
		reginReptile.setState(regionState);
		reginReptile.reptile();
		assertTrue(true);
	}
	@Test
	public void testCounty(){
		ReginReptile reginReptile = new CountyReptile();
		RegionState regionState = new RegionState();
		regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/21/02/210202.html");
		reginReptile.setState(regionState);
		reginReptile.reptile();
		assertTrue(true);
	}
	//@Test
	public void testPrivance(){
		ReginReptile reginReptile = new PrivenceReptile();
		RegionState regionState = new RegionState();
		regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/21.html");
		reginReptile.setState(regionState);
		reginReptile.reptile();
		assertTrue(true);
	}
	@Test
		public void testTown(){
			ReginReptile reginReptile = new TownReptile();
			RegionState regionState = new RegionState();
			regionState.setCode("371427000000");
			regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/37/14/27/371427103.html");
			reginReptile.setState(regionState);
			reginReptile.reptile();
			assertTrue(true);
		}
		//@Test
		public void testError(){
			RegionState regionState = new RegionState();
			regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/11/01/07/110107002.html");
			ErrorLog.log(regionState);
			ErrorLog.log(regionState);
			ErrorLog.log(regionState);
			assertTrue(true);
		}
		@Test
		public void testReadLog(){
			File f =new File(Config.ERRORPATH) ;
			try {
				FileInputStream in = new FileInputStream(f);
				ObjectInputStream oin = new ObjectInputStream(in);
				RegionState state = null;
				while(true){
					
					try {
						state =(RegionState) oin.readObject();
						
						
					} catch (Exception e) {
						// TODO: handle exception
						break;
					}
					if(state==null){}else{
						System.out.println(state.getUrl());
						System.out.println(state.getParentCode());
						Handler.go(state);
//						Handler.go(state);
					}
				
					;
					
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(true);
		}
		@Test
		public void testGo(){
			RegionState regionState = new RegionState();
			regionState.setUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/12.html");
			regionState.setStep(StepType.PROVINCE);
			Handler.go(regionState);
		}
}

