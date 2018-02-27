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

public class OrderService {
	
	public void orderAllDone(List<OrderDTO> oList)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.insert("OrderMapper.orderAllDone",oList);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("전체 주문 에러");
		}finally {
			session.close();
		}
		
	}//end login
	
	public List<CartDTO> orderAllAdd(List<String> list)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> xxx = null;
		try {
			xxx= session.selectList("CartMapper.orderAllAdd", list);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("로그인 에러");
		}finally {
			session.close();
		}
		return xxx;
	}//end login
	
	
	
	
	
	
	
	
	
	
	//트랜잭션==> 장바구니--> 주문
		public void orderDone(OrderDTO dto, int num)throws MyException {
			SqlSession session = MySqlSessionFactory.getSession();
			try {
				int n = session.insert("OrderMapper.orderDone",dto);
				int n2 = session.delete("CartMapper.cartDelete",num);
				session.commit();
			}catch(Exception e) {
				session.rollback();
				e.printStackTrace();
				throw new MyException("로그인 에러");
			}finally {
				session.close();
			}
			
		}//end login
	
	public CartDTO orderByNum(int num)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		CartDTO dto = null;
		try {
			dto = session.selectOne("CartMapper.orderByNum", num);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("주문  에러");
		}finally {
			session.close();
		}
		return dto;
	}//end login
	
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
