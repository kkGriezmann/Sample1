package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.MemberDTO;
import com.exception.MyException;

public class MemberService {

	public int memberIdCheck(String userid)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			count = session.selectOne("memberIdCheck", userid);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("멤버 아이디 체크 에러");
		}finally {
			session.close();
		}
		return count;
	}
	
	
	
	
	public void memberAdd(MemberDTO dto)throws MyException {
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.insert("MemberMapper.memberAdd", dto);
			session.commit();
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("멤버 등록 에러");
		}finally {
			session.close();
		}
	}//end memberAdd
	
	public MemberDTO login(HashMap<String, String> map)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = session.selectOne("login", map);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("로그인 에러");
		}finally {
			session.close();
		}
		return dto;
	}//end login
	
	public MemberDTO mypage( String userid)throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = session.selectOne("mypage", userid);
		}catch(Exception e) {
			//e.printStackTrace();
			throw new MyException("mypage 에러");
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
