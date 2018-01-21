package com.cnu.library.vo;

public class AdminVo {
	private int id;
	//账号
	private String account;
	//密码
	private String password;
	
	//书名
	private String name;
	//书号
	private String insb;
	//书总数量
	private int sum;
	//剩余书数量
	private int surplus;
	//当前页
	private int page=1;
	//当前页最大数
	private int maxResult=7;
	
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
	public int getPage() {
		// TODO Auto-generated method stub
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	
	
}
