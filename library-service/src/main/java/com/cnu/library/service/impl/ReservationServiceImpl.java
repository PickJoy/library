package com.cnu.library.service.impl;

import com.cnu.library.dao.ReservationDao;
import com.cnu.library.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {
	private ReservationDao reservationDao;

	public ReservationDao getReservationDao() {
		return reservationDao;
	}
	@Resource
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	
}
