package edu.kh.jdbc.board.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Borad;
import edu.kh.jdbc.main.view.MainView;
import edu.kh.jdbc.member.vo.Member;
import static edu.kh.jdbc.main.view.MainView.*;

public class BoardView {


	public static void boardMenu() {
		private BoardService bService = new BoardService();
	Scanner sc = new Scanner(System.in);
		
		int input = -1;
		do {
			try {
				System.out.println("게시판 기능");
				System.out.println("게시판 목록 조회");
				System.out.println("게시판 상세 조회");
				System.out.println("게시판 작성");
				System.out.println("게시판 검색");
				System.out.println("메인메뉴 이동");
				
				System.out.println("메뉴 선택 ");
				input = sc.nextInt();
				
				System.out.println("");
				
				switch(input) {
				case 1: selectAllBoard(); break;
				case 2:   insertBoard(); break;
				
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}while(input != 0){
			
		}
		
		
			

}catch(
Exception e) {
e.printStackTrace();
System.out.println("게시글 목록 조회 중 예외 발생");
}

	

	private  void selectAllBoard() {
		System.out.println("게시글목록조회");
		
		try {
			List<Borad> boardList = bService.selectAllBoard();
			
			if(boardList.isEmpty()) {//조회결과가 없을경우
				
			}else {
				for(Borad b : boardList) {
					
					System.out.printf("%d | %s[%d] | %s | %s | %d\n",
							b.getBoradNo(), 
							b.getBoradTitle(), 
							b.getCommentCount(),
							b.getMemberName(),
							b.getCreateDate(),
							b.getReadCount());
				}
				
				
			}
				
				

		
		
		private void insertBoard() {
			System.out.println("게시글 등록");
			
			System.out.println("제목");
			String boardTitle = sc.nextLine();
			
			String boardContent = inputcontent();
			
			
			//Board 객체에 제목, 내용, 회원 번호를 담아서 서비스에 전달
			Borad borad = new Borad();
			borad.setBoradTitle(boardTitle);
			borad.setBoardContent(boardContent);
			borad.setMemerNo(LoginMember.getMemberNo());
			
			int result = bService.insertBoard(borad);
		}
		
		
		private String inputcontent() {
			String content = "";
			String input = null;
			
			System.out.println("입력종료시 ($exit) 입력");
			
			while(true) {
				input = sc.nextLine();
				if(input.equals("$exit")) {
					break;
				}
				//입력된 내용을 content 에 누적
				content +=input + "\n";
				
			}
			return content;
		}
			
			
			
			
			
			
		
		
		
		
		
			
		}
		
			
		}

