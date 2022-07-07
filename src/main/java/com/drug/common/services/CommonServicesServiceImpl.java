package com.drug.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServicesServiceImpl implements CommonServicesService {
	@Autowired
	CommonServicesDao commonServicesDao;

	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateUserName(userName);
	}


	
}
