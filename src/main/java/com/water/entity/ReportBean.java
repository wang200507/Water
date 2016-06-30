package com.water.entity;

import java.io.Serializable;

public class ReportBean extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID <属性描述>
	 */
	private static final long serialVersionUID = -7599487748294507193L;
	
	/**
	 * @Fields name 名称及规格
	 */
	private String name;
	
	/**
	 * @Fields utit 单位
	 */
	private String utit;
	
	/**
	 * @Fields weight 重量
	 */
	private String weight;
	
	/**
	 * @Fields price 单价
	 */
	private String price;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return utit
	 */
	public String getUtit() {
		return utit;
	}
	
	/**
	 * @param utit
	 *            要设置的 utit
	 */
	public void setUtit(String utit) {
		this.utit = utit;
	}
	
	/**
	 * @return weight
	 */
	public String getWeight() {
		return weight;
	}
	
	/**
	 * @param weight
	 *            要设置的 weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/**
	 * @return price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 *            要设置的 price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
}
