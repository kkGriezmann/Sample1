package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.exception.MyException;

public class CartService {
	
	
	public void cartDeleteAll(List<String> list)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.delete("CartMapper.cartDeleteAll", list);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("장바구니 all 삭제 에러");
		}finally {
			session.close();
		}
		
	}//end login
	
	
	
	
	
	
	public void cartDelete(int num)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.delete("CartMapper.cartDelete", num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("장바구니 삭제 에러");
		}finally {
			session.close();
		}
		
	}//end login
	public void amountUpdate(HashMap<String, Integer> map)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.update("CartMapper.amountUpdate", map);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("장바구니 수량 변경 에러");
		}finally {
			session.close();
		}
		
	}//end login
	
	
	
	
	public void cartAdd(CartDTO dto)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
		   int n = session.insert("CartMapper.cartAdd", dto);
		   session.commit();
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("장바구니 저장 에러");
		}finally {
			session.close();
		}
		
	}//end login
	
	public List<CartDTO> cartList()throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> list = null;
		try {
			list = session.selectList("CartMapper.cartList");
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("장바구니 목록 에러");
		}finally {
			session.close();
		}
		return list;
		
	}//end login
	
	
	
	
	
	
	
	
	
	
	
	
}
