package com.autoget.core.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.autoget.core.Config;
import com.autoget.core.state.RegionState;

public class ErrorLog {
	public static void log(RegionState regionState){
		//先读出来 放到list里面  然后再写进去
		ObjectOutputStream oos=null;
		
		try {
			synchronized (ErrorLog.class) {
				List<RegionState> lists =readErrorLog();
				lists.add(regionState);
				File f =  new File(Config.ERRORPATH);
				if(!f.exists()){
					f.createNewFile();
				}
				oos = new ObjectOutputStream(new FileOutputStream(f));
				for(RegionState a:lists){
					oos.writeObject(regionState);
				}
				oos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public static List<RegionState> readErrorLog(){
		List<RegionState> lists = new ArrayList<RegionState>();
		File f =new File(Config.ERRORPATH) ;
		if(!f .exists()){
			return lists;
		}
		ObjectInputStream oin = null;
		try {
			FileInputStream in = new FileInputStream(f);
			 oin = new ObjectInputStream(in);
			RegionState state = null;
			while(true){
				
				try {
					state =(RegionState) oin.readObject();
				} catch (Exception e) {
					// TODO: handle exception
					break;
				}
				lists.add(state);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(oin!=null){
				try {
					oin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lists;
	}
}
