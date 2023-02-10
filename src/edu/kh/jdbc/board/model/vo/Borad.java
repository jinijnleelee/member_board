package edu.kh.jdbc.board.model.vo;

import java.util.List;
//게시글 1개 정보를 저장하는 VO
public class Borad {
	
	private int boradNo;//게시글 번호
	private String boradTitle;//게시글 제목
	private String boardContent;//게시글 내용
	private String createDate;//작성일
	private int readCount;//조회수
	private int memerNo; //작성자 회원 번호
	

	private String memberName; //작성자 회원 이름
	private int commentCount; 	//댓글 수 
	
	private List<Comment> commentList;
	//댓글 목록
	
	
	public Borad() {}


	public int getBoradNo() {
		return boradNo;
	}


	public void setBoradNo(int boradNo) {
		this.boradNo = boradNo;
	}


	public String getBoradTitle() {
		return boradTitle;
	}


	public void setBoradTitle(String boradTitle) {
		this.boradTitle = boradTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getMemerNo() {
		return memerNo;
	}


	public void setMemerNo(int memerNo) {
		this.memerNo = memerNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}


	public List<Comment> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	

	
	
	
	

}
