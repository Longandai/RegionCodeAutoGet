package com.autoget.core;

import com.autoget.core.reptile.ReginReptile;

public class ReptileRunner implements Runnable {
	public ReginReptile reginReptile;
	
	public ReginReptile getReginReptile() {
		return reginReptile;
	}

	public void setReginReptile(ReginReptile reginReptile) {
		this.reginReptile = reginReptile;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		reginReptile.reptile();
	}

}
