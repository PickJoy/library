package com.cnu.library.service;

import java.util.LinkedHashMap;

import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.base.QueryResult;

public interface BorrowerService {
	/**
	 * 根据账号查找用户
	 * @param account
	 * @return
	 */
	public Borrower findByAccount(String account);
	/**
	 * 根据id查找借阅者
	 * @param id
	 * @return
	 */
	public Borrower find(int id);
	/**
	 * 更新用户新
	 * @param borrower
	 */
	public boolean update(Borrower borrower);
	/**
	 * 保存用户
	 * @param borrower
	 */
	public void save(Borrower borrower);
	/**
	 * 获取记录总数
	 * @return
	 */
	public long getCount();
	/**
	 * 根据条件分页查询，结果根据条件排序
	 * @param page 第几页从1开始  如果为-1表示不分页
	 * @param maxresult 一页的最大记录数，如果为1表示不分页
	 * @param wherejpql 查询条件  "o.email=? and o.account like ?"
	 * @param queryParams  查询条件占位符对应的参数值，
	 * @param orderby 排序条件  Key为属性,Value为asc/desc 如"account,desc"
	 * @return 查询结果类
	 */
	public QueryResult<Borrower> getScrollData(int page, int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby);
	/**
	 * 使借阅者是否有借阅资格
	 * @param id  用户id
	 * @param visible  :true表示有资格，
	 */
	public void makeVisible(String id, boolean visible);
	/**
	 * 根据账号用户名登陆
	 * @param account
	 * @param password
	 * @return
	 */
	public Borrower login(String account, String password);
	
}
