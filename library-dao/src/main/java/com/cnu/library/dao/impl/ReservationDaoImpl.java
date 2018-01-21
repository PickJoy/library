package com.cnu.library.dao.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.cnu.library.dao.ReservationDao;
import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.Reservation;
import com.cnu.library.model.SaveBook;
import com.cnu.library.model.base.QueryResult;
import org.springframework.stereotype.Repository;

@Repository("reservationDao")
public class ReservationDaoImpl extends DaoSupport<Reservation> implements ReservationDao {

}
