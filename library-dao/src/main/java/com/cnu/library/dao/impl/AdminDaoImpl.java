package com.cnu.library.dao.impl;

import com.cnu.library.dao.AdminDao;
import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDaoImpl extends DaoSupport<Admin> implements AdminDao {

}
