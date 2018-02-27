package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.exception.MyException;

public class GoodsService {
	

	public List<GoodsDTO> goodsList(String gCategory)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = session.selectList("GoodsMapper.goodsList", gCategory);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("로그인 에러");
		}finally {
			session.close();
		}
		return list;
	}//end login
	
	
	public GoodsDTO goodsRetrieve(String gCode)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
	GoodsDTO dto = null;
		try {
			dto = session.selectOne("goodsRetrieve",gCode);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("상품 자세히 보기 에러");
		}finally {
			session.close();
		}
		return dto;
	}//end goodsRetrieve
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void xxx()throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("로그인 에러");
		}finally {
			session.close();
		}
		
	}//end login
	
	
	
	
	
	
	
	
}
