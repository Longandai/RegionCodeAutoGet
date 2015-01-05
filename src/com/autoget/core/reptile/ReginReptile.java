package com.autoget.core.reptile;

import com.autoget.core.state.RegionState;
/**
 * 爬虫 爬取数据
 * @author Long
 *
 */
public interface ReginReptile {
	/**
	 * 爬取数据
	 */
	public void reptile();
	/**
	 * 设置状态
	 * @param regionState
	 */
	public void setState(RegionState regionState);
}
