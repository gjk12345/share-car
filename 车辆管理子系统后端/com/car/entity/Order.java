package com.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_charge")
public class Order {
	private int id;
	private int orderid;
	private String starttime;
	private String startwhere;
	private String endtime;
	private String endwhere;
	private int money;
	private String brar;
	private String userid;
	private int carid;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStartwhere() {
		return startwhere;
	}
	public void setStartwhere(String startwhere) {
		this.startwhere = startwhere;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEndwhere() {
		return endwhere;
	}
	public void setEndwhere(String endwhere) {
		this.endwhere = endwhere;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getBrar() {
		return brar;
	}
	public void setBrar(String brar) {
		this.brar = brar;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
}
