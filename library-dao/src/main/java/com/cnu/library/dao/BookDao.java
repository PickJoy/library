package com.cnu.library.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.cnu.library.dao.base.DAO;
import com.cnu.library.model.Book;
import com.cnu.library.model.base.QueryResult;

public interface BookDao extends DAO<Book> {
    public Book findByName(String name);
}
