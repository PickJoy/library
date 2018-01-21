package com.cnu.library.model;

import javax.persistence.*;

/**
 * 预定书
 * @author liang
 *
 */


@Entity
@Table(name ="t_reservation" )
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//书id
	private String bookid;
	//借阅者
	private String borrowerid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBorrowerid() {
		return borrowerid;
	}
	public void setBorrowerid(String borrowerid) {
		this.borrowerid = borrowerid;
	}
	
}
