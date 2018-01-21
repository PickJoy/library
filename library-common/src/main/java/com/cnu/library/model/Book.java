package com.cnu.library.model;

import javax.persistence.*;

/**
 * 图书类
 * @author liang
 *
 */
@Entity
@Table(name = "t_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String insb;
	//总数量
	private int sum;
	//剩余数量
	private int surplus;

	public Book() {
	}

	public Book(int surplus, String name, String insb, int sum) {
		this.surplus = surplus;
		this.name = name;
		this.insb = insb;
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInsb() {
		return insb;
	}
	public void setInsb(String insb) {
		this.insb = insb;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	
}
