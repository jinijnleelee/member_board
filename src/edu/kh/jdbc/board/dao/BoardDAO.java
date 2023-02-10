package edu.kh.jdbc.board.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Borad;
import static edu.kh.jdbc.common.JDBCTemplate.*;

public class BoardDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-query.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Borad> selectAllBoard(Connection conn) throws Exception{
		//결과저장용 변수 선언
		List<Borad> boardList = new ArrayList();
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("selectAllBoard");
			
			
			//st
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				//ResultSet에 저장된 값을 List 옮겨담기 
				int boardNo =rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				Borad borad = new Borad();
				borad.setBoradNo(boardNo);
				borad.setBoradTitle(boardTitle);
				borad.setMemberName(memberName);
				borad.setReadCount(readCount);
				borad.setCreateDate(createDate);
				borad.setCommentCount(commentCount);
				
				boardList.add(borad);
				
				
				
				
				
				
				
				
			}
		}finally {
			close(conn);
			close(stmt);
			
		}
		return boardList;
	}
	
	//<![CDATA[]]>

}
