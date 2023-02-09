package edu.kh.jdbc.member.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.dao.MemberDAO;
import edu.kh.jdbc.member.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	
	
	
	/**
	 * @param memberId
	 * @param memberPw
	 * @return
	 * @throws Exception
	 */
	public List<Member> selectAll()throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기 
		List<Member> memberList = dao.selectAll(conn);
		

		
		
		
		// 3. 커넥션 반환
		close(conn);
		// 4. 조회 결과 반환
		return memberList;
		
	}

}
