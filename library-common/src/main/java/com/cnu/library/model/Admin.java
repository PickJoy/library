package com.cnu.library.model;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="t_admin" )
public class Admin {
	//id标识
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	 int id;
	//账号
	private String account;
	//密码
	private String password;
	public Admin() {
		super();
	}

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
}
