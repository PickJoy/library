package com.cnu.library.service;

import com.cnu.library.model.Book;
import com.cnu.library.model.base.QueryResult;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by dell on 2016/1/20.
 */
public interface BookService {
    /**
     *
     * @param name
     * @return
     */
    public Book findByName(String name);
    /**
     * 保存实体类
     * @param entity
     */
    public void save(Book entity);
    /**
     * 根据key查询实体类
     * @param key 主键
     * @return
     */
    public Book find(Serializable key);
    /**
     * 更新实体，更新成功返回true否则false
     * @param entity 要更新的实体类
     */
    public boolean update(Book entity);
    /**
     * 删除实体
     * @param entityids 实体id数组
     */
    public void delete(Serializable...  entityids);
    /**
     * 根据条件分页查询，结果根据条件排序
     * @param page 第几页从1开始  如果为-1表示不分页
     * @param maxresult 一页的最大记录数，如果为1表示不分页
     * @param wherejpql 查询条件  "o.email=? and o.account like ?"
     * @param queryParams  查询条件占位符对应的参数值，
     * @param orderby 排序条件  Key为属性,Value为asc/desc 如"account,desc"
     * @return 查询结果类
     */
    public QueryResult<Book> getScrollData(int page, int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby);
    /**
     * 根据insb查找图书
     * @param insb
     * @return
     */
    public Book findByInsb(String insb);



}
