package edu.kh.jdbc.member.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.vo.Member;

public class MemberDAO {

	

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	//Map<String:String>제한 , XML파일을 읽고 쓰는데 특화

	
	public MemberDAO() {
		try{
			//Properties 객체 생성
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("member-query.xml"));
			//member-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
public List<Member> selectAll (Connection conn)throws Exception {
		
		// 1. 결과 저장용 변수 선언
		List<Member> memberList = new ArrayList();
		
		
		
		try {
			
		
		// 2. SQL 얻어오기 (main-query.xml 파일에 작성된 SQL)
			
			String sql = prop.getProperty("selectAll");
			
			// 3. PrepareStatement 객체 생성
			
			stmt = conn.createStatement();
			

			

			
			
			// 5. SQL (seleㅊt) 수행결과 (ResyltSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			//6. 조회결과가 있ㄲ을경우
			//컬럼값을 모두 얻어와
			//Member 객체를 생성해서 loginMember 대입
			
			if(rs.next()) {
				
			//	String memberNo = rs.getInt("MEMBER_NO");
				//한번만 쓸거라 변수 안만들어도 됨 
				
			 memberList.add(new Member(
					 rs.getString("MEMBER_ID"),
					rs.getString("MEMBER_NM"),
					rs.getString("MEMBER_GENDER") ));
			
				
			}
			
			
		}finally {
			//7. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(stmt);
			
		}
		
		
		//8. 조회결과 반환
		return memberList;
	}


	
}
