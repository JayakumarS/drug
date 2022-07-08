package com.drug.report.returnMemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RetrunMemoDaoImpl implements RetrunMemoDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ResultMemoResultBean> getMemoList() throws Exception {
		List<ResultMemoResultBean> objResultMemoResultBean = new ArrayList<ResultMemoResultBean>();
		try {
			objResultMemoResultBean = jdbcTemplate.query(RetrunMemoQueryUtil.getMemoList, new BeanPropertyRowMapper<ResultMemoResultBean>(ResultMemoResultBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objResultMemoResultBean;
		
	}
	
	@Override
	public List<CompleteReturnMemoDetails> getMemoDetails() throws Exception {
		List<CompleteReturnMemoDetails> objCompleteReturnMemoDetails = new ArrayList<CompleteReturnMemoDetails>();
		try {
			objCompleteReturnMemoDetails = jdbcTemplate.query(RetrunMemoQueryUtil.getMemoDetails, new BeanPropertyRowMapper<CompleteReturnMemoDetails>(CompleteReturnMemoDetails.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCompleteReturnMemoDetails;
		
	}
	
	
	@Override
	public List<CompleteReturnMemoDetails> getMemoListDetails() throws Exception {
		List<CompleteReturnMemoDetails> objCompleteReturnMemoDetails = new ArrayList<CompleteReturnMemoDetails>();
		try {
			objCompleteReturnMemoDetails = jdbcTemplate.query(RetrunMemoQueryUtil.getMemoListDetails, new BeanPropertyRowMapper<CompleteReturnMemoDetails>(CompleteReturnMemoDetails.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCompleteReturnMemoDetails;
		
	}
	
	

}
