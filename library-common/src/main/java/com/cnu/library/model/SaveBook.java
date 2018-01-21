package com.cnu.library.model;

import javax.persistence.*;


@Entity
@Table(name ="t_savebook" )
public class SaveBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//书id
	private int bookId;
	//借阅者
	private int borrowerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

}
