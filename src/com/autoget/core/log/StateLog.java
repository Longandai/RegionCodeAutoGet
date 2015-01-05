package com.autoget.core.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.autoget.core.Config;
import com.autoget.core.state.RegionState;

public class StateLog {
	public void log(RegionState regionState){
		/**
		 * 插入到一个文档中
		 */
		String s = regionState.getParentCode() +"   " +regionState.getCode() + "  "+regionState.getSelfName() + "  "+regionState.getTownType();
		System.out.println(s);
		try {
			synchronized (StateLog.class) {
				File f = new File(Config.LOGPATH);
				if(!f.exists()){
					f.createNewFile();
				}
				PrintWriter  bw = new PrintWriter (new FileWriter(f,true));
				bw.println(s);
				bw.flush();
				bw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	};
}
