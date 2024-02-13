package project;

import java.sql.*;
import java.util.*;

public class Database {
	
	stmt s = new stmt();
	
	public static void main(String[] args) {
		Database db = new Database();
		changeData cd = new changeData();
		createTable ct = new createTable();
		insertData id = new insertData();
		removeData rd = new removeData();
		viewData vd = new viewData();
		rentalbook rb = new rentalbook();
		
	    
		try {
			while(true) {

			System.out.println("[1] 테이블 생성");
			System.out.println("[2] 도서목록 추가");
			System.out.println("[3] 도서목록 삭제");
			System.out.println("[4] 도서목록 세부내용 변경");
			System.out.println("[5] 도서목록 조회");
			System.out.println("[6] 도서 대여");
			System.out.println("[7] 도서 반납");
			
			System.out.print("= 번호 입력 : ");
			Scanner s = new Scanner(System.in);
			int num = s.nextInt();
			
			switch(num) {
				case 1 :
					ct.createTable();
					break;
				case 2 :
					id.insertData();
					break;
				case 3 :
					rd.removeData();
					break;
				case 4 :
					cd.changeData();
					break;
				case 5 :
					vd.viewData();
					break;
				case 6 :
					rb.rentalbook();
					break;
				case 7 :
					rb.returnbook();
					break;
			}
		  }
		} catch(Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				stmt.stmt.close();
				stmt.con.close();	
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	
	}
}