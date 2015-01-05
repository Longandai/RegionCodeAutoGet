package com.autoget.core.state;

import java.io.Serializable;

import com.autoget.core.StepType;
/**
 * 记录爬取的状态
 * 爬取数据的配置项
 * @author 刘志龙
 *
 */
@SuppressWarnings("serial")
public class RegionState implements Serializable,Cloneable {
	private String code;
	private String parentCode;
	private String townType;
	private String selfName;
	private StepType step;
	private String privence;
	private String city;
	private String county;
	private String town;
	private String village;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrivence() {
		return privence;
	}

	public void setPrivence(String privence) {
		this.privence = privence;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getTownType() {
		return townType;
	}

	public void setTownType(String townType) {
		this.townType = townType;
	}

	public String getSelfName() {
		return selfName;
	}

	public void setSelfName(String selfName) {
		this.selfName = selfName;
	}


	public StepType getStep() {
		return step;
	}

	public void setStep(StepType step) {
		this.step = step;
	}

	@Override
	public Object clone(){
		Object result = null;
		try {
			result= super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
