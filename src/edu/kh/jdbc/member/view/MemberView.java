package edu.kh.jdbc.member.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static edu.kh.jdbc.main.view.MainView.*;
import edu.kh.jdbc.board.view.BoardView;
import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.dao.MemberDAO;
import edu.kh.jdbc.member.vo.Member;

public class MemberView {
	
	private Member loginMember = null;
	private MemberDAO dao = new MemberDAO();
	private MemberView service = new MemberView();
	List<Member> memberList
	private Scanner sc = new Scanner(System.in);
// 로그인 회원 정보 저장용 변수 
	public void memberMenu(Member loginMember) {
		
		int input = -1;
		//전달받은 로그인 회원 정보를 필드에 저장
		this.loginMember = loginMember;
		
		do {
			
			try {
				
				
					
					
					System.out.println("\n***** 회원제 게시판 프로그램 *******");
					System.out.println("1. 내 정보 조회");
					System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
					System.out.println("3. 내 정보 수정(이름, 성별) ");
					System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)  ");
					System.out.println("5. 회원 탈퇴");
					
					
					
					System.out.println("\n 메뉴 선택 : ");
					
					input = sc.nextInt();
					sc.nextLine(); // 입력버퍼 개행문자 제거 
					System.out.println();
					
					switch(input){
					
					case 1:  selectMyInfo(); break; //로그인
					case 2: selectAll(); break; //회원가입
					case 3: updateMember(); break; //회원가입
					case 4: updatePw(); break; //회원가입
					case 5: secession();  break; //회원가입
					
					default:
						System.out.println("메뉴에 작성된 번호만 입력해주세요");
						
					}
					
				
					
		
			
				
			}catch(InputMismatchException e) {
				System.out.println("\n <<입력 형식이 올바르지 않습니다>>");
				sc.nextLine(); //입력 버퍼에 남아있는 잘못된 문자열 제거
				System.out.println();
				

				
				
			}
			
		
		

			
		}while(input != 0 );
		
		/*
		 * 로그인 안했을때
		 * 
		 * 1. 로그인
		 * 2. 회원가입
		 * 0. 프로그램 종료
		 * 
		 * 
		 * 
		 * 
		 * ----------------------------
		 * 로그인 했을 때 
		 * 
		 * 1. 회원 기능
		 * 2. 게시판 기능
		 * 0. 로그아웃
		 * 99. 프로그램 종료
		 * 
		 * 
		 * */
		
		
	}
private void secession() {
	
	System.out.println("회원탈퇴");
	
	try {
		
		
		System.out.println("비번 입력 :");
		String memberPw = sc.next();
		
		while(true) {
			System.out.println("정말 탈퇴하시겠습니까? (y/n) :");
			char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch =='Y') {
				//서비스호출후 결과반환
				int result = service.secession(memberPw, loginMember.getMemberNo());
													//비번 ,회원번호
				if(result > 0 ) {
					
					System.out.println("탈퇴되었습니다");
					
					input = o;
					loginMember = null;
				}else {
					System.out.println("비밀벊 일치하지 않음");
				}
				
				break;
			}else if(ch =='N') {
				System.out.println("취소되었습니다");
				break;
			}else {
				System.out.println("Y또는 N만 입력해주세요");
			}
		}
	}catch(Exception e) {
		System.out.println("예외발생");
		
	}
}

private void updatePw() {
	
	
	
	
	System.out.println("비밀번호 변경 ");
	try {
		System.out.println("현재 비밀번호:  ");
		String curenPw = sc.next();
		
		String newPw1 = null;
		String newPw2 = null;
		
		while(true) {
			System.out.println("새 비밀번호");
			newPw1 = sc.next();
			
			System.out.println("새 비밀번호");
			newPw2 = sc.next();
			
			if(newPw1.equals(newPw2)) {
				break;
			}else {
				System.out.println("새 비밀번호가 일치하지 않습니다");
			}
		}
		int result = service.u
		
	
		
		
		
	}catch(Exception e) {
		System.out.println("비밀번호 변경 중 예외");
		e.printStackTrace();
		
	}
	
}


prea








private void updateMember() {
	
	
	
	
	
}
private List<Member> memberList selectAll() {
	
	try {
		
		
		if(memberList.isEmpty()) {//List가 비어있을경우 
			
			//isEmpty() : 비어있으면 true
			
			System.out.println("조회결과없습니다");
		}else {
			System.out.println("조회결ß");
			
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
	
	}
private void selectMyInfo() {
	
	String memberName = loginMember.getMemberName();
	String memberId = loginMember.getMemberId();
	String memberGender = loginMember.getMemberGender();
	String erollDate = loginMember.getEnrollDate();
	
	System.out.printf("이름 : %s\n"
			+ "아이디 : %s\n"
			+ "성별 : %s\n"
			+ "가입날짜 : %s\n", memberName,memberId,memberGender,erollDate);
}
		
		
		
		
	}
	

