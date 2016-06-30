package com.water.entity;

import java.io.Serializable;

public class CountBean extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID <属性描述>
	 */
	private static final long serialVersionUID = 767846095189615322L;
	
	/**
	 * @Fields name 种类名称
	 */
	private String name;
	
	/**
	 * @Fields number 数量
	 */
	private String number;
	
	/**
	 * @Fields total 总计
	 */
	private String total;
	
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
	 * @return number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number
	 *            要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * @return total
	 */
	public String getTotal() {
		return total;
	}
	
	/**
	 * @param total
	 *            要设置的 total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
}
