package com.cnu.library.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="t_borrower" )
public class Borrower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	 int id;
	//账号
	private String account;
	//密码
	private String password;
	//已借书的数量
	private int saveBooks;
	//已预定书的数量
	private int reserveBooks;
	//最多可以借多少书,初始值为6
	private int maxSaveBooks=50;
	/**
	 * 是否可借书,初始值为true
	 */
	private Boolean visible=true;
	private Date createTime=new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getSaveBooks() {
		return saveBooks;
	}
	public void setSaveBooks(int saveBooks) {
		this.saveBooks = saveBooks;
	}
	public int getReserveBooks() {
		return reserveBooks;
	}
	public void setReserveBooks(int reserveBooks) {
		this.reserveBooks = reserveBooks;
	}
	public int getMaxSaveBooks() {
		return maxSaveBooks;
	}
	public void setMaxSaveBooks(int maxSaveBooks) {
		this.maxSaveBooks = maxSaveBooks;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	@Override
	public String toString() {
		return "Borrower [id=" + id + ", account=" + account + ", password="
				+ password + ", saveBooks=" + saveBooks + ", reserveBooks="
				+ reserveBooks + ", maxSaveBooks=" + maxSaveBooks
				+ ", visible=" + visible + ", createTime=" + createTime + "]";
	}
	
}
